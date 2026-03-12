<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.memo.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// add 가 준 데이터
	
	// 1. 데이터 가져오기(name, pw, memo)
	// 데이터를 왜 가져왔나? DB에 넣으려고
	// 2. DB 작업 -> 메모 쓰기(insert)
	// 3. 피드백 해주는 마무리 작업을 해야함: list로 돌아가기
	
	// POST + 한글 -> UTF-8
	request.setCharacterEncoding("UTF-8");
	
	// 1. 데이터 가져오기(name, pw, memo)
	String name = request.getParameter("name"); 
	String pw = request.getParameter("pw"); 
	String memo = request.getParameter("memo"); 
	
	// 2. DB 작업 -> 메모 쓰기(insert)
	DBUtil util = new DBUtil();
	Connection conn = null;
	PreparedStatement stat = null;
	
	conn = util.open();
	
	String sql ="insert into tblMemo (seq, name, pw, memo, regdate) VALUES (seqMemo.nextval, ?, ?, ?, default)";
	
	stat = conn.prepareStatement(sql);
	
	stat.setString(1, name);
	stat.setString(2, pw);
	stat.setString(3, memo);
	
	int result = stat.executeUpdate();
	
	stat.close();
	conn.close();
	
	if (result ==1) {
		response.sendRedirect("/memo/list.jsp");
	} else {
		out.println("<script>alert('메모 작성을 실패했습니다.');history.back();</script>");
		out.close(); // 더 이상 아래쪽의 값들은 클라이언트에게 반환할 필요가 없기 때문에 여기서 멈추도록
	}
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Memo</title>
	<%@ include file="/inc/asset.jsp" %>
	<style>
		
	</style>
</head>
<body>
	<!-- addok.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<!-- HTML로 피드백 기능 구현하기 -->
	<%--
	<% if (result == 1) { %>
	<h2>메모 <small>쓰기</small></h2>
	<div class="message">메모 작성을 완료했습니다.</div>
	<div><button type="button" class="back" onclick="location.href='/memo/list.jsp';">돌아가기</button></div>
	<% } %>
	
	<% if (result == 0) { %>
	<h2>메모 <small>쓰기</small></h2>
	<div class="message">메모 작성을 실패했습니다. 다시 시도해주세요.</div>
	<div><button type="button" class="back" onclick="location.href='/memo/add.jsp';">돌아가기</button></div>
	
	<!-- 뒤로가기: 브라우저가 수정된 내용(메모)을 기억하고 있음. -->
	<h2>메모 <small>쓰기</small></h2>
	<div class="message">메모 작성을 실패했습니다. 다시 시도해주세요.</div>
	<div><button type="button" class="back" onclick="history.back();">돌아가기</button></div>
	<% } %>
	--%>
	
	<script>
		/* JavaScript로 피드백 기능 구현하기 */
		<%--
		<% if (result == 1) { %>
		alert('메모 작성을 완료했습니다.');
		location.href = '/memo/list.jsp';
		<% } %>
		
		<% if (result == 0) { %>
		alert('메모 작성을 실패했습니다.');
		history.back();
		<% } %>
		--%>
	</script>
</body>
</html>