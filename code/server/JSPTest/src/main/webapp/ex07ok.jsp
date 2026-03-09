<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String color = request.getParameter("color");
	String txt = request.getParameter("txt");
	int count = Integer.parseInt(request.getParameter("count"));



%>
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
	<!-- ex07ok.jsp -->
	<h1>결과</h1>
	<div>
		<!-- 만들어질 상자 -->
		<% for(int i=0; i<count; i++) { %>
<div style="border: 1px solid black; width: <%= width %>px; height: <%= height %>px; background-color: <%= color %>;"><%= txt %></div>
<% } %>
	</div>	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>