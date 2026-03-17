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
	<!-- view.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	<div id="main">
		<h1>
			게시판 <small>보기</small>
		</h1>
		<!-- form 페이지는 get메서드 호출 포스트는 같은 서블릿에서 -->
		<table class="vertical">
			<tr>
				<th>번호</th>
				<td>${dto.seq}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.name}(${dto.id})</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><c:out value="${dto.subject}"></c:out></td>
			</tr>
			<tr style="height: 250px;">
				<th>내용</th>
				<td><c:out value="${dto.content}"></c:out></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.readcount}</td>
			</tr>
		</table>
		<div>
			<button type="button" class="back"
				onclick="location.href='/semi/board/list.do';">돌아가기</button>
			<c:if test="${not empty auth and (auth == dto.id || authDto.lv == '2')}">
				<button type="button" class="edit primary"
					onclick="location.href='/semi/board/edit.do?seq=${dto.seq}';">수정하기</button>
				<button type="button" class="del primary"
					onclick="location.href='/semi/board/del.do?seq=${dto.seq}';">삭제하기</button>
			</c:if>
		</div>
	</div>


	<script>
		
	</script>
</body>
</html>