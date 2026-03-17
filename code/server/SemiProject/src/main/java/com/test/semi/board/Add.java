package com.test.semi.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.semi.model.BoardDto;

@WebServlet(value = "/board/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Add.java
		// JSP를 보여주려고 만든 서블릿
		// add.jsp로 이동
		
		req.getRequestDispatcher("/WEB-INF/views/board/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// AddOk.java 역할
		// 1. 데이터 가져오기(subject, content)
		// 2. DB작업: insert
		// 3. 마무리
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		System.out.println(subject);
		System.out.println(content);
		
		BoardDto dto = new BoardDto();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId((String)session.getAttribute("auth"));
		
		BoardService service = new BoardService();
		
		int result = service.add(dto);
		
		if (result > 0) {
			resp.sendRedirect("/semi/board/list.do");
		} else {
			resp.getWriter().print("<script>alert('failed');</script>");
			resp.getWriter().close();
		}
		
	
	}
	
}