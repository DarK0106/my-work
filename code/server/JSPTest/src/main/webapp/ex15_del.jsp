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
	<!-- ex15_del.jsp -->
	<h1>세션값 삭제하기</h1>
	<%
		/*
			집합을 조작하는 메서드명 패턴
			- addXXX(): 추가하기(append, 마지막 추가)
			- insertXXX(): 추가하기(insert, 원하는 위치에 추가)
			- appendXXX(): 추가하기(append, 마지막 추가)
			- prependXXX(): 추가하기(맨앞에 추가)
			- setXXX(): 추가하기
			- getXXX(): 읽기
			- remove(): 삭제하기
			- isXXX(): 확인용 -> boolean 반환
			- containsXXX(): 존재 확인 -> boolean 반환
		
		
		*/
		session.removeAttribute("data");
	
	
	%>
	<div><a href="ex15_session.jsp">돌아가기</a></div>
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>