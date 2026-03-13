<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Todo</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<link rel="stylesheet" href="/todo/css/main.css" />
</head>
<body class="narrow">
	<!-- main.jsp -->
	<h1 class="main">Todo List</h1>
	
	<table id="tbl1">
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><input type="checkbox" /></td>
			<td>${dto.todo} ${dto.state}<span>${dto.regdate}</span></td>
		</tr>
		</c:forEach>
		
		<c:if test="${dto.state == 'n'}">
			<tr>
				<td><input type="checkbox" checked /></td>
				<td class="checked"></td>
			</tr>
		
		</c:if>
		
	</table>
	
	<hr>
	
	<form method="POST" action="/todo/addok.do">
	<table id="tbl2">
		<tr>
			<td><input type="text" name="todo" required class="long" /></td>
			<td><input type="submit" value="등록하기" /></td>
		</tr>
		
		
	</table>
	
	
	</form>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		// 완료 또는 미완료를 체크할 때
		$('#tbl1 input[type=checkbox]').change(() => {
			
			// event.target.checked
			// alert($(event.target).prop('checked'));
			
			// event.target.dataset['seq']
			alert($(event.target).data('seq'));
			
			// location.href = '/todo/checkok.do?state=y';
			
		});
	
	
	</script>
</body>
</html>