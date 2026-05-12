package com.test.java.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiService {

	private final ChatClient chatClient;

	public String m1(String message) {
		
		// Default System Message 보다 우선순위가 더 높다
		return chatClient.prompt().system("당신은 한국 영화 전문가입니다.").user(message).call().content();
	}

	public String m2(String message, String subject, String wordCount) {
		
		return chatClient.prompt().user(message).system(sp -> sp.param("subject", subject).param("wordCount", wordCount)).call().content();
	}

	public String m3(String food, String style) {
		
		/*
		 
			System Message = 설정, 규칙
				- 목적: AI의 페르소나(=인격), 어떤 행동에 대한 규칙, 답변 스타일
			User Message = 요구, 요청
				- 실제 처리해야 할 요구사항(=질문 그 자체)
		 
		*/
		// String.format()과 거의 동일하지만 가독성 높음
		String txt = "'{food}' 음식에 대한 '{style}' 방식의 조리법을 간단하게 알려줘";
		
		return chatClient.prompt()
					.user(sp -> sp.text(txt)
							      .param("food", food)
							      .param("style", style))
					.call()
					.content()
					;
	
	}

}
