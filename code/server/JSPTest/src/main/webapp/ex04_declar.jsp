<%@page import="com.test.java.MyUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 자바 영역 -> 정확하게 이 영역이 어느 영역일까?
	
	// 지역 변수 vs 멤버 변수
	int a = 10; // 이게 지역 변수일까 멤버 변수일까?
	
	/* 
	public void test {
		
	} 
	*/
	
	
	/* 
	class Test {
		
	} 
	*/
	
	// 이 영역(스클립틀릿)이 어떤 메서드의 블럭이다
	// 따라서 a는 지역변수
	// 메서드 안에서 메서드를 못 만드니 에러가 나는 것
	// 자바는 클래스 안에 클래스를 만들 수 있음
	// 요즘은 중첩 클래스는 잘 사용하지 않는다
	
	// 모든 스클립틀릿 영역은 하나의 {} 영역 안에 포함된다.


%>
<%!
	//다른 영역 -> 클래스 영역
	
	// 우리가 이 클래스의 이름도 몰라서 잘 사용하지 않는 방식
	public int b = 20;
	
	// 자주 써야하는 기능을 메서드로 만들어보자
	public int sum(int a, int b) {
	
		return a + b;
	}

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
	<!-- ex04_declar.jsp -->
	<%
		// 밑에 자바 영역을 하나 또 만들었는데 이건 다른 영역일까?
		// 위에 만들어놓은 자바 영역이랑 같은 영역임
		System.out.println(a);
	
	
	%>
	
	<div><%= sum(30, 40) %></div>
	
	<hr>
	
	<%
		/* Ctrl + space 로 import */
		/* JSP에서 import는 페이지 지시자를 사용 */
		MyUtil util = new MyUtil();
	
	
	%>
	<div><%= util.sum(50, 60) %></div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>