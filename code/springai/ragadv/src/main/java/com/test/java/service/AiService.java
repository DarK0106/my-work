package com.test.java.service;

import java.io.IOException;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiService {

	private final ChatClient chatClient;
	private final JdbcClient jdbcClient;
	private final VectorStore vectorStore;

	public List<String> files() {

		String sql = """

					select distinct metadata ->> 'file_name'
					from vector_store
					where metadata ->> 'file_name' is not null

				""";

		return jdbcClient.sql(sql).query(String.class).list();
	}

	public void embed(MultipartFile attach) throws IOException {

		String filename = attach.getOriginalFilename();

		// 문서 로딩
		ByteArrayResource resource = new ByteArrayResource(attach.getBytes());
		TikaDocumentReader reader = new TikaDocumentReader(resource);
		List<Document> documents = reader.get();

		// 문서들마다 메타 데이터에 추가(데이터 삭제 구현을 위해 작성)
		documents.forEach(doc -> doc.getMetadata().put("file_name", filename));

		// 청킹
		TokenTextSplitter splitter = new TokenTextSplitter();

		List<Document> splitDocs = splitter.apply(documents);

		// 저장
		vectorStore.accept(splitDocs);

	}
	
	// 삭제(관련 벡터까지 모두 삭제)
	public void del(String filename) {

		String sql = "delete from vector_store where metadata ->> 'file_name' =?";
		jdbcClient.sql(sql).param(filename).update();
		
	}
	
	// LLM과 대화
	public String chat(String message) {
		
		// RAG 기반 검색
		// 무조건 RAG 를 붙인다고
		// LLM이 "아 이걸 기반으로 답해야겠다"
		// 라고 알아서 생각하지 않음
		
		// System Message 없음: LLM이 일반 지식을 섞어서 대답할 확률이 높다
		// System Message 있음: 문서 기반으로 대답할 확률이 높다
		
		/*
			
			RAG 검색 옵션
			1. similarityThreshold
				- 유사도(가져올 청크의 품질)
				- 코사인 유사도를 사용
				- 0 ~ 1, 1로 갈수록 더 엄격한 유사도를 요구함
				하지만 너무 높이면 검색 결과가 0건이 되어 LLM이
				모르겠는데요? 할 수 있음
				- 기본값: 0.0
				
			2. topK
				- 가져온 청크 중 유사도 높은 순으로 개수를 제한함
				- 기본값: 4, 개수가 늘어날 수록 엉뚱한 답변이 나옴
				
			similarityThreshold가 극단적으로 크면
			- 관련도가 아주 높은 것만 가져옴
			- 그래서 답변이 굉장히 명확하고 깔끔함
			- 유사도가 낮은 것 중에서도 필요한 정보가 있을 수 있기 때문에
			그런 것들이 검색에서 빠질 확률이 높음(문서를 못 찾을 가능성이 높다.)
			
			similarityThreshold가 극단적으로 낮으면
			- 문서를 더 쉽게 가져온다
			- 그래서 답변이 잘 나오지만
			자료와는 관련없는 대답을 할 확률이 높다
			
			topK가 크면
			- 자료를 많이 가져온다
			- 답변에 사용할 재료는 많아지지만,
			관련 없는 내용도 섞여 답변의 품질이 떨어질 수 있다.
			
			topK가 작으면
			- 자료를 적게 가져온다
			- 답변이 정확하고 깔끔해지지만,
			필요한 문서가 빠질 수 있다.
			
			topK=8, similarityThreshold=0 : 넉넉하게
			topK=8, similarityThreshold=0.5 : 적당히 관련됨
			topK=5, similarityThreshold=0.6 : 중간값
				
			
		*/
		return chatClient.prompt()
				.system("""
					    당신은 업로드된 문서를 기반으로 답변하는 RAG assistant입니다.
					
					    답변 규칙:
					    1. 반드시 제공된 참고 문서 내용에 근거해서만 답변하세요.
					    2. 참고 문서에 없는 내용은 추측하지 말고 "문서에서 확인할 수 없습니다."라고 답변하세요.
					    3. 일반 지식, 사전 지식, 인터넷 지식을 섞지 마세요.
					    4. 답변은 한국어로 작성하세요.
					    5. 가능한 경우 핵심 내용을 먼저 요약하고, 필요한 세부 내용을 뒤에 설명하세요.
						""")
				.user(u -> u.text("""
						사용자의 질문에 답변하세요.
						
						질문:
						{question}						
						""").param("question", message))
				.advisors(
					QuestionAnswerAdvisor.builder(vectorStore)
						.searchRequest(SearchRequest.builder()
													.similarityThreshold(0.55)
													.topK(5)
													.build())
						.build()	
				)
				.call()
				.content()
				;
	}

}
