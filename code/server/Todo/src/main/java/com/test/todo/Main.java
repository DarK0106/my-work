package com.test.todo;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.todo.model.TodoDAO;
import com.test.todo.model.TodoDTO;

@WebServlet(value = "/main.do")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Main.java
		// 미리 만들어둔 servlet 템플릿을 이용
		// main 이라고 작성하고 tab, enter
		// Ctrl + Shift + O
		// 1. DB 작업 -> DAO 위임 -> select
		// 2. 결과셋
		// 3. JSP 호출(+결과셋)
		
		// 1. DB 작업 -> DAO 위임 -> select
		TodoDAO dao = new TodoDAO();
		
		// 문제: ResultSet이 JDBC 코드이다.
		// JDBC 코드는 DB 조작하는 코드인데 Main은 DB조작을 하지 않음
		// ResultSet rs = dao.list();
		
		// ResultSet(테이블) -> 자료 구조를 변환(자료형 매핑) -> ArrayList(행)
		// 행을 담는 또 다른 자료구조를 만든다?
		
		ArrayList<TodoDTO> list = dao.list();
		// System.out.println(list);
		
		// req.setAttribute("rs", rs);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
}