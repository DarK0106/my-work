package com.test.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.java.dto.AddressDto;
import com.test.java.entity.Address;
import com.test.java.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final AddressRepository repo;

	@GetMapping(value = "/")
	public String index(Model model) {

		List<Address> list = repo.findAll();

		List<AddressDto> dlist = list.stream().map(address -> AddressDto.toDto(address)).toList();

		model.addAttribute("dlist", dlist);

		return "index";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {

		return "add";
	}

	@PostMapping(value = "/add")
	public String addok(Model model, AddressDto dto) {
		
		repo.save(dto.toEntity());
		
		return "redirect:/";
	}

}
