package com.test.java.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {
	private String name;
	private Integer age;
	private String address;
	
	// 전혀 상관없는 데이터는 dto에 넣으면 안됨
}
