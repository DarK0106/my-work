<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Cookie Example</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- ex23_cookie.jsp -->
	<h1>쿠키 <small>JavaScript</small></h1>
	
	<div>
		<input type="button" value="쿠키에 데이터 저장하기" id="btn1">
		<input type="button" value="쿠키의 데이터 읽기" id="btn2">
	</div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script src="js/cookie.js"></script>
	<script>
	
		$('#btn1').click(() => {
			
			//쿠키 쓰기
			console.log(document.cookie);
			
			// 쿠키의 자료형은 문자열
			// 쿠키는 문자열 변수
			console.log(typeof document.cookie);
			
			// document.cookie = '홍길동';
			setCookie('name', '홍길동');
			setCookie('kor', '100');
			setCookie('english', '90');
			setCookie('math', '80');
			
		});
		
		$('#btn2').click(() => {
			// console.log(document.cookie);
			console.log(getCookie('name'));
			console.log(getCookie('kor'));
			console.log(getCookie('english'));
			console.log(getCookie('math'));
		});
	
	</script>
</body>
</html>
