package com.test.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 화면만 만들고 데이터는 ajax 통해서 받을거고
// 서버가 json으로 데이터를 주면
// ajax가 그 데이터를 조작

@Controller
public class ClientController {
	@GetMapping(value = "/ex08.do")
	public String ex08(Model model) {
		
		return "ex08";
	}
}
