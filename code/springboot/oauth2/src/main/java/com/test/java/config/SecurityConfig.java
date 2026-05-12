package com.test.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.test.java.service.CustomOAuth2LoginSuccessHandler;
import com.test.java.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final CustomOAuth2UserService service; // 인증하는 애
	private final CustomOAuth2LoginSuccessHandler handler; // 인증 후에 뒤처리 하는 애
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// CSRF 비활성화
		http.csrf(auth -> auth.disable());
		
		// 우린 더 이상 자체적으로 로그인 처리를 하지 않음
		// 네이버나 카카오나 구글로 소셜 로그인을 할 것이기 때문
		
		// 위의 이유로 Form Login <- 사용하지 않아서 비활성화 해야함
		http.formLogin(auth -> auth.disable());
		http.httpBasic(auth -> auth.disable());
		
		// 허가 URL
		// 로그인이랑 oauth2 페이지는 다 들어갈 수 있게
		// 나머지 내가 미처 처리하지 못한 페이지들은 로그인을 해야만 접근할 수 있게
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/login/**", "/oauth2/**").permitAll().anyRequest().authenticated());
		
		// 로그인을 시도하면 구글로 가야함
		// 그러기 위해 OAuth2 설정을 해야함
		// userService(로그인서비스객체) <- 이걸 해야함
		http.oauth2Login(auth -> auth.loginPage("/login").successHandler(handler).userInfoEndpoint(config -> config.userService(service)));
		
		
		return http.build();
	}
}
