package com.test.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.java.service.AiService;
import com.test.java.service.DataLoader;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TestController {

	private final AiService aiService;
	private final DataLoader dataLoader;

	@GetMapping(value = "/")
	public String index() {
		
		return "index";
		
	}
	
	@PostMapping(value = "/chat")
	public @ResponseBody ResponseEntity<String> chat(@RequestParam("message") String message) {

		String result = aiService.chat(message);

		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/load")
	public @ResponseBody ResponseEntity<String> load() {
		
		dataLoader.load();
		return ResponseEntity.ok("RAG 데이터를 학습했습니다.");
		
	}
	
	@GetMapping(value = "/del")
	public @ResponseBody ResponseEntity<String> del() {
		
		dataLoader.del();
		return ResponseEntity.ok("RAG 데이터를 학습했습니다.");
		
	}
	
	

}
