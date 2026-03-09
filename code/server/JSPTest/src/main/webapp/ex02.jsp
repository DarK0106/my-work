<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 자바 영역을 만든다

	Random rnd = new Random();
	int dan = rnd.nextInt(8) + 2; // 2~9단
	%>
	<h1>
		구구단 <%=dan%>단
	</h1>
	<%
	// 수많은 언어들이 섞여있는 스파게티 코드
	for (int i = 1; i <= 9; i++) {
	%>
	<div><%=dan%> * <%=i%> = <%=dan * i%></div>
	<%
		}
	%>
	
	<%@ include file="inc/copyright.jsp"%>
</body>
</html>