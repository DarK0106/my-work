package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.java.dto.MemberDto;
import com.test.java.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	@GetMapping(value = "/join")
	public String join(Model model) {
		
		return "join";
	}
	
	@PostMapping(value = "/joinok")
	public String joinok(Model model, MemberDto dto) {
		
		// 회원가입한거 DTO로 받아서
		// DB에 인서트해야하는데
		// 그걸 서비스한테 위임
		service.join(dto);
		
		return "redirect:/login";
	}
}
