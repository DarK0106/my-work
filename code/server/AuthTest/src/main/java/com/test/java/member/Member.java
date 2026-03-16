package com.test.java.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/member/member.do")
public class Member extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Member.java
		// 전처리: 익명 사용자인지 인증 사용자인지 구별하기 위한 검사
		HttpSession session = req.getSession();
		
		if (session.getAttribute("auth") == null) {
			resp.sendRedirect("/auth/index.do");
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/member/member.jsp").forward(req, resp);
	}
}