<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 업로드할 파일을 어디에 저장할까?
	// 2. 데이터 가져오기
	
	// 될 줄 알았는데 안됨
	// String txt = request.getParameter("txt");

	// <form enctype="multipart/formdata">
	// 이걸 하는 순간 request의 일부 기능이 동작 안함
	// 	- request.getParameter()
	// 	인코딩 방식이 달라져서 제대로된 데이터를 가져오지 못함
	// 	그래서 cos.jar를 설치했음. cos.jar안에 request 대신 MultipartRequest라는 클래스가
	// 	있는데 그걸 사용할거임
	// 		1. 기존의 request가 하던 getParameter() 사용
	//		2. 파일 업로드 처리 구현 도 가능
	
	// 업로드 위치 경로
	String path = application.getRealPath("/files");
	System.out.println(path);
	
	// 업로드 파일의 최대 크기
	// 단위: Byte
	int size = 1024 * 1024 * 100; // 100MB
	String txt = null;
	String filename = null;
	String orgfilename = null;
	
	try {
		// multi 객체 생성하는 순간 파일 업로드
		MultipartRequest multi = new MultipartRequest(
									request,	// 원래 request
									path,		// 업로드할 경로
									size,		// 최대 크기
									"UTF-8",	//인코딩
									// 중복된 파일이 생기면 알아서 뒤에 숫자를 붙여준다
									new DefaultFileRenamePolicy()
				);
		// 일반 문자열(홍길동)도 가져오기
		txt = multi.getParameter("txt");
		
		// 업로드한 파일명이 뭔지 출력
		filename = multi.getFilesystemName("attach");
		orgfilename = multi.getOriginalFileName("attach");
		
	} catch (Exception e) {
		e.printStackTrace();
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
	<!-- ex16ok.jsp -->
	<!-- 업로드 & 다운로드 -->
	<h1>결과</h1>
	<div>txt: <%= txt %></div>
	<div>filename: <%= filename %></div>
	<div>orgfilename: <%= orgfilename %></div>
	
	<!-- 다운로드 구현 -->
	<!-- 1. 링크를 걸어버린다 -->
	<!--
		장점: 간단함
		단점: 브라우저가 해석 가능한 파일은 다운로드를 받는게 아니라 바로 열어서 보여준다.
			  뒤에 붙은 숫자 때문에 파일명이 다를 수 있음
	
	-->
	<h1>파일 다운로드하기</h1>
	<div>1. 링크를 건다</div>
	<div><a href="/jsp/files/<%= filename %>"><%= orgfilename %></a></div>
	
	<!-- 2. 1번에서 download 속성을 추가한다 -->
	<!--
		장점: 간단함, 의도대로 무조건 다운로드를 받음
		단점: 뒤에 붙은 숫자 때문에 파일명이 다를 수 있음
	-->
	<div>2. 링크를 건다 + download 속성</div>
	<div><a href="/jsp/files/<%= filename %>" download><%= orgfilename %></a></div>
	
	<!-- 3. 다운로드 처리를 직접 구현 -->
	<!-- 
		장점: 완성도 높음
		단점: 직접 코드를 구현해야 함
	-->
	<div>3. 다운로드 처리를 직접 구현</div>
	<div><a href="download.jsp?filename=<%= filename %>&orgfilename=<%= orgfilename %>"><%= orgfilename %></a></div>
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>