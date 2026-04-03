package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ex04.do")
public class Ex04Controller {
	// value 옆에 method = { RequestMethod.GET, RequestMethod.GET }
	// 가 생략되어 있는 상태이다.
	@RequestMapping
	public String ex04() {
		return "ex04";
	}
}
