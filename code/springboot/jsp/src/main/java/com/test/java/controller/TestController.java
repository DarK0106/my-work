package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class TestController {
	// http://localhost:8080
	@GetMapping("/")
	public String index(Model model) {
		
		System.out.println("컨트롤러 정상 반응");
		
		// return "WEB-INF/views/index.jsp";
		
		// 뷰 리졸버가 필요함
		return "index"; // index.jsp
	}
}
