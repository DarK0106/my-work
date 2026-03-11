<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- ex23_cookie.jsp -->
	<!--  
		브라우저 입장에서 잊어버려도 부담이 없는 정보들
		(어차피 사용자가 기억할테니)
		1. 아이디 기억하기(아이디 -> 쿠키 저장)
		2. 자동 로그인하기(아이디, 암호 -> 쿠키 저장)
	
	
	-->
	<h1>로그인 예제</h1>
	<form method="POST" action="ex23_cookie_ok.jsp">
	<table class="vertical content">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" required class="short"></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="pw" required class="short"></td>
		</tr>
	</table>
	<div>
		<div style="margin-bottom: 15px;"><label><input type="checkbox" name="cbRemember" id="cbRemember" value="y"> 아이디 기억하기</label></div>
		<div><input type="submit" value="로그인"></div>
	</div>
	</form>
	
	<hr />
	<c:if test ="${not empty id}">
	<div>로그인 됨</div>
	
	</c:if>
	
	<c:if test ="${empty id}">
	<div>로그인 안됨</div>
	
	</c:if>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script src="js/cookie.js"></script>
	<script>
		
		// $('input[name=id]').focus();
		
		if (getCookie('id') == '') {
			// 아이디 기억하기 X
			$('input[name=id]').focus();
		} else {
			// 아이디 기억하기 O
			$('input[name=id]').val(getCookie('id'));
			// 아이디는 기억되었으니 사용자 편의성을 위해 비밀번호에 커서가 미리 이동함
			$('input[name=pw]').focus();
			// 아이디 기억하기 옵션을 자동으로 체크하기
			$('#cbRemember').prop('checked', true);
			
		}
	
	</script>
</body>
</html>