package com.test.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.java.mapper.AddressMapper;
import com.test.java.model.AddressDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	// 스프링 부트가 인터페이스를 의존 주입하라고 시키면
	// 인터페이스를 상속받는 임시 자식 클래스를 만든다
	// 그러고 객체를 의존 주입 받음
	// 인터페이스가 bean이 되기 위해서
	// @Mapper라는 어노테이션을 붙여야함
	private final AddressMapper mapper;

	@GetMapping("/m1")
	public String m1(Model model) {

		//		int count = mapper.count();
		//		System.out.println(count);

		// 값을 뷰에 전달해서 출력해보자
		// 뷰는 무언가를 출력하기 위해서
		// 만들어진 역할
		// Thymeleaf에선 어떻게 하는지 보자

		// 1. 단일값 출력
		int count = 200;
		String name = "홍길동";

		model.addAttribute("count", count);
		model.addAttribute("name", name);

		// 2. 객체 출력
		AddressDto dto = mapper.get(1);

		model.addAttribute("dto", dto);

		// Map 출력
		Map<String, String> map = new HashMap<String, String>();

		map.put("red", "빨강");
		map.put("blue", "파랑");
		map.put("yellow", "노랑");

		model.addAttribute("map", map);

		// resources -> templates -> m1.html
		// 이렇게 찾기로 이미 약속이 되어있음
		return "m1";
	}

	@GetMapping("/m2")
	public String m2(Model model) {
		AddressDto dto = mapper.get(1);

		model.addAttribute("dto", dto);

		return "m2";
	}

	@GetMapping("/m3")
	public String m3(Model model) {

		// 타임리프 표현식: 연산자
		int a = 10;
		int b = 3;

		// 이름을 제대로 찾아오면 이름 출력
		// 이름을 찾지 못하면 '익명' 이라는 글자를 출력
		// 라는 상황
		//		String name = "엄길동";
		String name = null;

		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("name", name);

		return "m3";
	}

	@GetMapping("/m4")
	public String m4(Model model) {
		
		model.addAttribute("count", 100);
		model.addAttribute("name", "호날두");
		model.addAttribute("color", "cornflowerblue");
		
		
		return "m4";
	}

}

/*
@GetMapping("/m")
public String m(Model model) {
	
	return "m";
}
*/
