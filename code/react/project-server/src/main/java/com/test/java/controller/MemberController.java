package com.test.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.entitiy.User;
import com.test.java.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// REST 컨트롤러
@RestController
@RequiredArgsConstructor
public class MemberController {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	// 1. 시작 페이지
	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> index() {

		// 아직 리액트 구현 전 상태
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("path", "/");
		result.put("message", "public index");

		// ResponseEntity
		// - JSON 응답 객체
		// - 반환하는 데이터 + 상태 코드(Status Code: 200) 까지 같이 반환함
		return ResponseEntity.ok(result);

	}

	// 2. 로그인 주소
	@GetMapping("/login")
	public ResponseEntity<Map<String, Object>> login() {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("path", "/login");
		result.put("message", "login page");

		return ResponseEntity.ok(result);

	}

	// 3. 로그인 처리 주소
	@PostMapping("/loginok")
	public ResponseEntity<Map<String, Object>> loginok(@RequestBody LoginRequest loginRequest,
			HttpServletRequest request) {

		User user = userRepository.findById(loginRequest.getUsername()).orElse(null);

		// 아이디가 없는 사람 || 아이디는 맞는데 비밀번호가 틀린 사람
		if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

			Map<String, Object> error = new HashMap<String, Object>();
			error.put("error", "bad_credentials");
			error.put("message", "username or password is invalid");

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED) // HTTP Header
					.body(error); // HTTP body
		}

		// 인증 사용자
		// ROLE 을 가져와야 함
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

		// 인증 객체
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), null, authorities);

		// 인증 객체가 스프링 시큐리티 환경에서 통제를 받아야 함
		SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

		securityContext.setAuthentication(authentication);
		SecurityContextHolder.setContext(securityContext);

		// 리액트가 다시 요청 -> JSESSIONID -> 인증된 사용자
		request.getSession(true).setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				securityContext);

		// 리액트에게 완료했다고 메시지를 보냄
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "login");
		result.put("username", user.getUsername());
		result.put("role", user.getRole());

		return ResponseEntity.ok(result);

	}

	// 4. 회원 전용 페이지
	@GetMapping("/member")
	public ResponseEntity<Map<String, Object>> member(Authentication authentication) {
		
		// 스프링 부트가 알아서 정보를 넣어줌
		
		// 개인정보를 출력해보자
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("result", "ok");
		result.put("path", "/member");
		result.put("username", authentication.getName());
		result.put("authorities", authentication.getAuthorities());
		
		User user = userRepository.findById(authentication.getName()).orElse(null);
		result.put("name", user.getName());
		result.put("email", user.getEmail());
		
		return ResponseEntity.ok(result);	
		
		
		
	}

	// 5. 관리자 전용 주소
	@GetMapping("/admin")
	public ResponseEntity<Map<String, Object>> admin(Authentication authentication) {
		
		// 스프링 부트가 알아서 정보를 넣어줌
		
		// 개인정보를 출력해보자
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("result", "ok");
		result.put("path", "/admin");
		result.put("username", authentication.getName());
		result.put("authorities", authentication.getAuthorities());
		
		return ResponseEntity.ok(result);
	}

	// 6. 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<Map<String,Object>> logout() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("result", "ok");
		result.put("path", "/logout");
		result.put("message", "logout page");
		
		return ResponseEntity.ok(result);
	}

	// 로그인 처리를 위한 DTO 용도의 내장 클래스
	@Getter
	@Setter
	public static class LoginRequest {

		private String username;
		private String password;
	}

}
