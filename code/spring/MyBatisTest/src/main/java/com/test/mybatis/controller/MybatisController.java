package com.test.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mybatis.model.AddressDto;
import com.test.mybatis.model.InsaDto;
import com.test.mybatis.model.MyBatisDao;

import lombok.RequiredArgsConstructor;

@Controller
// 롬복을 사용해서 의존 주입 도구인 생성자 생성
@RequiredArgsConstructor
public class MybatisController {

	// DAO를 의존 주입 받기
	// 롬복 사용해서 생성자를 만들었으니 final 붙이기
	private final MyBatisDao dao;

	// 반환값, 인자값이 없는 정적 쿼리
	@GetMapping(value = "/m1.do")
	public String m1(Model model) {
		dao.m1();

		return "result";
	}

	@GetMapping(value = "/m2.do")
	public String m2(Model model, @RequestParam(name = "seq", defaultValue = "1") String seq) {

		// m2.do
		// m2.do?seq=1
		// m2.do?seq=2

		int result = dao.m2(seq);

		model.addAttribute("result", result);

		return "result";
	}

	// 반환값은 없고 인자값이 많은 쿼리를 만들자
	// HashMap을 넘기는 작업
	// - m3

	// 반환값(X), 인자값(O)
	// - DTO
	// - m4

	// 반환값(O)
	// - 1행 1열
	// - 원자값 반환(숫자, 문자열 등)
	// - m5
	@GetMapping(value = "/m5.do")
	public String m5(Model model, String seq) {

		String name = dao.m5(seq);

		model.addAttribute("name", name);

		return "result";
	}

	// 행은 하나이고 여러개의 반환값을 받는 경우
	// - 컬럼은 여러개, 레코드는 1개
	// - m6

	// 컬럼 하나에 레코드 n개 반환
	// - m7

	// 레코드 여러개에 컬럼 여러개
	// - m8
	@GetMapping(value = "/m8.do")
	public String m8(Model model) {
		List<AddressDto> list = dao.m8();

		model.addAttribute("list", list);

		return "list";
	}

	@GetMapping(value = "/m9.do")
	public String m9(Model model, @RequestParam("column") String column, @RequestParam("word") String word) {
		// 게시판 검색 기능
		// /m9.do?column=name&word=강아지
		// /m9.do?column=gender&word=m

		// 최종적으로 생성되어야 하는 쿼리
		// select * from tblAddress where name = '강아지'
		// select * from tblAddress where gender = 'm'

		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);

		List<AddressDto> list = dao.m9(map);

		model.addAttribute("list", list);

		return "list";
	}

	@GetMapping(value = "/m15.do")
	public String m15(Model model) {

		// 15번 이후의 예제는 MyBatis에서의 흐름과 개념이
		// JPA에서도 나타난다

		// 1. insert + tblAddresss
		// 2. insert + tblPoint + 1000p 지급

		// 1. 새롭게 회원가입하는 상어
		AddressDto dto = new AddressDto();
		dto.setName("상어");
		dto.setAge("10");
		dto.setGender("m");
		dto.setAddress("동해");

		dao.add(dto);

		// 2. 방금 가입한 상어에게 1000포인트 지급
		dao.addPoint();

		return "result";
	}

	@GetMapping(value = "/m17.do")
	public String m17(Model model) {
		/*
			DB
			테이블간의 관계를 맺는 방법 PK-FK
			
			Java(OOP)
			클래스간의 관계를 맺는 방법 ->
			DB에서의 방식과 많이 다름
			
			내포 관계를 사용
		  
		*/
		
		// Join
		// tblAddress + tblPoint(1 대 1 관계)
		
		List<AddressDto> alist = dao.m17();
		
		model.addAttribute("alist", alist);
		
		return "list";
	}
	
	@GetMapping(value = "/m18.do")
	public String m18(Model model) {
		// 1대 N 관계에서의 조인
		// tblInsa(1) : tblProject(N)
		
		List<InsaDto> ilist = dao.m18();
		
		model.addAttribute("ilist", ilist);
		
		return "list";
	}
}
