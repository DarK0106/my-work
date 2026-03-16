package com.test.semi.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.semi.model.UserDto;

@WebServlet(value = "/user/login.do")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Login.java
		
		req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// loginOk.java의 역할을 수행(데이터 처리 페이지 역할)
		// 1. 데이터 가져오기
		// 2. DB 작업: select
		// 3. 결과에 따른 인증 티켓 발급
		// 4. 마무리
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setPw(pw);
		
		// 웹: req, resp, session 사용
		// 웹에 관련된 특성있는 업무: 일반적으로 서블릿이 수행
		// 웹에 무관한 일반적인 업무: 일반적으로 서비스 객체가 수행
		UserService service = new UserService();
		UserDto result = service.login(dto);
		
		if (result != null) {
			// 로그인에 성공 -> 인증 티켓 발급
			session.setAttribute("auth", id);
			// 개인 정보(회원이름, 회원등급)
			session.setAttribute("authDto", result); // name, lv
			
			resp.sendRedirect("/semi/index.do");
		} else {
			resp.getWriter().print("<script>alert('failed');history.back();</script>");
			resp.getWriter().close();
		}
	
	}
}