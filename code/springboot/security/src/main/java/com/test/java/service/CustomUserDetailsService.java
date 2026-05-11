package com.test.java.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.java.dto.CustomUserDetails;
import com.test.java.entity.Member;
import com.test.java.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	// 로그인을 시도한 username을 DB에서 찾기 위해
	private final MemberRepository repo;

	// 로그인이 되는 순간 자동으로 호출되는 메서드
	// 이 사람이 우리 사이트에 존재하는 사람인지 아닌지
	// 증명하는걸 내가 여기다 구현해야함
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// select * from member where username = ? 를 한 것
		Optional<Member> member = repo.findById(username); // username 이 Primary Key 라서

		if (member.isPresent()) {

			return new CustomUserDetails(member.get()); // 인증 객체

		} else {
			// 로그인을 시도한 아이디를 DB에서 못 찾은 것
			return null;
		}
	}

}
