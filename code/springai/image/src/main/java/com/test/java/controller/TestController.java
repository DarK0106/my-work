package com.test.java.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import org.springframework.ai.image.ImageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.java.service.AiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final AiService aiService;
	
	@GetMapping(value = "/")
	public String index(Model model) {

		
		return "index";
	}
	
	@PostMapping(value = "/")
	public String indexok(Model model
			, @RequestParam("message") String message) {

		ImageResponse resp = aiService.generate(message);
		
//		System.out.println(resp);
		
		// 방법 1. <img> 에 링크를 출력 후 페이지에 출력
		String img = resp.getResult().getOutput().getB64Json();
		model.addAttribute("img", img);
		
		// 방법 2. AI로 생성한 이미지를 내 로컬에 저장
		byte[] imageBytes = Base64.getDecoder().decode(img);
		
		try {
			Files.write(Path.of("C:\\Ssangyong\\code\\dog.png"), imageBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
}

