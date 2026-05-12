package com.test.java.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;

// 로그인된 사용자의 "신분증"
// 인증 티켓 역할을 하는 객체
// 내부에 UserDto 를 가지고 있어서 
// username, email, role 등 조회 가능.
@Getter
public class CustomOAuth2User implements OAuth2User {
	
	private final UserDto dto;
	
	public CustomOAuth2User(UserDto dto) {
		this.dto = dto;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// 사용하지 않음
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// UserDto의 role이라는 멤버가 있어서
		// 그걸 돌려줄거임
		Collection<GrantedAuthority> collection = new ArrayList<>();
		
		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return dto.getRole();
			}
			
		});
		
		return collection;
	}

	@Override
	public String getName() {
		return dto.getName();
	}
	
	// 추가 정보
	public String getUsername() {
		return dto.getUsername();
	}
	
	public String getProvider() {
		return dto.getProvider();
	}
	
	public String getEmail() {
		return dto.getEmail();
	}
	
}
