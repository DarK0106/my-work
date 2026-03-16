package com.test.semi.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.semi.model.UserDto;

@WebServlet(value = "/user/info.do")
public class Info extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Info.java
		// 1. DB 작업: select
		// 2. JSP 호출하기(+UserDto)
		
		// 부하 직원인 서비스에게 일 시키기
		HttpSession session = req.getSession();
		
		UserService service = new UserService();
		UserDto dto = service.info((String)session.getAttribute("auth"));
		
		// 서비스가 가져온 결과물
		req.setAttribute("dto", dto);
		
		// 결과물을 마무리
		req.getRequestDispatcher("/WEB-INF/views/user/info.jsp").forward(req, resp);
	}
}
