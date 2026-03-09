<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터 수신하기
	
	// 텍스트 박스
	String txt1 = request.getParameter("txt1");
	
	// 암호 박스
	String txt2 = request.getParameter("txt2");
	
	// 텍스트 박스(다중 라인)
	String txt3 = request.getParameter("txt3");
	
	// 개행 문자 처리(다중 라인 텍스트 박스)
	// - \r\n -> <br>
	txt3 = txt3.replace("\r\n", "<br>");
	
	// 체크 박스
	String cb1 = request.getParameter("cb1");
	// 체크하면 on, 체크 안 하면 null(value가 없으면)
	// 체크하면 value 전송, 체크 안 하면 null(value가 있으면)
	
	// 체크 박스들
	String cb2 = request.getParameter("cb2");
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	
	String temp = "";
	temp += cb2 + ",";
	temp += cb3 + ",";
	temp += cb4 + ",";
	
	// 체크 박스들
	// String cb5 = request.getParameter("cb5");
	// 여러개를 받아올때는 배열로 받아온다
	String[] cb5 = request.getParameterValues("cb5");
	
	// 라디오 버튼
	String rb1 = request.getParameter("rb1");
	
	// 셀렉트 박스
	String sel1 = request.getParameter("sel1");
	
	// 다중 선택 셀렉트 박스
	String[] sel2 = request.getParameterValues("sel2");
	
	// 히든 태그
	String id = request.getParameter("id");
	
	// 날짜
	String regdate = request.getParameter("regdate");
	
	// 색상
	String myColor = request.getParameter("myColor");
	

	// request.getParameter() 동작
	// 1. 사용자가 값을 입력(컨트롤 입력 O) -> 입력값 반환
	// 2. 사용자가 값을 입력하지 않음(컨트롤 입력 X) -> ""(빈 문자열) 반환
	// 3. key가 오타가 나면 null을 반환함
	// 나중에 반환하는 값에 조건문을 걸기 때문에 빈 문자열과 null을 구분해야 함


%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- ex06ok.jsp -->
	<h1>결과</h1>
	
	<h2>텍스트 박스</h2>
	<div><%= txt1 %></div>	
	<h2>암호 박스</h2>
	<div><%= txt2 %></div>
	<h2>텍스트 박스(다중 라인)</h2>
	<div><%= txt3 %></div>		
	<h2>체크 박스</h2>
	<div><%= cb1 %></div>	
	<h2>체크 박스들</h2>
	<div><%= temp %></div>	
	<h2>체크 박스들</h2>
	<div><%= Arrays.toString(cb5) %></div>	
	<h2>라디오 버튼</h2>
	<div><%= rb1 %></div>	
	<h2>셀렉트 박스</h2>
	<div><%= sel1 %></div>	
	<h2>다중 선택 셀렉트 박스</h2>
	<div><%= Arrays.toString(sel2) %></div>	
	<h2>히든 태그</h2>
	<div><%= id %></div>	
	<h2>날짜</h2>
	<div><%= regdate %></div>	
	<h2>색상</h2>
	<div style="background-color: <%= myColor %>;"><%= myColor %></div>
	<h2>고양이 위치</h2>
	<div>
		left: <%= request.getParameter("left") %>
		top: <%= request.getParameter("top") %>
	</div>	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>