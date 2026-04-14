package com.test.java.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	// 403 에러가 호출되면 담당자인 handle 메서드가 호출됨
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// 여러 가지 업무 수행 후 페이지를 호출
		
		// 여러 가지 업무
		System.out.println("403 오류 관련 처리를 진행중입니다 ..");
		
		response.sendRedirect("/java/accesserror.do");
		
	}
	
}
