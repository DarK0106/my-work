package com.test.java.dto;

import com.test.java.entitiy.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private String username;
	private String password;
	private String role;
	private String name;
	private String email;
	
	// Entity 를 DTO 로 만들기
	public static UserDto fromEntity(User user) {

		if (user == null) return null;

		return new UserDto(
			user.getUsername(),
			user.getPassword(),
			user.getRole(),
			user.getName(),
			user.getEmail()
		);
	}

	// DTO를 Entity 로 만들기
	public User toEntity() {

		return new User(
			username,
			password,
			role,
			name,
			email
		);
	}

}
