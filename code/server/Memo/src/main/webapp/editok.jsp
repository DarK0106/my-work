<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.memo.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// edit 가 준 데이터
	
	// 1. 데이터 가져오기(pw, memo)
	// 데이터를 왜 가져왔나? DB에 넣으려고
	// 2. DB 작업 -> 메모 수정하기(update)
	// 3. 사용자에게 피드백을 주는 마무리 작업을 해야함: list로 돌아가기
	
	// POST + 한글 -> UTF-8
	request.setCharacterEncoding("UTF-8");
	
	// 1. 데이터 가져오기(name, pw, memo)
	String pw = request.getParameter("pw"); 
	String memo = request.getParameter("memo");
	String seq = request.getParameter("seq");
	
	// 2. DB 작업 -> 메모 수정하기(update)
	DBUtil util = new DBUtil();
	Connection conn = null;
	PreparedStatement stat = null;
	ResultSet rs = null;
	
	conn = util.open();
	
	// 암호 확인하기
	String sql = "select count(*) as cnt from tblMemo where seq = ? and pw = ?";
	stat = conn.prepareStatement(sql);
	
	stat.setString(1, seq);
	stat.setString(2, pw);
	
	rs = stat.executeQuery();
	
	int count = 0;
	
	if (rs.next()) {
		count = rs.getInt("cnt"); 
	}
	
	rs.close();
	stat.close();
	
	if (count == 1) {
	// 수정하기
	sql ="update tblMemo set memo =? where seq = ?";
	
	stat = conn.prepareStatement(sql);
	
	stat.setString(1, memo);
	stat.setString(2, seq);
	
	int result = stat.executeUpdate();
	
	if (result ==1) {
		response.sendRedirect("/memo/list.jsp");
	} else {
		out.println("<script>alert('메모 작성을 실패했습니다.');history.back();</script>");
		out.close(); // 더 이상 아래쪽의 값들은 클라이언트에게 반환할 필요가 없기 때문에 여기서 멈추도록
	}
	} else {
		out.println("<script>alert('비밀번호가 다릅니다.');history.back();</script>");
	}
	
	stat.close();
	conn.close();
	
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
	<!-- editok.jsp -->
	<%@ include file="/inc/header.jsp" %>
	<h2>메모 <small>수정하기</small></h2>
	
	<script>
	
	</script>
</body>
</html>