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
	<!-- edit.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	<div id="main">
		<h1>
			게시판 <small>수정하기</small>
		</h1>
		<!-- form 페이지는 get메서드 호출 포스트는 같은 서블릿에서 -->
		<form action="/semi/board/edit.do" method="POST">
			<table class="vertical">
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" id="subject" required
						class="full" value="${dto.subject}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content" required
							class="full">${dto.content}</textarea></td>
				</tr>
			</table>
			<div>
				<button type="button" class="back"
					onclick="location.href='/semi/board/view.do?seq=${dto.seq}';">돌아가기</button>
				<button type="submit" class="edit primary">수정하기</button>
			</div>
			<input type="hidden" name="seq" value="${dto.seq}" />
		</form>
	</div>


	<script>
		
	</script>
</body>
</html>