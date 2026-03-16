package com.test.java.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.java.model.AuthDao;
import com.test.java.model.AuthDto;

@WebServlet(value = "/auth/loginok.do")
public class LoginOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		//LoginOk.java
		//1. 데이터 가져오기(id, pw)
		//2. DB 작업 > 계정 정보 확인?
		//3. 결과
		//	3.1 맞다 > 인증 티켓 발급(*****)
		//	3.2 틀리다 > 경고!!
		
		//1.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//2.
		AuthDao dao = new AuthDao();
		
		AuthDto dto = new AuthDto();
		dto.setId(id);
		dto.setPw(pw);
		
		AuthDto result = dao.login(dto);
		
		if (result != null) {
			//로그인 성공 > 인증 티켓 발급!!!
			//System.out.println(result);
			session.setAttribute("auth", id);
						
		} else {
			//로그인 실패
			
		}
		
		resp.sendRedirect("/auth/index.do");
		
	}

}







