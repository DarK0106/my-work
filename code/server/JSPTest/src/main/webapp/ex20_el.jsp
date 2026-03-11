<%@page import="com.test.java.Student"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- ex20_el.jsp -->
	<h1>EL</h1>
	<%
		// 자바 변수 선언
		int a = 10;
	
		// request 이런건 예약어이자 변수?
		// 자바에서는 이런 문법이 존재하지 않는다
		// JSP에서는 어떻게 키워드만 작성하면 그 안에 객체나 값이 들어갈까?
		// 눈속임을 한 것? 서블릿 클래스로 변환?
		// request는 사실 jspService 메서드의 첫 번째 매개변수이다?
				
		/*
		request는 자바의 예약어(public, int 같은 것)가 아닙니다. JSP가 미리 만들어 놓은 '변수'
		이런 것들을 JSP에서는 **내장 객체(Implicit Object)
		HttpServletRequest request = new ... 처럼 선언하지 않아도 
		그냥 가져다 쓸 수 있도록 서버가 알아서 준비해 주는 객체들이죠.
		우리가 작성한 파일은 .jsp이지만, 톰캣(Tomcat) 같은 웹 서버는 
		이 파일을 그대로 실행하지 않습니다
		내부적으로 JSP 파일을 자바 코드 파일(.java)인 서블릿(Servlet) 클래스로 몰래 변환한 다음, 
		그것을 컴파일(.class)해서 실행합니다. 즉, 겉모습만 HTML과 섞인 JSP일 뿐, 
		진짜 정체는 완벽한 자바 클래스입니다.
		*/
		
		// 내장 객체 변수 선언(변수는 아닌데 변수 비슷한 것)
		pageContext.setAttribute("b", 20);
		request.setAttribute("c", 30);
		session.setAttribute("d", 40);
		application.setAttribute("e", 50);
		
		// request 안에도 c가 있고, session 안에도 c가 있다면?
		session.setAttribute("c", 60);
		
		// EL
		// - ${내장 객체의 key}
		// - 지역 변수 출력은 할 수 없음
		// - 내장 객체 변수 출력 전용(*중요)
		
		// EL의 키에는 우선 순위가 존재
		// 생명 주기: application > session > request > pageContext
		// 생명 주기가 짧은게 우선 순위가 더 높다?
	
	
	%>
	
	<h2>표현식</h2>
	<div>a: <%= a %></div>
	<div>b: <%= pageContext.getAttribute("b") %></div>
	<div>c: <%= request.getAttribute("c") %></div>
	<div>d: <%= session.getAttribute("d") %></div>
	<div>e: <%= application.getAttribute("e") %></div>
	
	<h2>EL</h2>
	<!-- 셋 다 잘못 작성함 -->
	<div>a: ${a}</div>
	<%-- <div>b: ${pageContext.getAttribute("b")}</div> --%>
	<div>c: ${request.getAttribute("c")}</div>
	
	<!-- a는 지역 변수라서 EL로는 출력할 수 없음 -->
	<div>b: ${b}</div>
	<div>c: ${c}</div>
	<div>d: ${d}</div>
	<div>e: ${e}</div>
	<div>c: ${c}</div>
	
	<h2>EL에서의 우선순위</h2>
	<!-- Scope를 쓰면 내가 원하는 내장 객체의 key를 가져올 수 있다 -->
	<!-- 잘 안씀, key가 겹칠 일이 희박함 -->
	<div>b: ${pageScope.b}</div>
	<div>c: ${requestScope.c}</div>
	<div>d: ${sessionScope.d}</div>
	<div>e: ${applicationScope.e}</div>
	<div>c: ${sessionScope.c}</div>
	
	<hr />
	
	<h2>EL 기능</h2>
	
	<h3>연산 기능</h3>
	
	<%
		pageContext.setAttribute("n1", 10);
		pageContext.setAttribute("n2", 3);
	
	
	
	%>
	
	<div>n1 + 10 = <%= (int)pageContext.getAttribute("n1") + 10 %></div>
	<div>n1 + n2 = <%= (int)pageContext.getAttribute("n1") + (int)pageContext.getAttribute("n2") %></div>
	<!-- 문제: 코드가 너무 길다 -->
	
	
	<h3>연산 기능(EL)</h3>
	<!-- 코드도 짧고 형변환도 알아서 해줌(암시적 형변환) -->
	<div>n1 + 10 = ${n1 + 10}</div>
	<div>n1 + n2 = ${n1 + n2}</div>
	<div>n1 - n2 = ${n1 - n2}</div>
	<div>n1 * n2 = ${n1 * n2}</div>
	<div>n1 / n2 = ${n1 / n2}</div>
	<div>n1 % n2 = ${n1 % n2}</div>
	<div>n1 mod n2 = ${n1 mod n2}</div>
	
	<hr />
	
	<!-- 비교연산은 출력하려고 쓰진 않음 -->
	<!-- 나중에 조건문 쓸 때 씀 -->
	<div> &lt; 기호는 작다라는 표현입니다.</div>
	<div> &lt;br&gt; 태그는 개행입니다.</div>
	<div>n1 > n2 = ${n1 > n2}</div>
	<div>n1 >= n2 = ${n1 >= n2}</div>
	<div>n1 < n2 = ${n1 < n2}</div>
	<div>n1 <= n2 = ${n1 <= n2}</div>
	<div>n1 == n2 = ${n1 == n2}</div>
	<div>n1 != n2 = ${n1 != n2}</div>
	
	<hr />
	<div>${true && true}</div>
	<div>${true || true }</div>
	<div>${!true }</div>
	
	<div>${true and true}</div>
	<div>${true or true }</div>
	<div>${not true }</div>
	
	<hr>
	
	<div>${n1 > 0 ? "양수" : "음수" }</div>
		
	<hr />
	<!-- 주소값 비교를 해버림 -->
	<%-- <div>${"홍길동".equals("홍길동")}</div> --%>
	
	<!-- 주소가 아닌 값으로 비교 -->
	<div>${"홍길동" == "홍길동"}</div>
	
	<hr />
		
	<%
		/* map은 굳이 따지면 지역변수 */
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", "홍길동");
		map.put("gender", "남자");
		map.put("address", "서울시");
		
		/* 지역변수를 바로 접근은 못하고 pageContext, request든 어디든 내장 객체에 넣어야 */
		/* 그때 접근 가능함 */
		pageContext.setAttribute("map", map);
		
	
	
	%>
	
	<h3>객체 요쇼 / 멤버 접근 표현</h3>
	
	<div>${map}</div>
	
	<ul>
		<li>이름: <%= map.get("name") %></li>
		<li>성별: <%= map.get("gender") %></li>
		<li>주소: <%= map.get("address") %></li>
	</ul>
	
	<h3>EL 방식</h3>	
	<ul>
		<li>이름: ${map.get("name")}</li>
		<li>성별: ${map["gender"]}</li>
		<li>주소: ${map.address}</li>
	</ul>
	
	<%
		Student s1 = new Student();
	
		s1.setName("아무개");
		s1.setGender("남자");
		s1.setAddress("서울시");
		
		session.setAttribute("s1", s1);
	
	
	%>
	
	<div>${s1}</div>
	<ul>
		<li>이름: <%= s1.getName() %></li>
		<li>성별: <%= s1.getGender() %></li>
		<li>주소: <%= s1.getAddress() %></li>
	</ul>
	
	<h3>EL 방식</h3>	
	<ul>
		<li>이름: ${s1.getName()}</li>
		<li>성별: ${s1["gender"]}</li>
		
		<!-- address는 멤버 변수가 아니다 -->
		<!-- address는 get 메서드 이름이다 -->
		<!-- get 메서드를 부른 것 -->
		<!-- EL은 address를 메서드 이름이라고 생각함 -->
		<!-- EL이 내부적으로 address에 앞에 get붙이고 address를 Address로 바꾸고 합침 -->
		<!-- ${s1.address} == getAddress() -->
		<li>주소: ${s1.address}</li>
	</ul>
	
	<hr />
	
	<%
		Student s3 = null;
		String txt1 = null;
		String txt2 = "";
		
		pageContext.setAttribute("s3", s3);
		pageContext.setAttribute("txt1", txt1);
		pageContext.setAttribute("txt2", txt2);
	
	
	
	%>
	<div>${s3 == null}</div>
	<!-- 문자열 검사는 null이거나 ""(빈 문자열)이냐고 검사함 -->
	<div>${txt1 == null}</div>
	<div>${txt2 == ""}</div>
	<div>${txt1 == null or txt1 == ""}</div>
	
	<!-- 이게 불편해서 EL은 empty라는 연산자를 만들었음 -->
	<div>${empty s3}</div>
	<div>${empty txt1}</div>
	<div>${empty txt2}</div>


	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>