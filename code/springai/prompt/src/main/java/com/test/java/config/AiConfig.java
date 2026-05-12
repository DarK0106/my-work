package com.test.java.config;

import org.springframework.ai.chat.client.ChatClient;
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
	
	// m3
	@Bean
	public ChatClient chatClient(ChatClient.Builder builder) {
		
		return builder
				.build();
	}
}
