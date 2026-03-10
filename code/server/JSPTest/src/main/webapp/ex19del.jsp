<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//1. 파일명 가져오기
	//2. 파일명 > 파일 객체(File) > delete()
	//3. 목록으로 돌아가기
	//del.jsp?filename=dog.jpg
	String filename = request.getParameter("filename");
	
	//가상 경로 > 로컬 경로
	String path = application.getRealPath("/files");
	System.out.println(path);
	
	File file = new File(path + "/" + filename);
	file.delete();
	
	response.sendRedirect("ex19.jsp");	

%>    
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
	<!-- ex19del.jsp -->
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>
