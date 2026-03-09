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
	<!-- ex13_session_2.jsp -->
	<h1>두번째 페이지</h1>
	<!-- 첫번째 페이지에서 만들고 두번째 페이지에서 읽기만 해보자 -->
	
	<!-- a는 지역변수라서 시도조차도 못함 -->
	<%-- <div>a: <%= a %></div> --%>
	<div>b: <%= session.getAttribute("b") %></div>
	<div>c: <%= application.getAttribute("c") %></div>
	
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>