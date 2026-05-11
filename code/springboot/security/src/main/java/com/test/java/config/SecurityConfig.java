package com.test.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 이 안에서 하는 모든 행위가
		// 레거시에서의 <security:http> 태그 안에서
		// 중요한 설정들을 했던 것과 똑같다
		
		// URI 허가하기
		// URI (Uniform Resource Identifier) = 자원을 식별하는 문자열
		// URL (Uniform Resource Locator) = 자원의 위치까지 알려주는 URI (URI의 부분집합)
		http.authorizeHttpRequests(auth -> auth
			// 이렇게 해두면 작성해둔 링크는 익명 or 인증된 사용자 모두 접근 가능
//			.requestMatchers("/").permitAll()
//			.requestMatchers("/login").permitAll()
//			.requestMatchers("/join").permitAll()
//			.requestMatchers("/joinok").permitAll()
			// 위처럼 작성하면 너무 기니까 단축해서 작성 가능
			.requestMatchers("/", "/joinok", "/login", "/join").permitAll()
			// 회원 권한이 있는 사용자만 접속 가능(ROLE_MEMBER)
			.requestMatchers("/member").hasRole("MEMBER")
			// 관리자 권한이 있는 사용자만 접속 가능(ROLE_ADMIN)
			.requestMatchers("/admin").hasRole("ADMIN")
			// 내가 깜빡하고 통제 못한 URL은 인증 사용자한테만 접근 가능하게 하겠다
			// 기타 등등 처리를 한 것, 안 붙여도 되긴 함
			// 이걸 안 붙이면 내가 깜빡하고 통제 못한 URL은 모든 사용자가 접근 가능함
			.anyRequest().authenticated()
			// 인증된 사용자만 접근 가능
//			.requestMatchers("/info").authenticated()
			// 익명 사용자만 접근 가능
//			.requestMatchers("/intro").anonymous()
			
				
		);
		
		// 개발중일때만 CSRF 를 비활성화하고 싶을때
		http.csrf(auth -> auth.disable());
		
		// 커스텀 로그인 페이지
		http.formLogin(auth -> auth
			.loginPage("/login") // 로그인 할 때 이 페이지를 쓰겠다 라고 설정
			.loginProcessingUrl("/loginok") // 로그인 정보를 처리하는 페이지는 여기다 라고 설정
		);
		
		return http.build();
	}
	
	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
}
