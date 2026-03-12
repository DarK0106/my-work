package com.test.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet {
	// 브라우저에 주소를 직접 입력해서 서블릿을 호출하면 
	// 서버는 이걸 GET 방식으로 호출했다고 생각함
	// 이 서블릿은 반드시 GET 방식으로만 호출 가능
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("""

								<!DOCTYPE html>
				<html lang="ko">
				<head>
				    <meta charset="UTF-8">
				    <meta name="viewport" content="width=device-width, initial-scale=1.0">
				    <title>데이터 입력받기</title>
				    <style>
				        button {
				            display: block;
				            margin-top: 10px;
				        }
				    </style>
				</head>
				<body>
				    <!-- ex03.do -->
				    <h1>데이터 입력받기</h1>
				    <form method="GET" action="/servlet/ex03Ok.do">
				        아이디: <input type="text" name="txtID">
				        <button type="submit">보내기</button>


				    </form>
				    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
				    <script>

				    </script>

				</body>
				</html>

								""");
		writer.close();
	}
}
