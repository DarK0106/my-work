package com.test.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * 스프링
 * - 서블릿을 사용하지 않음
 * - 일반 클래스를 사용함(extends HttpSer~~ 어쩌구 안함)
 * 
 * 컨트롤러
 * - 이전의 서블릿의 역할
 * 
 * */

// 스프링 빈을 만들어야함
public class Ex01Controller implements Controller {

	// 요청 메서드 역할
	// - doGet(), doPost()와 같은 역할
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 업무 진행 ..
		// 업무 끝나고 jsp 부르기
		// RequestDispatcher -> forward(req, resp)

		// ModelAndView
		// 1. Model 역할 -> 데이터 전송(처리)
		// 2. View 역할 -> JSP
		
		int count = 100;
		
		// request가 모델 역할인데 이런식으로 안씀
		// request.setAttribute("count", count);

		// 스프링에서의 JSP 부르기
		ModelAndView mv = new ModelAndView();

		mv.setViewName("ex01"); // ex01.jsp
		//mv.setViewName("/WEB-INF/views/board/ex01.jsp");
		
		mv.addObject("count", count);//request.setAttribute("count", count); 와 똑같은 역할

		// return 발생 > 뷰리졸버 개입 > 접두어 + "ex01" + 접미어
		// "/WEB-INF/views/" + "ex01" + ".jsp"

		// - "/WEB-INF/views/ex01.jsp"

		return mv; // forward
	}

}
