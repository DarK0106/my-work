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
	<!-- template.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	<div id="main">
		<h1>
			회원	<small>가입하기</small>
		</h1>
		<form action="/semi/user/register.do" enctype="multipart/form-data"
			method="POST">
			<table class="vertical">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" id="id" required
						class="short"></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="pw" id="pw" required
						class="short"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" id="name" required
						class="short"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<div>
							<input type="email" name="email" id="email" required class="long">
							<input type="button" value="인증 메일 보내기" id="btnMail">
						</div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="attach" id="attach"></td>
				</tr>
				<tr>
					<th>소개</th>
					<td><textarea name="intro" id="intro" class="long"></textarea></td>
				</tr>
			</table>
			<div>
				<button type="button" class="back"
					onclick="location.href='/semi/index.do';">돌아가기</button>
				<button type="submit" class="in primary">가입하기</button>
			</div>
		</form>
	</div>


	<script>
		
	</script>
</body>
</html>