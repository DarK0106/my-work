package com.test.java.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/auth/logoutok.do")
public class LogoutOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//LogoutOk.java
		//1. 즉시 로그아웃
		//- 로그인 전 상태로 되돌리기
		//- 인증 티켓 제거(auth)
		//2. 돌아가기	
		
		HttpSession session = req.getSession();
		
		session.removeAttribute("auth"); //로그 아웃
		
		resp.sendRedirect("/auth/index.do");
	}

}
