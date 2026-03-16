<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Semi Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
</style>
</head>
<body>
	<!-- info.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	<div id="main">
		<h1>
			회원 <small>정보</small>
		</h1>

		<table id="info">
			<tr>
				<td rowspan="3"><img src="/semi/asset/pic/${dto.pic}"></td>
				<th>이름</th>
				<td>${dto.name}</td>
				<th>아이디</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${dto.lv == '1' ? '일반회원' : '관리자'}</td>
				<th>이메일</th>
				<td>${dto.email}</td>
			</tr>
			<tr>
				<td colspan="4">${dto.intro}</td>
			</tr>
		</table>

	</div>


	<script>
		
	</script>
</body>
</html>