<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- index.jsp -->
	<h1>시작 페이지</h1>
	
	<div>
		<input type="button" value=" 로그인 "
			onclick="location.href='/auth/auth/login.do';">
	</div>
	
	<hr>
	
	<c:if test="${not empty auth}">
	<div class="message short" title="개인 정보">
		<div>아이디: ${auth}</div>
	</div>
	</c:if>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>






