package com.test.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.java.service.AiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final AiService aiService;
	
	@GetMapping
	public String index(Model model) {
		
		return "index";
	}
	
	@PostMapping(value ="/transcribe")
	public ResponseEntity<String> transcribe(Model model, @RequestParam("attach") MultipartFile attach) {
		
		String result = aiService.transcribe(attach);
		
		return ResponseEntity.ok(result);
	}
	
}
