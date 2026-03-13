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
	<!-- hello.jsp -->
	<h1>Hello</h1>
	<!-- request에 넣은 값을 출력 -->
	<!-- 서블릿이 JSP에 값을 줘야 하니까 request에 넣은 것 -->
	<!-- 그러면 자연스럽게 JSP에서 EL을 쓸 수 있음 -->
	<div>count: <%= request.getAttribute("count") %></div>
	<div>count: ${count}</div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>