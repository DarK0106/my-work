<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- ex15_session.jsp -->
	<!--  
		- ex15_session.jsp  //메인
		- ex15_set.jsp		
		- ex15_del.jsp
		- ex15_interval.jsp
		- ex15_reset.jsp
	-->
	
	<h1>세션, Session 수정</h1>
	
	<div>
		<a href="ex15_set.jsp">세션값 저장하기</a>
		<a href="ex15_del.jsp">세션값 삭제하기</a>
		<a href="ex15_reset.jsp">세션 초기화</a>
		<a href="ex15_interval.jsp">세션 만료 시간 설정</a>
	</div>
	
	<h2>세션 정보</h2>
	<div>
		Session ID: <%= session.getId() %>
	</div>
	<div>
		<%
		
			Calendar time = Calendar.getInstance();
			time.setTimeInMillis(session.getCreationTime());
		%>
		Session CreateTime: <%= String.format("%tF %tT", time, time) %>
	</div>
	<div>
		Session Max Inactive Interval: <%= session.getMaxInactiveInterval() %>
	</div>
	<div>
		Session isNew: <%= session.isNew() %>
	</div>
	<div>
		Session Data: <%= session.getAttribute("data") %>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>






