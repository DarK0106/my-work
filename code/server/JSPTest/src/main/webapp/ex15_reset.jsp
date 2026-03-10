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
	<!-- ex15_reset.jsp -->
	<h1>세션 객체 초기화</h1>
	<%
		// 기존 세션 객체 소멸 후 즉시 새로 생성
		session.invalidate(); // 주로 로그아웃 기능에 많이 사용
	
	
	%>
	<div><a href="ex15_session.jsp">돌아가기</a></div>
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>