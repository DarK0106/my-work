package com.test.java.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {
	
	// 회원 가입을 할 때 어떤 사람이 아이디는 hong 비번은 1111
	// 이렇게 회원가입을햇고 우리는 이걸 DB에 비번을 암호화해서
	// 저장을 해야됨 그래서 대강 AFKER)@!@1@6@45 로 DB에 저장됨
	// 로그인을 할 때 사용자는 자기 비번은 1111로 기억하니까 1111로 치는데
	// 문제는 AFKER)@!@1@6@45 랑 1111 랑 비교하면 틀리니까
	// 그래서 처음부터 암호화를 한 암호를 DB에 넣어야했다
	// CustomNoOpPasswordEncoder 얘는 나중엔 쓰면안됨, 임시로 만든 엔코더임
	
	@Override
	public String encode(CharSequence rawPassword) {
		// 원래는 사용자가 입력한 암호를 암호화시켜서 반환하는 메서드인데
		// 일단은 암호를 일단 그대로 돌려주기로 하자
		return rawPassword.toString();
	
	}
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 암호화된 비밀번호랑 사용자가 입력한 비밀번호랑 비교하는 메서드
		return rawPassword.toString().equals(encodedPassword);
	
	}
}
