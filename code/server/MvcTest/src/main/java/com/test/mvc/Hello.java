package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *	MVC 
 *	- Model
 *		- 데이터 조작/관리/전달 역할
 *		- 서블릿에서 count값을 request에 담아서 request를 전달해서 JSP한테 전달
 *		- request는 택배 상자와 같은 역할. 택배 상자를 Model이라고 부른다.
 *	- View
 *		- JSP
 *		- 화면을 만드는 역할
 *		- HTML 페이지 만드는 역할
 *	- Controller
 *		- 클라이언트의 요청을 받고 HTML을 돌려주는 역할
 *		- 전체 흐름을 통제하는 역할
 * 
 * 
 * 
 * 
 * */

// Controller 역할
public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 업무 구현..
		// - DB 작업 -> select count(*)
		// 이 count를 페이지에 출력하고 싶다
		int count = 10;
		
		// PrintWriter -> HTML 제작
		// JSP 위임 -> HTML 제작
		
		// 서블릿이 JSP에게 데이터를 전달
		// 인수인계와 비슷한 형태
		req.setAttribute("count", count);
		
		// Servlet -> (이동) -> JSP
		// resp.sendRedirect("/mvc/hello.jsp");
		// pageContext.forward("/mvc/hello.jsp");
		// 실제로 이동을 한것이 아닌 오브젝트를 만드는 메서드이다
		RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
		dispatcher.forward(req, resp);
		
		// 페이지와 페이지 간에는 데이터 공유가 되지 않는다
		// 서블릿이 dispatcher에서 request와 response를 jsp에 전달하고 있다
	}
	
}
