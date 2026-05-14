package com.test.java.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.test.java.tool.ClothTool;
import com.test.java.tool.WeatherTool;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiService {
	
	private final ChatClient chatClient;
	private final WeatherTool tool;
	private final ClothTool ctool;

	public String weather(String message) {
		
		/*
		
			Tool Calling 을 이용한 질문을 했을 때 벌어지는 일
			1. 오늘 대한민국 서울에 비 와?
			2. 1번을 LLM에 요청(질문)
			3. LLM이 질문을 판단을 했더니 날씨를 모름(내가 아는 지식만으로는 이걸 모를것같음)
			4. 그러면 다시 나한테(return chatClient.prompt() .. <- 이 부분) 
			와서(다시 Spring 으로 와서) 도구를 호출함
			5. 도구를 호출해서 알아낸 날씨를 갖고 LLM을 다시 요청(질문)함
			6. 최종 응답 출력
			- 요청 -> 생각 -> 요청 즉 왔다갔다를 많이 함. 처음 요청하자마자
			LLM이 바로 판단해서 도구를 바로 쓰는게 아님
			
		*/
		
		// 이렇게만 해두면 LLM은 날씨를 모르니까
		// Tool Calling 이 필요함 -> .tools() 작성
		return chatClient.prompt()
					.user(message)
					.tools(tool, ctool) // 이런 Tool 이 있다고 LLM 에게 알려줌
					.call()
					.content();
	}
}
