<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
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
	<!-- ex22_jstl.jsp -->
	<h1>JSTL</h1>
	
	<!--  
	
		JSTL
		- 프로그래밍 기능을 가진 태그
		- 변수
		- 조건문
		- 반복문
		- 등
		
		JSTL 설치
		1. jstl.jar 가져오기
		2. taglib 선언하기
	
	-->
	
	<h2>변수 선언</h2>
	
	<%
		int a = 10; // 지역 변수
		pageContext.setAttribute("b", 20); // 내장 객체 변수
	
	%>
	
	<!-- JSTL 변수 == pageContext 변수 -->
	<!-- pageContext.setAttribute("b", 20); 랑 똑같은 행위임 -->
	<c:set var="c" value="30"></c:set>
	
	<div>c: ${c}</div>
	<div>c: ${pageScope.c}</div>
	<div>c: ${requestScope.c}</div>
	<div>c: ${sessionScope.c}</div>
	<div>c: ${applicationScope.c}</div>
	
	<h2>변수 수정하기</h2>
	<c:set var="c" value="50"></c:set>
	<div>c: ${c}</div>
	
	<h2>변수 삭제하기</h2>
	<!-- 말은 삭제지만 hashmap에 들어있는 key를 삭제하는 것 -->
	<c:remove var="c"></c:remove>
	<div>c: ${c}</div>
	<div>c: ${c == null}</div>
	<div>c: ${empty c}</div>
	
	<h2>조건문</h2>
	<c:set var="num" value="10"></c:set>
	
	<!-- 어디서든 내장 객체 변수를 사용하려면 반드시 EL을 사용해야 한다. -->
	<!-- JSTL은 EL이 없으면 대부분의 상황에서 스스로 동작하지 못함 -->
	<c:if test="${num > 0}">
    	<div>${num}은 양수입니다.</div> 
	</c:if>
	<c:if test="${num <= 0}">
    	<div>${num}은 양수가 아닙니다.</div>
	</c:if>
	
	<h2>조건문(다중 if문)</h2>
	
	<div>
		<c:choose>
			<c:when test="${num >0}">양수</c:when>
			<c:when test="${num <0}">음수</c:when>
			<c:otherwise>0</c:otherwise>
		</c:choose>
	</div>
	
	<h2>반복문(일반 for문 or 향상된 for문)</h2>
	<% for (int i=1; i<=10; i++) { %>
		<div>숫자: <%= i %></div>
	<% } %>
	
	<!-- step에 음수는 줄 수 없다 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<div>숫자: ${i}</div>
	</c:forEach>
	
	<%
		String names[] = {"홍길동", "엄준식", "호날두", "메시", "피카츄"};
		
		pageContext.setAttribute("names", names);
	
	
	
	%>
	
	<!-- for (String name : names) {} -->
	<c:forEach var="name" items="${names}">
		<div>${name}</div>
	</c:forEach>
	
	<table>
		<tr>
			<th>이름</th>
			<th>index</th>
			<th>count</th>
			<th>current</th>
			<th>first</th>
			<th>last</th>
		</tr>
		<c:forEach items="${names}" var="name" varStatus="status">
		<tr>
			<td>${name}</td>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${status.current}</td>
			<td>${status.first}</td>
			<td>${status.last}</td>
		</tr>
		</c:forEach>
	</table>
	
	<h2>출력문</h2>
	<!--  
		게시판 글쓰기
		<div>안녕하세요. <b>홍길동</b>입니다.</div>
	
	
	-->
	
	<c:set var="line" value="<div>안녕하세요. <b>홍길동</b>입니다.</div>"></c:set>
	<div>${line}</div>
	
	<!-- <div>안녕하세요. <b>홍길동</b>입니다.</div> -->
	<!-- 이 내용에 있는 태그들이 작동이 안되게 만든 다음 출력하고 싶다 -->
	<div>${line.replace("<", "&lt;").replace(">", "&gt;")}</div>
	<div><c:out value="${line}"></c:out></div>
	<div><c:out value="${line}" escapeXml="true"></c:out></div>
	<div><c:out value="${line}" escapeXml="false"></c:out></div>
	
	<c:set var="price" value="1234567"></c:set>
	<div>가격: ${price}원</div>
	<!-- 자릿수를 표시하고 싶다 -->
	<div>가격: <fmt:formatNumber value="${price}"></fmt:formatNumber> 원</div>
		
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>






