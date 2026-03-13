package com.test.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.todo.model.TodoDAO;

@WebServlet(value = "/DelOk.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DelOk.java
		// Ctrl + 좌클릭 시 할 일을 삭제
		// 1. seq 데이터 가져오기
		// 2. DB 작업(DAO한테 위임) -> delete
		// 3. JSP 호출
		
		// 1.
		String seq = req.getParameter("seq");
		
		// 2.
		TodoDAO dao = new TodoDAO();
		int result = dao.del(seq); // 성공하면 1, 실패하면 0
		
		// 3. result를 받아 사용자에게 피드백
		req.setAttribute("result", result);
		req.getRequestDispatcher("/WEB-INF/views/delok.jsp").forward(req, resp);
		
	}
}