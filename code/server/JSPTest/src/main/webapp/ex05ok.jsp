<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		클라이언트 쪽에서 서버 쪽으로 데이터를 보낸 상황
		그걸 수신해보자
		
		1. POST
			- 패킷 본문에 넣어서 전송(표준)
			- 데이터가 드러나지 않는다.
			- 데이터 길이 제한 없음
			
		2. GET
			- URL 뒤에 붙여서 전송(편법)
			- URL 뒤에 데이터가 드러난다.
			- URL은 원래 최대 256자 이내였음
			- 주로 짧은 데이터만 전송하는 용도
			- 페이지주소?key=value&key=value&key=value <- Query String 방식
			- 내 친구한테 할인 링크를 보내주고 싶은데 
			- 복사 붙여넣기를 하는 순간
			- 엄청 긴 링크를 보내주는 대참사 발생
	
	
	*/
	
	// 데이터 수신하기
	// - String request.getParameter(String key)
	// 	- request 객체가 받은 데이터
	// - key: 태그의 name
	
	// <input type="text" name="txt">
	
	// txt, num 이라는 key 를 못 찾으면 null을 반환함
	// ex05라는 페이지로부터 접근해야만 가치가 생기는 ex05ok
	String txt = request.getParameter("txt");
	String num = request.getParameter("num");


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
	<!-- ex05ok.jsp -->
	<h1>결과</h1>
	<div>txt: <%= txt %></div>
	<div>num: <%= num %></div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>