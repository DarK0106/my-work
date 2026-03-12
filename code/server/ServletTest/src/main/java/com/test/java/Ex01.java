package com.test.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;

//인도네시아
//- 자바섬
//- 자카르타
//- 롬복

//Tomcat 9.X > 10.X
//       javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 선언
//a. javax.servlet.http.HttpServlet 클래스를 상속받는다. > 단순함. 저비용
public class Ex01 extends HttpServlet {
	
//	2. doGet/doPost 메서드 선언
//		a. 매개 변수 작성
//			1. javax.servlet.http.HttpServletRequest
//			2. javax.serlvet.http.HttpServletResponse
//		b. 예외 미루기
//			1. java.io.IOException
//			2. javax.servlet.ServletException

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//3. (동적으로) HTML 페이지 작성
		//- BufferedWriter 역할 > 텍스트 파일 생성(*.txt)
		//- PrintWriter    역할 > 텍스트 파일(HTML 파일 > *.html)
		PrintWriter writer = response.getWriter();
		
		Calendar now = Calendar.getInstance();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Servlet</h1>");
		writer.printf("<p>%tF %tT</p>", now, now);
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close(); //문서 완성 > 브라우저에게 전달
		
	}
	
}