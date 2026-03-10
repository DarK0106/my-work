<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 할일: 업로드한 이미지를 처리하기(= pic 폴더에 저장)
	String path = application.getRealPath("/pic");
	int size = 1024 * 1024 * 100;
	
	/* String filename = null;
	String orgfilename = null; */
	
try {
		
		MultipartRequest multi = new MultipartRequest(
									request,
									path,
									size,
									"UTF-8",
									new DefaultFileRenamePolicy()
								);
				
		//filename = multi.getFilesystemName("attach");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//업로드가 완료된 후 다시 목록으로 돌아가기
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
	<!-- ex18ok.jsp -->
	<!-- <h1>이미지 업로드 완료</h1>
	<div>
		<a href="ex18.jsp">목록으로 돌아가기</a>
	</div> -->
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		alert('이미지 업로드 완료');
		location.href= 'ex18.jsp';
	</script>
</body>
</html>