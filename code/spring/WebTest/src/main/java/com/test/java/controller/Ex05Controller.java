package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// 주소를 클래스 수준에서 명시할 수 있지만
// @RequestMapping(value ="/ex05.do")
public class Ex05Controller {
	
	// 주소를 메서드 수준에서 명시를 할 수 있음
	@RequestMapping(value ="/ex05.do")
	public String ex05() {
		return "ex05";
	}
	// method는 무조건 명시적으로 써주는게 좋다
//	@RequestMapping(value ="/ex05get.do", method=RequestMethod.GET)
	@GetMapping(value = "/ex05get.do") // 윗줄의 간결한 버전
	public String ex05get() {
		return "ex05get";
	}
	
	// 이런 일들이 서블릿으로 치면 하나의 서블릿에
	// doGet doPost 둘 다 동시에 만든 것이라고 보면 됨
//	@RequestMapping(value ="/ex05post.do", method=RequestMethod.POST)
	// 만약 에러가 난다? 스프링 버전 확인
	@PostMapping(value = "/ex05post.do") // 윗줄의 간결한 버전
	public String ex05post() {
		return "ex05post";
	}
	
	// 메서드 이름이 예약어가 아니기 때문에
	// 이렇게 하면 오류남(모호한 예약어? 로)
//	@RequestMapping
//	public String ex05get() {
//		return "ex05get";
//	}
}
