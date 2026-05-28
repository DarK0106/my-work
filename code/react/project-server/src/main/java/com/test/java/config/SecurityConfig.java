package com.test.java.config;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	// 이전에 썼던 방식은 로그인 성공 or 실패 를 하면 리다이렉트 했었음

	// 리액트는 페이지가 한장이라 리다이렉트를 할 수 없음
	// 리액트는 서버와의 통신을 JSON 으로만 함
	// JSON으로 로그인하려면 AuthenticationManager.authenticate() 필요
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

		return config.getAuthenticationManager();
	}

	// 모든 시큐리티 설정
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// 폼 로그인 방식이 아닐때는 CSRF를 쓰지 않아서 비활성화
		http.csrf(csrf -> csrf.disable());

		// CORS 활성화
		http.cors(cors -> {
		});

		// 스프링 시큐리티의 기본은 폼 로그인 방식
		// JSON 방식으로 로그인 하려면 폼 로그인을 비활성화 해야함
		http.formLogin(form -> form.disable());

		// URL 허용
		// 익명 사용자한테도 보여야 하는 페이지
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/login", "/loginok").permitAll()

				// 정적 리소스 폴더를 오픈해야 한다?
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers("/member").hasAnyRole("MEMBER", "ADMIN").requestMatchers("/admin").hasAnyRole("ADMIN")

				// 게시판 구현
				.requestMatchers("/board", "/board/list", "/board/view").permitAll()

				.anyRequest().authenticated());

		http.logout(logout -> logout
				// React에서 /logout으로 요청하면 로그아웃 처리됨
				.logoutUrl("/logout").logoutSuccessHandler((request, response, authentication) -> {
					response.setStatus(200);
					response.setContentType("application/json;charset=UTF-8");

					PrintWriter out = response.getWriter();
					out.print("{\"result\":\"logout\"}");
					out.flush();
				}).invalidateHttpSession(true)
				// 세션 방식이면 JSON이어도 쿠키 필요
				.deleteCookies("JSESSIONID"));

		http.exceptionHandling(e -> e
				// 인증 실패 처리
				// 로그인하지 않은 사용자가 인증 필요한 URL에 접근하면 실행됨
				.authenticationEntryPoint((request, response, exception) -> {
					response.setStatus(401);
					response.setContentType("application/json;charset=UTF-8");

					PrintWriter out = response.getWriter();
					out.print("{\"error\":\"unauthorized\"}");
					out.flush();
				})
				// 권한 실패 처리
				// 로그인은 했지만 해당 URL에 필요한 Role이 없으면 실행됨
				.accessDeniedHandler((request, response, exception) -> {
					response.setStatus(403);
					response.setContentType("application/json;charset=UTF-8");

					PrintWriter out = response.getWriter();
					out.print("{\"error\":\"forbidden\"}");
					out.flush();
				}));

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();

		// 요청을 허용할 프론트엔드 Origin 지정
		// credentials를 사용할 때는 "*" 사용 불가 > 아무 사이트나 요청을 보내면 위험. 그래서 클라이언트를 지정
		config.setAllowedOrigins(List.of("http://localhost:5173"));

		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

		// 허용할 요청 Header 지정
		// Content-Type, Authorization 등 대부분 허용
		config.setAllowedHeaders(List.of("*"));

		// 쿠키, 세션, 인증 정보를 포함한 요청 허용
		// React fetch의 credentials: "include"
		// axios의 withCredentials: true 와 세트로 필요
		config.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return source;
	}

}
