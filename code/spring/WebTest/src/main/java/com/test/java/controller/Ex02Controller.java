package com.test.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.java.model.SpringDAO;

public class Ex02Controller implements Controller {

	// 의존 도구 구현(생성자 or Setter)
	private SpringDAO dao;
	
	public Ex02Controller(SpringDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DB 작업 위임
		// -> Ex02Controller는 SpringDAO를 의존한다
		
		// 의존 객체
		// 의존 객체를 직접 만들지 말고 DI를 구현해서 의존 객체를 받아와라
		// SpringDAO dao = new SpringDAO();
		
		int count = dao.count();
		
		ModelAndView mv = new ModelAndView("ex02");
		mv.addObject("count", count);
		
		return mv;
	}
	
}
