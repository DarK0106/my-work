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
	<!-- list.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	<div id="main">
		<h1>
			게시판 <small>목록보기</small>
		</h1>
		<table id="list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			<c:forEach items="${list}" var="dto">
				<c:if test="${dto.readcount < 5}">
					<tr>
				</c:if>
				<c:if test="${dto.readcount >= 5}">
					<tr
						${dto.readcount >= 5 ? 'style="background-color: rgba(255, 99, 71, 0.2);"' : ''}>
				</c:if>

				<td>${dto.seq}</td>
				<td><a href="/semi/board/view.do?seq=${dto.seq}">${dto.subject}</a>
					<c:if test="${dto.isnew < 1}">
						<span class="isnew">new</span>
					</c:if></td>
				<td>${dto.name}</td>
				<td>${dto.regdate}</td>
				<td>${dto.readcount}</td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<c:if test="${not empty auth}">
				<button type="button" class="add primary"
					onclick="location.href='/semi/board/add.do';">쓰기</button>
			</c:if>
		</div>

	</div>


	<script>
		
	</script>
</body>
</html>