package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping(value = "/accesserror.do")
	public String accesserror(Model model) {

		return "auth/accesserror";
	}
	
	@GetMapping(value = "/customlogin.do")
	public String customlogin(Model model) {

		return "auth/customlogin";
	}
	
	@GetMapping(value = "/customlogout.do")
	public String customlogout(Model model) {
		
		return "auth/customlogout";
	}
	
}
