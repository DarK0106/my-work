package com.test.java.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.java.dto.MemberDto;
import com.test.java.entity.Member;
import com.test.java.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository repo;
	private final BCryptPasswordEncoder encoder;
	
	// 여기서 DB에 INSERT가 이루어짐
	public void join(MemberDto dto) {

		// 엔티티를 DTO로 변환시켜야함
		// 여기서 해도 되고
		// 엔티티와 DTO 간의 변환 작업을 종종 하니까
		// 내장된 메서드를 만들어서 변환해도 됨
		// 지금은 여기서 만들기로 함
		Member member = Member.builder()
							.username(dto.getUsername())
							.password(dto.getPassword())
							.role(dto.getRole())
							.age(dto.getAge())
							.email(dto.getEmail())
							.build();
		
		repo.save(member);
	}
}
