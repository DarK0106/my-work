package com.test.java.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 컨트롤러를 구현할 때
// 방법 1. Controller 인터페이스 구현
// 방법 2. @Controller 어노테이션을 사용

@Controller
@RequestMapping(value="/ex03.do") // @WebServlet("/ex03.do")과 유사
public class Ex03Controller {
	// doGet(), doPost(), handleRequest() 와 같은 요청 메서드 부재
	// 왜? 인터페이스가 없음
	
	// 요청 메서드입니다 라고 역할을 부여해야 하는데
	// 그것도 어노테이션으로 함
	// @RequestMapping는 한 메서드에만 붙이는 것 <- 마치 대표 메서드
	// 어노테이션 쓰는 방식은 더이상 xml에서 빈을 만들지 않는다?
//	@RequestMapping
//	public ModelAndView aaa() {
//		// 업무를 진행하고 JSP 호출
//		ModelAndView mv = new ModelAndView("ex03");
//		
//		return mv;
//	}
	
	// 위에랑 똑같음, 스프링이 개입해서 줄여놓은것
//	@RequestMapping
//	public String aaa(HttpServletRequest req) {
//		// 업무를 진행하고 JSP 호출
//		// 여전히 뷰 리졸버가 개입하는 중
//		// 데이터를 넘길 방법이 없다?
//		// () 안에 HttpServletRequest req를 넣어라
//		String name = "강아지";
//		req.setAttribute("name", name);
//		
//		return "ex03";
//	}
	
	@RequestMapping
	public String aaa(Model model) {
		// ModelandView에서 View를 빼고 Model만 남긴 객체
		// 택배 상자 역할
		String name = "강아지";
		model.addAttribute("name", name);
		
		return "ex03";
	}
	
	public void bbb() {
		
	}
	
	public void ccc() {
		
	}
}
