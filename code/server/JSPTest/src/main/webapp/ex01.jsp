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
	/* 화면(브라우저)에 출력하는 것이 아닌 
	소스(HTML 문서)에 출력하는 행동인 익스프레션 */
	/* 소스(HTML 문서) 에 < %= a %>이 들어감 */
	/* 그래서 10rem이 됨 */
	p { color: blue; font-size: <%= a %>rem; }
</style>
</head>
<body>
	<h1>Hello</h1>
	
	<p>안녕하세요. 홍길동입니다.</p>
	<p>a: <%= a %></p>
	<script>
		/* JavaScript 영역 */
	</script>
</body>
</html>