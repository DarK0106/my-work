<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Memo</title>
	<%@ include file="/inc/asset.jsp" %>
	<style>
		
	</style>
</head>
<body>
	<!-- add.jsp -->
	<%@ include file="/inc/header.jsp" %>
	<h2>메모 <small>쓰기</small></h2>
	<!--  
		(*중요) <input> 태그의 name과 DB의 컬럼명을
		동일하게 작성하는 습관을 들여라
	
	-->
	<form action="/memo/addok.jsp" method="POST">
		<table class="vertical">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="pw" required /></td>
			</tr>
			<tr>
				<th>메모</th>
				<td><textarea name="memo" required class="full"></textarea></td>
			</tr>
		</table>
		<div><button type="submit" class="add">쓰기</button></div>
		<div><button type="button" class="back" onclick="location.href='/memo/list.jsp';">돌아가기</button></div>
	</form>
	
	
	<script>
		
	</script>
</body>
</html>