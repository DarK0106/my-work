package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/ex04post.do", method = RequestMethod.POST)
public class Ex04PostController {
	// method = RequestMethod.POST 이런 식으로 명시해두면
	// 이 요청 메서드는 doPost() 메서드와 똑같은 역할을 한다
	@RequestMapping
	public String ex04post() {
		return "ex04post";
	}
}