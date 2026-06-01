package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String index(Model model) {

		return "index";
	}
	
	@GetMapping(value = "/add")
	public String add(Model model) {

		return "add";
	}
	
	@PostMapping(value = "/add")
	public String addok(Model model) {

		return "redirect:/";
	}
	
}












