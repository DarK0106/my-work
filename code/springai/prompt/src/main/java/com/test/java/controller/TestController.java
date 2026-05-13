package com.test.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.java.entity.Answer;
import com.test.java.entity.Food;
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
	
	// 웹페이지를 통해 질문하고
	// 결과도 웹페이지로 볼 수 있게 뷰를 만들자
	@GetMapping(value = "/m4")
	public String m4(Model model) {
		
		/*
		 	토큰, Token
		 		- 컴퓨터가 해석할 수 있는 최소 단위의 문자
		 		- 예) 안녕하세요, 저는 홍길동입니다.
		 		- 예) Hello,(토큰) My(토큰) name(토큰) is(토큰) Hong(토큰).
		 		- AI 모델들은 토큰 기준으로 돈을 받음
		 		- aaaaaaaaaaaaaaaaa <- 이것도 1토큰이고
		 		- aaa <- 이것도 1토큰임
		 		- 한글이 조사나 접미어같은게 있어서 한글이 문제임
		 		- 형태소 분석을해야하고 동음이의어도 있고
		 		- 같은 단어라도 어미에 뭐가 오냐에 따라 의미가 달라져서
		 		- 같은 의미의 같은 문장을 한글로 보내면 한글이 유독 토큰이 많이 소모됨
		 		
		 		입력 토큰은 싸다. AI가 읽기만 하면 되기 때문
		 		출력 토큰은 AI가 생각을 해야 하기 때문에 비싸다
		*/
		
		return "m4";
	}
	
	@PostMapping(value = "/m4")
	public String m4ok(Model model, @RequestParam("message") String message) {
		
		ChatResponse resp = aiService.m4(message);
		
		model.addAttribute("resp", resp);
		 
		return "m4";
	}
	
	
	/*
	@GetMapping(value = "/m4")
	public String m4(Model model) {
		
		return "m4";
	}
	
	@PostMapping(value = "/m4")
	public String m4ok(Model model, @RequestParam("message") String message) {
		
		return "m4";
	}
	*/
	
	@GetMapping(value = "/m5")
	public String m5(Model model) {
		
		return "m5";
	}
	
	@PostMapping(value = "/m5")
	public String m5ok(Model model, @RequestParam("message") String message) {
		/*
			Entity 로 응답받기
			- DTO나 VO 같은 Entity로 받을 수 있다.
			- 우리가 하던 JPA 에서의 Entity 랑은 다른 놈임
			- Spring MVC 에서의 주고 받는 데이터 상자를 Entity 라고 부름
			
			AI 질의 > AI 응답
			- 응답 구조 > 일반적인 문장으로 구성 > 구조화(X)
			- 응답 구조 > 정형화 > 프로그램에 접근 용이
			
			
			chatClient 응답 메서드
			- .content(): 단순 응답. 구조가 없는 문자열. 단순 대화형 작업
			- .chatResponse(): 비즈니즈 로직에서는 사용 안함. 운영/관리용으로 사용.
			- .entity(): 형식을 갖춘 DTO. 대부분의 비즈니스 로직에 사용
		*/
		Answer answer = aiService.m5(message);
		
		model.addAttribute("answer", answer);
		
		return "m5";
	}

	@GetMapping(value = "/m6")
	public String m6(Model model) {
		
		//- /m6?message=햄버거 재료를 알려줘
		
		return "m6";
	}
	
	@PostMapping(value = "/m6")
	public String m6ok(Model model, @RequestParam("message") String message) {
		
		List<String> result = aiService.m6(message);
		
		model.addAttribute("result", result);
		
		return "m6";
	}
	
	@GetMapping(value = "/m7")
	public String m7(Model model) {
		
		
		return "m7";
	}
	
	@PostMapping(value = "/m7")
	public String m7ok(Model model, @RequestParam("message") String message) {
		
		//- /m7?message=국가별로 국가명과 해당 국가에서 사용하는 표현 단위를 알려줘
		Map<String,Object> result = aiService.m7(message);
		
		model.addAttribute("result", result);
		 
		return "m7";
		
	}
	
	@GetMapping(value = "/m8")
	public String m8(Model model) {
		
		return "m8";
	}
	
	@PostMapping(value = "/m8")
	public String m8ok(Model model, @RequestParam("message") String message) {
		
		List<Food> result = aiService.m8(message);
		
		model.addAttribute("result", result);
		
		return "m8";
	}
	
	@GetMapping(value = "/m9")
	public String m9(Model model) {
		
		return "m9";
	}
	
	@PostMapping(value = "/m9")
	public String m9ok(Model model, @RequestParam("message") String message) {
		/*
			질문: 내 이름은 홍길동이야.
			후속 질문: 내가 누구라고?
			
			후속 질문에 대한 답변 -> 누군지 모름
			
			기본적으로 LLM의 요청과 관련된 데이터만 기억을 한다.
			요청이 완료되면 이전 요청에 대한 그 어떤 데이터도 기억을 못한다.
			
			해결 방법:
				- 이전 대화 내용을 덧붙여서 다음 질문에 같이 보낸다.
		*/
		
		// 이번엔 대답만 얻어와보자
		String result = aiService.m9(message);
		
		model.addAttribute("result", result);
		
		return "m9";
	}
	
	@GetMapping(value = "/m10")
	public String m10(Model model) {
		
		return "m10";
	}
	
	@PostMapping(value = "/m10")
	public String m10ok(Model model, @RequestParam("message") String message) {
		
		// AI Model에는 Temperature가 있다
		// - temperature: 0.2 로 설정해놨었음
		// - 0 ~ 1 까지 있음
		// - 0: MBTI 로 치면 T -> 이성적 대답, 사실적 대답, 직업으로 따지면 과학자
		// - 1: MBTI 로 치면 F -> 창의적 대답, 직업으로 따지면 철학자, 엉뚱한(창의적인)
		// 대답이 많이 나옴
		// 이 온도가 근데 LLM 만든 사람도 제대로 완벽하게 통제를 못함
		
		String result = aiService.m10(message);
		
		model.addAttribute("result", result);
		
		return "m10";
	}
}
