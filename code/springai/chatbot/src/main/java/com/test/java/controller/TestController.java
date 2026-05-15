package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.java.service.AiService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final AiService aiService;
	
	@GetMapping(value = "/")
	public String index() {

		return "index";
	}
	
	@GetMapping(value = "/chat", produces = "text/plain;charset=UTF-8")
	public @ResponseBody Flux<String> chat(@RequestParam("message") String message) {
		
		Flux<String> result = aiService.chat(message);

		return result;
	}
	
}
