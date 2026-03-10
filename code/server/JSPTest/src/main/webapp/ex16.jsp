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
	<!-- ex16.jsp -->
	<!-- 업로드 & 다운로드 -->
	<!-- 
		파일 업로드 설정
		1. 서버 측
			- 파일 업로드 라이브러리 사용
			- cos.jar 적용
				a. build path -> jar 추가
				b. WEB-INF -> lib -> jar 붙여넣기
		
		2. 클라이언트 측
			a. <input type="file"> 사용
			b. <form method="POST">
			c. <form enctype="">	
				1. application/x-www-form-urlencoded
					- 무슨 뜻일까? -> 전송할 값들을 문자열로 전송합니다.
				2. multipart/formdata로 바꿔야 한다?
					- 문자열과 문자열이 아닌 것들도 다 전송하겠습니다.
	-->
	<h1>파일 업로드<small>단일 파일</small></h1>
	<form action="ex16ok.jsp" method="POST" enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<th>문자열</th>
				<td><input type="text" name="txt" value="홍길동" /></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="attach" /></td>
			</tr>
		</table>
		<div>
			<button>보내기</button>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>