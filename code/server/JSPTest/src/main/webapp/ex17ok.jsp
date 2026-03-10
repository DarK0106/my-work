<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 업로드 위치 경로
	String path = application.getRealPath("/files");
	System.out.println(path);
	
	// 업로드 파일의 최대 크기
	// 단위: Byte
	int size = 1024 * 1024 * 100; // 100MB
	
	// 다중 파일 업로드
	String txt = null;
	ArrayList<String> filename = new ArrayList<String>();
	ArrayList<String> orgfilename = new ArrayList<String>();
	
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
		Enumeration e = multi.getFileNames(); // 반환값: Enumeration, iterator와 비슷?
				
		while (e.hasMoreElements()) {
			String file = (String)e.nextElement();
			System.out.println(file);
			
			// 실제 파일 이름을 배열에 누적시킨다
			filename.add(multi.getFilesystemName(file));
			
			orgfilename.add(multi.getFilesystemName(file));
		}
		
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
	<!-- ex17ok.jsp -->
	<h1>결과</h1>
	
	<div>txt: <%= txt %></div>
	
	<div>
		<div>첨부파일: <%= filename.size() %>개</div>
		<% for (int i=0; i<filename.size(); i++) { %>
		<div>
			<a href="download.jsp?filename=<%= filename.get(i) %>&orgfilename=<%= orgfilename.get(i) %>"><%= 			orgfilename.get(i) %></a>
		</div>
		<% } %>
	</div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>