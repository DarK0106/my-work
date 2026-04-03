package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.java.model.AddressDTO;

@Controller
public class Ex07Controller {
	
	// 요청 메서드의 반환값 종류
	// 리턴값이 문자열(String)이면
	// JSP 파일명
	// 	- ViewResolver가 같이 사용되었다는 전제
	
//	@GetMapping(value = "/ex07.do")
//	public String ex07(Model model) {
//		
//		return "ex07";
//	}
	
	// 리턴값이 void
	// Spring 4.3 이후 지원되는 기능
	// 요청 주소의 이름과 동일한 JSP를 호출하는 기능이 내장되어있다.
	// 위의 메서드와 똑같은 상황
//	@GetMapping(value = "/ex07.do")
//	public void ex07(Model model) {
//
//		// ex07.jsp를 자동으로 호출한다.
//
//	}
	
	// 3. String을 반환하는데 그냥 String이 아니고 예약된 키워드가 있다
	// - redirect: resp.sendRedirect()와 같은 역할
	// - forward: pageContext.forward()와 같은 역할
//	@GetMapping(value = "/ex07.do")
//	public String ex07(Model model) {
//		
//		// resp.sendRedirect()와 같은 역할
//		// return "redirect:/ex06.do";
//		
//		// pageContext.forward()와 같은 역할
//		return "forward:/ex06.do";
//
//	}
	
	// 4. String이면서 매개변수를 RedirectAttributes 를 썼을때
//	@GetMapping(value = "/ex07.do")
//	public String ex07(Model model, RedirectAttributes rttr) {
//
//		// 업무 처리 후 다른 페이지로 이동
//		// list.do로 이동?
//		// list.do?page=10&search=y
//		// 페이지와 서치라는 값을 가지고 넘어가야 한다면?
//		
//		String page = "10";
//		String search = "y";
//		
//		rttr.addAttribute("page", page);
//		rttr.addAttribute("search", search);
//		
//		// return "redirect:/list.do?page=" + page + "&search=" +search;
//		// http://localhost:8080/java/list.do?page=10&search=y 잘 되는거 확인
//		
//		// RedirectAttributes 사용
//		// 쿼리 스트링에 넘길 값을 RedirectAttributes에 담으면 된다
//		return "redirect:/list.do";
//		// http://localhost:8080/java/list.do?page=10&search=y
//		// 리다이렉트하는 작업에 한해서 컬렉션값을 자동으로 쿼리 스트링으로
//		// 붙여놓는 일을 해준다
//	}
	
	// 5. JSON 반환
	// 의존성도 추가해야하고 어노테이션도 추가해야함
	// pom.xml로 이동 -> jackson-databind 추가
	// @ResponseBody
	@GetMapping(value = "/ex07.do")
	public @ResponseBody AddressDTO ex07(Model model) {

		AddressDTO dto = new AddressDTO();
		
		dto.setName("호날두");
		dto.setAge(3);
		dto.setAddress("하와이");
		/*
		 * JSON, JavaScript Object Notation
		 * 	- 자바스크립트 문법을 사용한 객체 표현법
		 * 	- 문법을 빌려온거지 자바스크립트랑 1도 관련없음
		 * 	- 프로퍼티 이름을 무조건 ""로 묶어야함, '' 못씀
		 * 	- 숫자는 그냥 둬도 됨
		 * 
		 * 
		 * 
		 * */
		
		System.out.println("DTO");
		
		return dto;
	}
}
