<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 어떤 이미지를 삭제해야되나요?
			
	// 1. 파일명 가져오기
	// 2. 이미지 파일 삭제하기
	// 3. 목록으로 돌아가기
	
	// ex18del.jsp?filename
	String filename = request.getParameter("filename");

	String path = application.getRealPath("/pic");
	
	File file = new File(path + "/" + filename);
	file.delete();
	
	response.sendRedirect("ex18.jsp");


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
	<!-- ex18del.jsp -->
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>