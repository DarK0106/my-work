package com.test.ajax.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ajax.model.AjaxDao;
import com.test.ajax.model.UserDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AjaxController {

	private final AjaxDao dao;
	
	@GetMapping(value = "/ex01.do")
	public String ex01(Model model) {
		
		return "ex01";
	}
	
	@GetMapping(value = "/ex01ok.do")
	public String ex01ok(Model model) {
		
		int count = dao.countAddress();
		
		model.addAttribute("count", count);
		
		// 요청한 사람이 브라우저라서
		// 브라우저는 페이지를 읽는 프로그램이라
		// 브라우저가 가장 좋아하는 페이지(ex01)를 돌려받음
		return "ex01";
	}
	
	@GetMapping(value = "/ex02.do")
	public String ex02(Model model) {
		
		return "ex02";
	}
	@GetMapping(value = "/ex02ok.do")
	public @ResponseBody String ex02ok(Model model) throws Exception {
		
		// @ResponseBody 이걸 붙이면 HTML로 돌려받는게 아니라
		// count + ""; 순수하게 데이터(JSON)로 돌려받음
		// 이제 더 이상 JSP가 아님
		
		// 사실 ajax가 진짜로 돌려받아야하는 int count
		int count = dao.countAddress();
		
		// model.addAttribute("count", count);
		
		// ex01에선 ok를 location으로 요청했는데 이 요청은 브라우저가 한것
		// 결과적으로 브라우저가 새 페이지를 돌려받음
		// location이 BOM 객체, window.location.href
		// 브라우저가 톰캣한테 페이지 한 장 달라고 요청한것
		// send는 ajax 객체가 서버에게 페이지(혹은 데이터)를 달라고 요청한 것
		// ajax는 브라우저가 아니고 그냥 자바스크립트 객체
		// ajax가 서버한테 서버한테 뭔가 달라고 요청했음
		// 서버는 여전히 HTML 페이지를 돌려줬다
		// 수신된 데이터가 페이지네? ajax는 브라우저가 아니라서 페이지를 돌려받아도
		// 딱히 써먹을 곳이 없음
		
		// 서버 쪽에서 만약 에러가 난 상황이라면?
		// HTML 소스 전체를 ajax.responeText가 받아버림
		// 원래 숫자 출력되던 칸에 에러 페이지를 그대로 출력해버림
		
		// 의도적으로 에러 발생시키기
//		if (count > 0) 
//			throw new Exception();
		
		// return "ex02";
		return count + "";
	}
	
	@GetMapping(value = "/ex03.do")
	public String ex03(Model model) {
		
		return "ex03";
	}
	
	@GetMapping(value = "/ex03ok.do")
	public @ResponseBody String ex03ok(Model model) {
		
		int count = dao.countAddress();
		
		// 의도적으로 시간 끌기
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count + "";
	}
	
	@GetMapping(value = "/ex04.do")
	public String ex04(Model model) {
		
		return "ex04";
	}
	
	@PostMapping(value = "/ex04ok.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ex04ok(Model model, String seq) {
		
		// 이름만 ajax 객체에게 돌려준다
		String name = dao.getName(seq);
		
		// 컨트롤러가 사람 이름 찾아서 돌려줌
		return name;
	}
	
	@GetMapping(value = "/ex05.do")
	public String ex05(Model model) {
		
		return "ex05";
	}
	
	@PostMapping(value = "/ex05ok.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ex05ok(Model model, String seq) {
		
		// 이름만 ajax 객체에게 돌려준다
		String name = dao.getName(seq);
		
		// 컨트롤러가 사람 이름 찾아서 돌려줌
		return name;
	}
	
	@GetMapping(value = "/ex06.do")
	public String ex06(Model model) {
		
		return "ex06";
	}
	
	@GetMapping(value = "/ex06ok.do")
	public @ResponseBody String ex06ok(Model model, String id) {
		
		// id를 넘겨서 중복 검사를 한 다음 숫자를 받아온다
		int result = dao.checkId(id);
		
		return result + "";
	}
	
	@GetMapping(value = "/ex07.do")
	public String ex07(Model model) {
		
		return "ex07";
	}
	
	@GetMapping(value = "/ex07ok.do")
	public @ResponseBody String ex07ok(Model model) {
		
		return "ajax";
	}
	
	@GetMapping(value = "/ex07_2ok.do", produces = "application/json; charset=UTF-8")
	public @ResponseBody List<UserDto> ex07_2ok(Model model) {
		
		// 다중 값 반환 -> select * from tblUser 이걸 하고 싶음
		// dto를 돌려받음
		// @ResponseBody 가 List<UserDto> 를 json으로 매핑해줌, 원래는 에러 발생
		// jackson-databind 필요(매핑해주는 라이브러리)
		List<UserDto> list = dao.listUser();
		
		return list;
	}
	
}
