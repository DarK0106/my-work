package com.test.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import com.test.java.entity.Answer;
import com.test.java.entity.Food;

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

	public ChatResponse m4(String message) {

		return chatClient.prompt().user(message).call().chatResponse();
	}

	public Answer m5(String message) {
		
		return chatClient.prompt("""
                사용자의 질문에 등장하는 음식 또는 요리를 기준으로 답변해라.

                응답은 다음 필드를 반드시 모두 채워라.

                answer:
                - 사용자 질문에 대한 최종 답변을 넣어라.
                - 해당 음식이 어떤 음식인지 간단히 설명해라.

                names:
                - 해당 음식에 일반적으로 들어가는 대표 재료명을 배열에 넣어라.
                - 재료가 여러 개이면 각각 배열 요소로 나누어 넣어라.
                - 알 수 있는 대표 재료가 있으면 반드시 빈 배열로 두지 마라.
                - 정말 알 수 없을 때만 빈 배열을 사용해라.

                count:
                - names 배열에 들어간 재료명의 개수를 넣어라.
                - 반드시 정수로 넣어라.
                - count 값은 names.length와 같아야 한다.

                color:
                - 해당 음식이 건강한 음식인지, 주의가 필요한 음식인지 색상으로 표현해라.
                - 대체로 건강한 음식이면 "green"
                - 건강한 재료와 부담되는 재료가 섞여 있으면 "yellow"
                - 고열량, 고지방, 고나트륨 등으로 자주 먹기 부담스러운 음식이면 "red"
                - 건강 여부를 판단하기 어려운 단순 정보이면 "blue"

                예시:
                사용자가 "햄버거에 대해 알려줘"라고 물으면,
                names에는 "빵", "패티", "양상추", "토마토", "치즈", "소스" 같은 대표 재료를 넣어라.
                count는 names 배열의 개수와 같게 넣어라.
                color는 일반적인 햄버거의 건강성을 기준으로 판단해라.

                설명 문장을 따로 붙이지 말고 지정된 구조로만 응답해라.
                """).user(message).call().entity(Answer.class);
	}
	
	public List<String> m6(String message) {
		
		/*
		
			.entity(Dto.class)
			- 무조건 반환값을 JSON으로 받는다.
			- 내부 > jackson 사용
			- List or Map 으로 결과를 받을 수 있다.
		
		*/
		
		return chatClient.prompt()
				.user(message)
				.call()
				.entity(new ListOutputConverter(new DefaultConversionService()));
	}

	public Map<String, Object> m7(String message) {
		
		return chatClient.prompt()
				.user(message)
				.call()
				.entity(new MapOutputConverter())
				;
	}
	/*
	public List<Food> m8(String message) {

		return chatClient.prompt().user(message).call().entity(new ParameterizedTypeReference<List<Food>>() {
		});
	}
	*/
	
	// 안정성이 더 높은 버전
	public List<Food> m8(String message) {
		
		return chatClient.prompt()
				.system("""
						
						사용자의 요청에 맞는 음식 또는 간식 목록을 작성해줘
						
						각 항목은 다음 의미로 채워줘
						- name: 음식 or 간식의 이름
						- calorie: 1회 제공량 기준 예상 칼로리(Cal). 반드시 정수로 작성해줘
						
						여러 개의 항목을 반환해줘
						요구한 내용이 아닌 불필요한 답변은 생략해줘
						""")
				.user(message).call().entity(new ParameterizedTypeReference<List<Food>>() {
		});
	}

	public String m9(String message) {

		return chatClient.prompt()
				.user(message)
				.call()
				.content();
	}

	public String m10(String message) {
		return chatClient.prompt()
				.user(message)
				.call()
				.content();
	}

}
