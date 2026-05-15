package com.test.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

// 텍스트를 가져와서 라인 단위로 잘라서
// 청크화를 시켜서 (임베딩) pgvector에 넣는 클래스
// 1회성으로만 학습을 시켜야 하는데 그 시점이 중요
// 서버가 시작되면 딱 1번만 실행되도록
// ChatbotApplication에 Bean으로 만들어둠
@Component
@RequiredArgsConstructor
public class DataLoader {

	private final VectorStore vectorStore;
	private final JdbcClient jdbcClient;

	// 매뉴얼 가져오기
	@Value("classpath:호텔 매뉴얼.txt")
	private Resource manual;

	// 이미 임베딩된 매뉴얼이 있는지 확인
	public boolean isAlreadyLoaded() {
		String filename = manual.getFilename();
		String sql = "select count(*) from vector_store where metadata ->> 'file_name' = ?";
		Integer count = jdbcClient.sql(sql).param(filename).query(Integer.class).single();
		return count != null && count > 0;
	}

	// 새로운 데이터 임베딩
	public void load() {

		TikaDocumentReader reader = new TikaDocumentReader(manual);
		// 위에 녀석이 이녀석을 읽어와서
		List<Document> documents = reader.get(); // 덩어리 상태임
		
		String filename = manual.getFilename();
		List<Document> splitDocs = new ArrayList<>();
		
		// 줄 단위 분할한 다음
		for (Document doc : documents) {
			
			// 문단
			String fullContent = doc.getFormattedContent();
			
			String[] rules = fullContent.split("\\R");
			
			for (String rule : rules) {
				
				if (rule.trim().isEmpty()) continue;
				
				Document ruleDoc = new Document(rule.trim());
				ruleDoc.getMetadata().put("file_name", filename);
				
				splitDocs.add(ruleDoc);
				
			}
			
		}
		
		//PGVector에 저장
		if (!splitDocs.isEmpty()) {
			vectorStore.accept(splitDocs);
			
			System.out.println("임베딩 완료: " + splitDocs.size());
		}
		
	}
		
		// 기존 데이터 삭제 로직
		// 서버 시작되면 일단 데이터 삭제 한 번 함
		public void delete() {
		
		String filename = manual.getFilename();
		
		String sql = "delete from vector_store where metadata ->> 'file_name' = ?";
		
		int count = jdbcClient.sql(sql).param(filename).update();
		
		System.out.println("매뉴얼 삭제: " + count);
		
	}

}
