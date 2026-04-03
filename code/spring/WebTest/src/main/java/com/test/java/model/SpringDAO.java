package com.test.java.model;

import org.springframework.stereotype.Repository;

// 스프링 빈
// @Component
@Repository
public class SpringDAO {
	public int count() {
		// select 쿼리문을 날렸다고 치고
		return 400;
	}

	public void add(AddressDTO dto) {

		System.out.println("데이터가 넘어왔는지 확인: " + dto.toString());
		
	}
	
	public String work() {
		
		// select 쿼리문을 날렸다고 치고
		return "스프링";
	}
}
