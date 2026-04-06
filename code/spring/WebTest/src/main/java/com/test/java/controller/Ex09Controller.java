package com.test.java.controller;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.java.service.DIService;

import lombok.RequiredArgsConstructor;

// 어노테이션 넣는 순간 스프링 빈이 되고
// 컨트롤러 역할을 함
@Controller
@RequiredArgsConstructor
public class Ex09Controller {

	// 멤버 변수로 승격
	// 방법 6 적용 -> 멤버 변수에 final 붙이고
	// 생성자가 유일하기 때문에 @Autowired 생략 가능
	// @RequiredArgsConstructor를 사용
	private final DIService service;

	// 생성자
//	@Autowired
//	public Ex09Controller(DIService service) {
//		this.service = service;
//	}
	
	// 아직 의존 주입한 상태가 아님
	// xml 방식이 아닌 어노테이션 방식으로 의존 주입
	// 생성자 도구에 @Autowired를 붙이는 순간
	// Ex09Controller와 DIService의 관계가 명시적으로 표시된다?
	// 그 다음 DIService를 찾으러 감
	// 스프링의 관리를 받으려면 스프링 빈으로 만들어야함
	// 의존 주입을 하는 객체인 DIService도 빈으로 만들어야함

	// 요청 메서드 역할
	// value라는 가상 주소
	// 어떤 method를 쓸지?
	// @RequestMapping(value = "/ex09.do", method = RequestMethod.GET)
	@GetMapping(value = "/ex09.do")
	public String ex09(Model model) {

		// 컨트롤러가 서비스를 의존하고 서비스가 DAO를 의존
		// 컨트롤러에 의존 주입 도구를 만들어서 서비스를 주입
		// 서비스에 의존 주입 도구를 만들어서 DAO를 주입
		// 본인이 필요한 의존 객체를 직접 만들지 말라

		// 서비스 객체를 생성
		// DIService service = new DIService();

		// 서비스 객체에게 업무 위임
		String data = service.get();

		// 리퀘스트에 있는 데이터를 꺼낸다
		model.addAttribute("data", 123);

		return "ex09";
	}
}
