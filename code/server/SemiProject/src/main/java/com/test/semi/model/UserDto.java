package com.test.semi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String lv;
	private String pic;
	private String intro;
	private String regdate;
	private String ing;
}
