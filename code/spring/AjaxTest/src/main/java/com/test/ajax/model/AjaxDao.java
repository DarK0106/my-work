package com.test.ajax.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AjaxDao {

	private final SqlSessionTemplate template;

	public int countAddress() {

		return template.selectOne("ajax.countAddress");
	}

	public String getName(String seq) {

		// 이름은 getName, 파라미터는 seq
		return template.selectOne("ajax.getName", seq);
	}

	public int checkId(String id) {

		return template.selectOne("ajax.checkId", id);
	}

	public List<UserDto> listUser() {

		return template.selectList("ajax.listUser");
	}
	
}
