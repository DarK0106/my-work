package com.test.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// HTML 페이지 띄우는게 목적인 컨트롤러, 서버단에서는 아무것도 안 함
@Controller
public class ChatController {
	@GetMapping(value = "/index.do")
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping(value = "/chat.do")
	public String chat(Model model) {
		
		return "chat";
	}
}
