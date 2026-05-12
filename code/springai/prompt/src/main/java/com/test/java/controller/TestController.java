package com.test.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.java.service.AiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final AiService aiService;
	
	@GetMapping(value = "/m1")
	public ResponseEntity<?> m1(Model model, @RequestParam("message") String message) {
				
		// /m1?message=질문
		// /m1?message=너는 누구니?
		/*
			
			System Message
			- AI Model에게 역할을 부여하는 메시지
			- 페로소나 지정하는 역할
			- 절대적이진 않음
			
			User Message
			- 사용자가 직접 입력하는 질문
			
			Assitant Message
			- AI의 이전 답변을 AI 가 요약을 해줌
			
			Tool Response Message
			- 도구 호출 결과 -> 
	
		*/
		
		String result = aiService.m1(message);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/m2")
	public ResponseEntity<?> m2(Model model, @RequestParam("message") String message, @RequestParam("subject") String subject, @RequestParam("wordCount") String wordCount) {
		
		// /m2?message=빅맥 영양 성분 설명해줘&subject=음식&wordCount=10
		// /m2?message=스프링 DI에 대해서 설명해줘&subject=스프링&wordCount=20
		
		String result = aiService.m2(message, subject, wordCount);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/m3")
	public ResponseEntity<?> m3(Model model, @RequestParam("food") String food, @RequestParam("style") String style) {
		
		// /m3?food=스파게티&style=영국식
		// /m3?food=스파게티&style=미국식
		// /m3?food=스파게티&style=일본식
		
		String result = aiService.m3(food, style);
		
		return ResponseEntity.ok(result);
	}
}
