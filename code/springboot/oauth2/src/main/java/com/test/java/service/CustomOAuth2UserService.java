package com.test.java.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.test.java.dto.CustomOAuth2User;
import com.test.java.dto.GoogleResponse;
import com.test.java.dto.UserDto;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	
	// 리소스 서버(구글)로부터 인증된 구글 계정 정보를 넘겨 줘
	// 할 때 이 메서드가 호출이 된다
	// 구글이 준 정보를 받아서 우리 DB에 저장하고, 우리 페이지 형식의 사용자 객체로 변환
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		System.out.println("구글로부터 받아온 개인 정보: " + oAuth2User);
		
		// 로그인한 사용자의 구글 개인정보 -> 파싱 -> 우리 페이지 구조에 넣기
		// 로그인할 때마다 사용자 정보가 다름 -> 매번 새로 만들어야 함
		// 안에 든 데이터(attributes Map)가 요청마다 달라짐
		GoogleResponse oauth2Response = new GoogleResponse(oAuth2User.getAttributes());
		
		// 자체 서비스 인증 처리
		// 내부 아이디 생성
		// 사용자가 구글에 회원가입할때 입력했던 아이디
		String username = oauth2Response.getProvider() + "" + oauth2Response.getProviderId();
		
		System.out.println("사용자의 아이디: " + username);
		
		// 인증 객체(=인증 티켓)를 만든다
		UserDto dto = UserDto.builder()
						.username(username)
						.name(oauth2Response.getName())
						.role("ROLE_MEMBER")
						.email(oauth2Response.getEmail())
						.provider(oauth2Response.getProvider())
						.providerId(oauth2Response.getProviderId())
						.build();
		
		return new CustomOAuth2User(dto);
	}

}
