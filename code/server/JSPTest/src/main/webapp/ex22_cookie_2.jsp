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
	<!-- ex23_cookie_2.jsp -->
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script src="js/cookie.js"></script>
	<script>
		
		/* 다른 페이지에서 만든 쿠키도 가져올 수 있다 */
		console.log(getCookie('name'));
		console.log(getCookie('kor'));
		console.log(getCookie('english'));
		console.log(getCookie('math'));
	</script>
</body>
</html>