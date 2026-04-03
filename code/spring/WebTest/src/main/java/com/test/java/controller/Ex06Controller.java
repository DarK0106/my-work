package com.test.java.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import com.test.java.model.AddressDTO;
import com.test.java.model.SpringDAO;

@Controller
public class Ex06Controller {

	// 글쓰기 역할
	@GetMapping(value = "/ex06.do")
	public String ex06() {
		return "ex06";
	}

	/*
	 * 똑같은 주소인데 어떨 땐 - /java/ex06ok.do 로 적고 - /ex06ok.do로 작성하는데
	 * 
	 * 클라이언트 페이지에선 앞에 루트 컨텍스트를 작성해야함(HTML, CSS, JavaScript 코드) - /java/ex06ok.do
	 * 
	 * 서버 페이지에선 앞에 루트 컨텍스틀르 붙이면 안됨(자바, JSP 코드) - /ex06ok.do
	 * 
	 */

//	@PostMapping(value = "/ex06ok.do")
//	public String ex06ok(HttpServletRequest req) {
//
//		// 인코딩 필터?
//		// 방법 1. EncodingFilter.java 생성 <- 번거로움, Spring에서 제공해주는 필터가 있음
//		// 방법 2. web.xml에서 필터 등록
//		
//		try {
//			req.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		String data = req.getParameter("data");
//
//		req.setAttribute("data", data);
//
//		return "ex06ok";
//	}
	
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(@RequestParam("data") String data, Model model) {
//		// 기존 데이터 수집 방식
//		// - req.getParameter("key")
//		
//		// 스프링 방식
//		// @RequestParam("key")
//		// - 이걸 파라미터 자동 수집 기능이라고 부름
//		
//		model.addAttribute("data", data);
//		
//		return "ex06ok";
//	}
	
	
	
//	@PostMapping(value = "ex06ok.do")
//	// @RequestParam("data") 생략도 가능
//	public String ex06ok(String data, Model model) {
//		
//		model.addAttribute("data", data);
//		
//		return "ex06ok";
//	}
	
	// data가 키값이니까 html이랑 항상 일치시킬것
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(@RequestParam("data") String data, Model model) {
//		
//		model.addAttribute("data", data);
//		
//		return "ex06ok";
//	}
	
	// 데이터를 가공해야 할 경우?
	// String data 에서 int data로 바꾸면 알아서 바뀜
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(@RequestParam("data") int data, Model model) {
//		
//		// data <- 숫자만 입력받는다고 가정
//		model.addAttribute("data", data * 2);
//		
//		return "ex06ok";
//	}
	
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(@RequestParam(name = "data", defaultValue = "엄준식") String data, Model model) {
//		// list.do
//		// list.do?page=1
//		if (data == null || data.equals("")) {
//			data = "기본값"; // 원랜 이렇게 했었는데
//		}
//		
//		// defaultValue 라는게 또 있음
//		// 파라미터 null or "" 를 대신할 값
//		
//		model.addAttribute("data", data);
//		
//		return "ex06ok";
//	}
	
	// int라 쓰지 말고 클래스 타입인 Integer로 쓰는게
	// 왜 좋냐면 만약에 모종의 경우로 나이가 입력되지 않는다면
	// int로 쓰면 null받으면 오류나는데 Integer는 null 받아줄수있어서
	// 안정성이 높아짐
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(Model model, 
//						@RequestParam("name") String name, 
//						@RequestParam("age") Integer age, 
//						@RequestParam("address") String address) {
//		
//		AddressDTO dto = new AddressDTO();
//		
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//		
//		SpringDAO dao = new SpringDAO();
//		
//		dao.add(dto);
//		
//		return "ex06ok";
//		// 보기가 너무 지저분함
//	}
	
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(Model model, AddressDTO dto) {
//		
//		// <input type="text" name="name" value="호날두">
//		// 1. @RequestParam("name") 으로 데이터를 가져옴
//		// name
//		// setName
//		// dto.setName
//		// 이런 식으로 타고 타고 dto의 set 메서드에서 찾아온다
//		// name을 name2로 바꾸면 당연히 오류
//		// setter 이름을 태그 이름으로 찾는다
//		
//		SpringDAO dao = new SpringDAO();
//		
//		dao.add(dto);
//		
//		return "ex06ok";
//	}
	
	// dto에 넣지 못하는 것들이 있으면 @RequestParam 써서 개별적으로 하나씩 받아오자
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(Model model, AddressDTO dto, @RequestParam("id") String id) {
//		
//		SpringDAO dao = new SpringDAO();
//		
//		dao.add(dto);
//		
//		return "ex06ok";
//	}
	
	// getParameterValues는 어떻게 어노테이션으로 받을까?
	// 배열이면 String[] cb, 아니면 String cb
	// @RequestParam 생략해도 되긴 함
	// @RequestParam("cb") List<String> cb 도 됨
	// @RequestParam("cb") ArrayList<String> cb 도 됨
	// @RequestParam("cb") LinkedList<String> cb 도 됨
	// 순수 배열도 되고, 컬렉션도 된다는 소리
	// 배열보단 컬렉션이 써먹기가 더 좋음
	// 근데 컬렉션은 앞에 @RequestParam 생략하면 안됨
	// 에러는 안 나는데 값이 안 넘어옴
//	@PostMapping(value = "ex06ok.do")
//	public String ex06ok(@RequestParam("cb") String[] cb) {
//		
//		System.out.println(Arrays.toString(cb));
//		
//		return "ex06ok";
//	}
	
	@PostMapping(value = "ex06ok.do")
	public String ex06ok(Model model, @ModelAttribute("data") String data) {
		
		// @ModelAttribute = @RequestParam + model.addAttribute
		// model.addAttribute("data", data);
		
		return "ex06ok";
	}
	
}
