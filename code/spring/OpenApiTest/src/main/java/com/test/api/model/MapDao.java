package com.test.api.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MapDao {
	private final SqlSessionTemplate template;
	
	public List<MapDto> list() {
		
		return template.selectList("map.list");
	}

	public void add(MapDto dto) {

		template.insert("map.add", dto);
	}
}
