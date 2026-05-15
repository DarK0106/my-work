package com.test.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.java.service.DataLoader;

@SpringBootApplication
public class ChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}
	
	// DataLoader가 임베딩을 하는 시점(사이트를 시작할 때)을 설정하기 위해
	// 서버가 시작될 때 딱 1번 실행되는 녀석
	@Bean
	CommandLineRunner init(DataLoader dataLoader) {

		// 사이트가 시작될 때
		return args -> {

			// 이미 임베딩된 매뉴얼이 있으면 스킵 (재시작마다 OpenAI 임베딩 비용 발생 방지)
			if (dataLoader.isAlreadyLoaded()) {
				System.out.println("매뉴얼이 이미 임베딩되어 있어 적재를 건너뜁니다.");
				return;
			}

			// 안전을 위해 잔여 데이터 삭제 후 새로 적재
			dataLoader.delete();
			dataLoader.load();

		};

	}

}
