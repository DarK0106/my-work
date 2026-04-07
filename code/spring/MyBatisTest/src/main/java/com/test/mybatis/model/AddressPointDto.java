package com.test.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Address 테이블과 Point 테이블의
// 조인 전용 dto
@Getter
@Setter
@ToString
public class AddressPointDto {
	private String seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
	private String pseq;
	private Integer point;
	private String aseq;
}
