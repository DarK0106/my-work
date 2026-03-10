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
	<!-- ex15_interval.jsp -->
	<h1>세션 만료 시간 설정하기</h1>
	<%
		// 실행하는 순간 내 세션의 만료 시간이 30분에서 30초로 변경됨
		session.setMaxInactiveInterval(30); // 단위: 초
	
	
	%>
	<div><a href="ex15_session.jsp">돌아가기</a></div>
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>