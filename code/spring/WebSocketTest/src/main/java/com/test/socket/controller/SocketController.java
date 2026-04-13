package com.test.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocketController {
	@GetMapping(value = "/socket.do")
	public String socket(Model model) {
		
		return "socket";
	}
}
