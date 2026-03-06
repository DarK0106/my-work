<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 자바 영역
	// 동적 페이지
	int a = 10;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/* CSS 영역 */
	p { color: blue; }
</style>
</head>
<body>
	<h1>Hello</h1>
	
	<p>안녕하세요. 홍길동입니다.</p>
	<p>a: <%= a %></p>
	<script type="text/javascript">
		/* JavaScript 영역 */
	</script>
</body>
</html>