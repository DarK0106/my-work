package com.test.java.service;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

// LLM이 우리가 넣어놨던 PDF 파일을 읽어서
// 대답에 반영할 수 있도록 하기 위해 작성
@Component
@RequiredArgsConstructor
public class DataLoader {
	
	// 벡터 DB 조작을 위해 의존 주입(주로 INSERT, SELECT)
	private final VectorStore vectorStore;
	// SQL을 직접 실행할 때
	private final JdbcClient jdbcClient;
	
	
	@Value("classpath:SPRi AI Brief_12월호_산업동향_1208_F.pdf")
	private Resource pdfResource;
	
	public void load() {
		/*
		 	
		 	RAG 처리
		 	1. PDF 파일 -> 읽기
		 	2. 내용을 조각내기(덩어리가 너무 크니까)
		 	   == 청킹(Chunking)
		 	   -> 조각난 문자열 == 청크(Chunk)
		 		- 조각내는 방법
		 			- 문단으로
		 			- 문장으로
		 			- 일정 글자 수로(100~500자)
		 	3. 청크를 벡터화
		 		- 문장을(청크를) 토큰으로 만들어서 그걸 벡터화함
		 		- 그런 다음 토큰을 벡터화한걸 또 병합해서
		 		- 문장으로 만들어서 그걸 또 벡터화함
		 		- 벡터? 얼마나, 어느 방향으로 ..
		 		- 예) 강아지: 1
		 			  멍멍이: 1.1
		 			  고양이: 3
		 		- yml에서 dimensions: 1536 이게 1536차원이라는 것
		 	
		 	4. DB에 저장
		 		- Vector Database
		 		- 이걸 할려고 설치한게 PGVector
		
			1. LLM 에게 질문
				- 미리 학습된 내용에 대한 답변은 잘 하지만
				일반적이지 않은 내용(= 미리 학습하지 않은 내용)에
				대한 답변은 잘 할 수 없음
			
			2. 질문을 벡터화
				- 내가 만약에 코카콜라에 대한 질문을 했음
				그러면 이 질문을 벡터화하면 
				코카콜라, 탄산음료 .. 얘네들이랑
				벡터값이 비슷함
			
			3. Vector DB에 검색을 해서 질문과 유사한 청크들을 가져옴
				- 벡터화한 질문과 연관있는(가까운) 
				벡터값을 가진 데이터를 뽑아옴
			
			4. 원래 질문(1번)과 청크들(3번)을 한꺼번에 LLM에 넘김
			
			// 임베딩: 문서 -> 청킹 -> 벡터 -> 벡터 DB
			
		*/
		
		// 문서 로딩
		TikaDocumentReader reader = new TikaDocumentReader(pdfResource);
		List<Document> documents = reader.get();
		
		// 문서들마다 메타 데이터에 추가(데이터 삭제 구현을 위해 작성)
		String fileName = pdfResource.getFilename();
		documents.forEach(doc -> doc.getMetadata().put("file_name", fileName));
		
		// 청킹
		TokenTextSplitter splitter = new TokenTextSplitter();
		
		List<Document> splitDocs = splitter.apply(documents);
		
		// 저장
		vectorStore.accept(splitDocs);
		
		System.out.println("임베딩된 데이터 수: " + splitDocs.size());
		
	}

	public void del() {
		
		String filename = pdfResource.getFilename();
		
		String sql = "delete from vector_store where metadata ->> 'file_name' = ?";
		
		int count = jdbcClient.sql(sql).param(filename).update();

		System.out.println("삭제된 데이터 수: " + count);
		
	}

}
