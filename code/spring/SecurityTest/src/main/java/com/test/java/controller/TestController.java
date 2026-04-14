package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//5. 패키지 + 파일
@Controller
public class TestController {

	@GetMapping(value = "/index.do")
	public String index(Model model) {		

		System.out.println("TestController -> 모든 사용자 페이지");
		return "index";
	}
	
	@GetMapping(value = "/member.do")
	public String member(Model model) {

		System.out.println("TestController -> 회원 전용 페이지");
		return "member";
	}
	
	@GetMapping(value = "/admin.do")
	public String admin(Model model) {

		System.out.println("TestController -> 관리자 전용 페이지");
		return "admin";
	}
	
}
