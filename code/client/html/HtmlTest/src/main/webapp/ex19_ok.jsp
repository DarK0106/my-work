<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과</h1>
	<!-- <input type = "text" name = "id"> -->
	<p>전달받은 아이디: <%= request.getParameter("id") %></p>
</body>
</html>