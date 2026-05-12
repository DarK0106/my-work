package com.test.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 컨트롤러/서비스 계층에서 돌려쓰는 가벼운 객체
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long seq;
	private String username;
	private String name;
	private String email;
	private String role;
	private String provider;
	private String providerId;
}
