package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.java.model.AddressDao;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final AddressDao dao;
	
	@GetMapping("/count")
	public int count() {
		return dao.count();
	}
}
