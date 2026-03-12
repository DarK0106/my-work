package com.test.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		Random rnd = new Random();
		int dan = rnd.nextInt(9) + 1; // 1~9단

		// 현재 파일 -> 자바 파일
		// 이클립스에서 일일이 작성하기 너무 어렵기 때문에
		// html로 작성한 다음 복사-붙여넣기
		writer.printf("""
												<!DOCTYPE html>
								<html lang="ko">
								<head>
								    <meta charset="UTF-8">
								    <meta name="viewport" content="width=device-width, initial-scale=1.0">
								    <title>구구단</title>
								    <style>
								        h1 {
								            border-bottom: 1px dashed grey;
								            width: 150px;
								            text-align: center;
								        }

								        div {
								            font-size: 1.2rem;
								            margin: 10px;
								        }
								    </style>
								</head>
								<body>

								    <h1>구구단<small>%d단</small></h1>
				""", dan);
		for (int i = 0; i <= 9; i++) {
			writer.printf("<div>%d * %d = %d</div>", dan, i, dan * i);
		}

		writer.print("""
				    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
				    <script>

				    </script>

				</body>
				</html>
								""");

		writer.close();
	}
}