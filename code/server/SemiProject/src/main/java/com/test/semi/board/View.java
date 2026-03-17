package com.test.semi.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.semi.model.BoardDto;

@WebServlet(value = "/board/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View.java
		// 1. 데이터 가져오기(seq)
		// 2. DB작업: select
		// 3. 결과를 가지고 JSP 호출하기
		HttpSession session = req.getSession();

		String seq = req.getParameter("seq");

		BoardService service = new BoardService();

		// 조회수가 올라가는 조건을 확인하고 실행시키자
		if (session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {

			service.increaseReadcount(seq);
			session.setAttribute("read", "y");
		}

		// 가져올 데이터
		// 이 시점에서 조회수 + 1
		BoardDto dto = service.get(seq);

		// Dto를 view에게 넘김
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(req, resp);
	}
}