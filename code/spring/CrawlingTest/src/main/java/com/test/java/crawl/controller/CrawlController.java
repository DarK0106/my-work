package com.test.java.crawl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.java.crawl.model.MovieDao;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CrawlController {
	
	private final MovieDao dao;
	
	@GetMapping(value = "/movie.do")
	public String movie(Model model) {
		
		// DAO에게 mlist 넘기기
		model.addAttribute("mlist", dao.list());
		
		return "movie";
	}
}
