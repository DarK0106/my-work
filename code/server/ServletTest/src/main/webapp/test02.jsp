<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>동적 페이지</h1>

	<%
	Calendar now = Calendar.getInstance();
	if (now.get(Calendar.SECOND) % 2 == 0) {
	%>

	<div id="div1"><%=String.format("%tF", now)%></div>
	<%
	} else {
	%>
	<div id="div2"><%=String.format("%tT", now)%></div>

	<%
	}
	%>
</body>
</html>