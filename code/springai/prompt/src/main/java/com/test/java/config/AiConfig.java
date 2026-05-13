package com.test.java.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AiConfig {
	// m1
//	@Bean
//	public ChatClient chatClient(ChatClient.Builder builder) {
//		
//		// AI한테 역할 설정해주기
//		return builder
//				.defaultSystem("당신은 SF 영화 전문가입니다. 실력있는 영화 전문가답게 영화에 대한 대답을 전문성 있고 간결하게 대답하시오.")
//				.build();
//	}

	// 역할 설정해주는건 Config에 일일이
	// 작성하면 너무 어지러우니까
	// prompt.txt로 따로 빼서 작성해놓고
	// 가져오는 방식으로 하자
	@Value("classpath:/prompt.txt")
	private Resource prompt;

	// m2
//	@Bean
//	public ChatClient chatClient(ChatClient.Builder builder) {
//		
//		return builder
//				.defaultSystem(prompt)
//				.build();
//	}

	// m3~m8, m10
	// 스프링이니까 빈으로 만든거고
	// AI랑 대화하기 위한 핵심
	@Bean
	public ChatClient chatClient(ChatClient.Builder builder) {
		
		return builder
				.build();
	}
	
	/*
	// m9
	@Bean
	public ChatClient chatClient(ChatClient.Builder builder) {

		// 이전 방식: InMemoryChatMemory
		// 현재 방식: ChatMemoryRepository + MessageWindowChatMemory
		
//			Chat Memory - 이전 대화 내용 요약 -> 임시 메모리 저장 -> 다음 대화 추가
//		 	
//		 	1. ChatMemoryRepository: 대화 기록을 저장하는 서비스 
//  		2. MessageWindowChatMemory: 최근 N개의
//  		메시지만 기억하는 메모리 구현체
//  		3. MessageChatMemoryAdvisor: ChatClient로 호출해서 
//  		프롬프트를 보내기 직전에 이전 대화를 프롬프트로 포함시키는 Advisor
//  
//  		.maxMessages(3)
//			- 최근 메시지 3개까지만 메모리에 유지해라
//			- 질문/답변이 1쌍이 아니라, 각각 따로 개수로 잡힌다.
//			- 수치 크게 잡음 -> 기억량 증가 + 토큰량 증가
		 
		return builder
			.defaultAdvisors(
	            MessageChatMemoryAdvisor.builder(
	                MessageWindowChatMemory.builder()
	                    .chatMemoryRepository(new InMemoryChatMemoryRepository())
	                    .maxMessages(3)
	                    .build()).build()
		    )
			.build();

	}
	*/
}
