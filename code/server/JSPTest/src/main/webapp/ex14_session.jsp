<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 방문 횟수
	int count = 0;
	count++;
	
	if (session.getAttribute("count") == null) {
		session.setAttribute("count", 1);
	} else {
		session.setAttribute("count", (int)session.getAttribute("count") + 1);
	}
	
	if (application.getAttribute("count") == null) {
		application.setAttribute("count", 1);
	} else {
		application.setAttribute("count", (int)application.getAttribute("count") + 1);
	}



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
	<!-- ex14_session.jsp -->
	<h1>방문 횟수</h1>
	<div>count: <%= count %></div>
	<div>count: <%= session.getAttribute("count") %></div>
	<div>count: <%= application.getAttribute("count") %></div>
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>