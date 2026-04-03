package com.test.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.java.service.SpringService;

@Controller
public class Ex08Controller {
	
	private SpringService service;
	
	// 생성자
	// 가장 정석이라고 여겨지는 생성자 주입을 하면서 @Autowired를 사용하는 방법
	@Autowired
	public Ex08Controller(SpringService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/ex08.do")
	public String ex08(Model model) {
		
		// 컨트롤러는 서비스 객체를 의존하고있고 서비스는 DAO를 의존하고있다
		// 스프링은 의존 객체를 직접 만들지 말고 주입하는 형태로 작업 권장
		// SpringService service = new SpringService();
		
		String data = service.doSomething();
		
		model.addAttribute("data", data);

		return "ex08";
	}
}
