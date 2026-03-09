<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1페이지 -> (이동) -> 2페이지
		
		1. HTML
		- <a href="URL">
		- 사용자가 클릭해야만 이동 가능
		
		2. JavaScript
		- location.href = 'URL'; <- 브라우저의 속성(프로퍼티)
			- 변수에 값을 대입하듯(=) 사용
		- location.assign('URL'); <- 브라우저의 메서드
			- 함수를 실행하듯( () ) 사용
		- 자유롭게 원하는 상황에 호출 -> 제어 가능
		- 클라이언트 측에 구현
		
		3. Servlet/JSP
		- response.sendRedirect("URL");
		- 자유롭게 원하는 상황에 호출 -> 제어 가능
		- 서버 측에 구현
	
	
	*/
	
	response.sendRedirect("ex10_response_two");
	


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
	<!-- ex10_response_one.jsp -->
	<h1>첫번째 페이지</h1>
	
	<div><a href="ex10_response_two.jsp">두번째 페이지</a></div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		location.href = 'ex10_response_two.jsp';
	</script>
</body>
</html>