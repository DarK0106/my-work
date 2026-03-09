<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- ex12_out.jsp -->
	<h1>구구단</h1>
	<% int dan = 5; %>
	<h2>스크립틀릿 + 표현식</h2>
	
	<% for (int i=1; i<=9; i++) { %>
	<div><%= dan %> * <%= i %> = <%= dan * i %></div>
	<% } %>
	<!-- 코드가 너무 어지러움 -->
	<!-- 둘 중 편한 방식으로 사용할 것 -->
	<h2>out 객체</h2>
	
	<%
		// out == Servlet의 PrintWriter
		for (int i=1; i<=9; i++) {
			out.println(String.format("<div>%d * %d = %d</div>", dan, i, dan * i));
		}
	
	
	%>
	
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>