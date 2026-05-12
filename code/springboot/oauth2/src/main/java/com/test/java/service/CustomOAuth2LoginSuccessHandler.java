package com.test.java.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.test.java.dto.CustomOAuth2User;
import com.test.java.entity.User;
import com.test.java.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// 구글 인증이 성공한 직후에 호출됨
@Component
@RequiredArgsConstructor
public class CustomOAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

	private final UserRepository repo;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// System.out.println("Success Handler");

		// 지금 로그인한 사람이 누군지 알아내자
		CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();

		String username = customOAuth2User.getUsername();

		Optional<User> user = repo.findByUsername(username);

		if (user.isPresent()) {
			//이미 등록된 사람이면 메인으로 보냄
			response.sendRedirect("/");
		} else {
			//처음 온 사람이면 회원 가입 페이지로 보냄
			response.sendRedirect("/join");
		}

	}

}
