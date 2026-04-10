package com.test.ajax.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.ajax.model.AddressDto;
import com.test.ajax.model.AjaxDao;
import com.test.ajax.model.SeqDto;

import lombok.RequiredArgsConstructor;

// REST 방식으로 데이터만 입출력하려고 만든 컨트롤러

@RestController
@RequiredArgsConstructor
public class ServerController {

	private final AjaxDao dao;

	// 우선 읽기만 수행
	@GetMapping(value = "/address")
	public List<AddressDto> list() {
		
		return dao.list();
	}
	
	// 더보기 기능
	@GetMapping(value = "/address/more")
	public List<AddressDto> more(Integer index) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return dao.more(index);
	}
	
	// 주소록 추가하기 기능
	@PostMapping(value = "/address")
	public int add(@RequestBody AddressDto dto) {
		
		return dao.add(dto);
	}
	
	// 주소록 삭제하기
	@DeleteMapping(value = "/address/{seq}")
	public int del(@PathVariable("seq") String seq) {
		
		return dao.del(seq);
	}
	
	// 주소록 삭제하기 2
	@DeleteMapping(value = "/address")
	public int delAll(@RequestBody SeqDto dto) {
		
		int n = 0;
		
		// 삭제할때마다 n에 1씩 누적시킴
		for (String seq: dto.getSlist()) {
			n += dao.del(seq);
		}
		
		// dto.getSlist() 랑 n을 비교 해서 둘이 같으면
		// 제대로 삭제됐다는거니까 1 반환
		// 둘이 다르면 뭔가 삭제가 안됐다거나 한 경우니까 0 반환
		return n == dto.getSlist().length ? 1 : 0;
	}

}
