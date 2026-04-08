package com.test.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.api.model.BookDao;
import com.test.api.model.BookDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	
	private final BookDao dao;
	
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("page", "1");
		
		return "list";
	}
	
	@GetMapping(value = "/search.do")
	public String search(Model model
						, @RequestParam("word") String word
						, @RequestParam(value = "page", defaultValue = "1") String page) {
		
		//- search.do?word=자바
		if (word.trim() != "") {
			
			List<BookDto> list = dao.search(word.trim(), page);
			
			model.addAttribute("list", list);
			model.addAttribute("word", word.trim());
			model.addAttribute("page", page);
			
			
		} else {
			
		}

		return "list";
	}

}
