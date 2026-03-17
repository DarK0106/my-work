package com.test.semi.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.semi.model.BoardDto;

@WebServlet(value = "/board/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Edit.java
		// 1. 데이터 가져오기(seq)
		// 2. DB작업: select
		// 3. 결과값을 JSP에게 넘기면서 JSP 호출

		// 글번호 가져오기
		String seq = req.getParameter("seq");

		// 서비스 객체 만들기
		// 글번호를 하나 줄테니 글의 모든 내용을 가져와라
		BoardService service = new BoardService();

		BoardDto dto = service.get(seq);

		// 3. 결과값을 JSP에게 넘기면서 JSP 호출
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// EditOk.java 역할
		// 1. 데이터 가져오기(subject, content, 글번호)
		// 2. DB작업: update
		// 3. 마무리

		String seq = req.getParameter("seq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");

		BoardDto dto = new BoardDto();
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);

		BoardService service = new BoardService();
		
		int result = service.edit(dto);
		
		if (result > 0) {
			resp.sendRedirect("/semi/board/view.do?seq=" + seq);
		} else {
			resp.getWriter().print("<script>alert('failed');</script>");
			resp.getWriter().close();
		}
	}
}