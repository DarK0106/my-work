package com.test.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.api.model.MapDao;
import com.test.api.model.MapDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MapController {
	
	private final MapDao dao;
	
	@GetMapping(value = "/map01.do")
	public String map01(Model model) {
		return "map01";
	}
	@GetMapping(value = "/map02.do")
	public String map02(Model model) {
		return "map02";
	}
	@GetMapping(value = "/map03.do")
	public String map03(Model model) {
		return "map03";
	}
	@GetMapping(value = "/map04.do")
	public String map04(Model model) {
		
		List<MapDto> list = dao.list();
		
		model.addAttribute("list", list);
		
		return "map04";
	}
	@PostMapping(value = "/add.do")
	public String add(Model model, MapDto dto) {
		
		dao.add(dto);
		
		return "redirect:/map04.do";
	}
	@GetMapping(value = "/map05.do")
	public String map05(Model model) {
		return "map05";
	}
}
