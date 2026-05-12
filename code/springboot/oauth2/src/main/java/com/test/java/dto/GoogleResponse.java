package com.test.java.dto;

import java.util.Map;

// 구글이 준 Map 을 보기 좋게 감싼 래퍼
// 데이터를 담는 일회용 그릇
// 구글이 보내주는 Map 의 key 이름들(sub, email, name 등)을 
// 일일이 외우기 귀찮으니까 getProviderId(), getEmail() 같은 메서드로 추상화. 
// 네이버/카카오 추가하려면 NaverResponse, KakaoResponse 를 같은 식으로 만들면 됨.
public class GoogleResponse {
	
	private final Map<String, Object> attributes;
	
	public GoogleResponse(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	// 제공자가 누구야?(구글, 카카오, 네이버)
	// 지금은 구글밖에 없긴 함
	public String getProvider() {
		return "google"; // 제공자가 구글이에요
	}
	
	// 제공자에서 발급하는 아이디
	public String getProviderId() {
		
		// 구글 리스폰스 객체인 dto를 찾아서
		// 열람할 수 있다
		return attributes.get("sub").toString();
	}
	
	// 로그인한 사용자의 이메일
	public String getEmail() {
		return attributes.get("email").toString();
	}
	// 로그인한 사용자의 이름
	public String getName() {
		return attributes.get("name").toString();
	}
	// 로그인한 사용자의 프로필 사진
	public String getPicture() {
		return attributes.get("picture").toString();
	}
}
