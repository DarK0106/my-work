package com.test.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.java.model.AddressDto;

// 컴포넌트 스캔을 위해 스프링 빈을 만들기 위해서
// @Mapper 어노테이션이 필요함
@Mapper
public interface AddressMapper {
	int count();
	
	// PK 하나를 주면 레코드 하나를 통째로 반환하는 메서드
	// 기존 template.selectOne(); 역할
	AddressDto get(int seq);

	List<String> names();

	List<AddressDto> list();
}
