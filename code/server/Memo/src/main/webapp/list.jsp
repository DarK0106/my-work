<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.memo.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//1. DB 작업 > 목록 가져오기(select)
//2. 결과셋 > 화면 출력

DBUtil util = new DBUtil();
Connection conn = null;
Statement stat = null;
ResultSet rs = null;

// 쿼리문을 미리 적어두는 것
String sql = "select * from tblMemo order by seq desc";

// 자바 <-> 오라클을 연결하는 통로
conn = util.open();

// 통로를 달릴 수 있는 트럭
stat = conn.createStatement();

// 실제로 쿼리문(택배)을 보내는 코드
// 오라클이 반환한건 rs에 담김
rs = stat.executeQuery(sql);

//while (rs.next()) {
//태그 생성
//}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Memo</title>
<%@ include file="/inc/asset.jsp"%>
<style>
</style>
</head>
<body>
	<!-- list.jsp -->
	<%@ include file="/inc/header.jsp"%>
	<h2>
		메모 <small>목록보기</small>
	</h2>

	<div id="list">
		<%
		// rs.next()는 DB에서 커서(화살표)를 다음 칸으로 넘겨줌
		while (rs.next()) {
			String seq = rs.getString("seq");

			String memo = rs.getString("memo");
			memo = memo.replace("\r\n", "<br>");
		%>
		<div class="item">
			<div><%=memo%></div>
			<div>
				<span><%=rs.getString("name")%></span> / <span><%=rs.getString("regdate")%></span>
			</div>
			<div>
				<button type="button" class="edit"
					onclick="location.href='/memo/edit.jsp?seq=<%=seq%>';">수정하기</button>
				<button type="button" class="del"
					onclick="location.href='/memo/del.jsp?seq=<%=seq%>';">삭제하기</button>
			</div>
		</div>
		<%
		}
		rs.close();
		stat.close();
		conn.close();
		%>
	</div>
	<div>
		<button class="add" onclick="location.href='/memo/add.jsp';">쓰기</button>
	</div>

	<script>
		
	</script>
</body>
</html>