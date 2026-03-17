package com.test.semi.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/board/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Del.java
		// del.do 로 올 때 그냥 오지 않았고
		// 시퀀스로 왔음
		// -del.do?seq=10
		String seq = req.getParameter("seq");

		req.setAttribute("seq", seq);

		req.getRequestDispatcher("/WEB-INF/views/board/del.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DelOk.java 역할
		// 1. 데이터 가져오기(seq)
		// 2. DB작업: delete
		// 3. 마무리

		// 글번호 가져오기
		String seq = req.getParameter("seq");

		// 서비스 객체 만들기
		BoardService service = new BoardService();

		int result = service.del(seq);

		if (result > 0) {
			resp.sendRedirect("/semi/board/list.do");
		} else {
			resp.getWriter().print("<script>alert('failed');</script>");
			resp.getWriter().close();
		}

	}
}