package com.test.java.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.java.entity.Member;

import lombok.Getter;

// 인증 사용자에 대한 정보를 갖고 있는 객체 = 인증 티켓이라고 보면 됨
@Getter
public class CustomUserDetails implements UserDetails {
	
	// 사용자의 추가 정보(나이, 이메일 ..)
	// - 레거시: MemberDto
	// - 현재: MemberDto or Member
	// private MemberDto dto;
	private Member member;
	
	// 생성자를 만들어 주입
	// 읽기 전용이라 엔티티를 넣어도 된다?
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	// 권한
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		// 상속하는 클래스를 만들지 않고 익명 객체로 만든다
		authorities.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return member.getRole();
			}
			
		});
		
		return authorities;
	}
	
	// 비밀번호
	@Override
	public String getPassword() {
		return member.getPassword();
	}

	// 아이디
	@Override
	public String getUsername() {
		return member.getUsername();
	}

}
