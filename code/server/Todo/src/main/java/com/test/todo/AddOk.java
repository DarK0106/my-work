package com.test.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.todo.model.TodoDAO;

@WebServlet(value = "/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// AddOk.java
		// HTTPS 상태 405 - 허용되지 않는 메소드
		// 서블릿을 포스트로 불렀으니 doGet이 대답을못함
		// 그래서 doPost로 바꿔야함
		
		// 1. todo에서 데이터 가져오기
		// 2. DB 작업 -> insert
 		// 3. JSP 호출
		
		// 1. todo에서 데이터 가져오기
		req.setCharacterEncoding("UTF-8");
		// 사용자가 입력했던 텍스트박스값
		String todo = req.getParameter("todo");
		
		// System.out.println(todo);
		
		// 컨트롤러가 하는 일이 너무 많아질 것 같아서
		// 2. DB 작업 코드를 따로 빼서 DAO(Data Acces Object) 클래스에 넣자
		TodoDAO dao = new TodoDAO();
		int result = dao.add(todo); // 일을 성공하면 1을 돌려받고, 실패하면 0을 돌려받음
		
		// 3. JSP 호출
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/addok.jsp").forward(req, resp);
	}
}