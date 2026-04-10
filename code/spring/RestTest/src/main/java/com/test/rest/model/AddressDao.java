package com.test.rest.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddressDao {
	private final SqlSessionTemplate template;

	public AddressDto m1() {
		
		return template.selectOne("rest.m1");
	}

	// CRUD 중 글쓰기 add
	// REST와는 전혀 상관없는 독립적인 구역
	public int add(AddressDto dto) {

		return template.insert("rest.add", dto);
	}
	
	// CRUD 중 목록 보기
	public List<AddressDto> list() {

		return template.selectList("rest.list");
	}
	
	// CRUD 중 수정하기
	public int edit(AddressDto dto) {

		return template.update("rest.edit", dto);
	}

	public int del(String seq) {

		return template.delete("rest.del", seq);
	}
}
