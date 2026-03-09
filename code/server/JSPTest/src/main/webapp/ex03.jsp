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
	<!-- ex03.jsp -->
	<!-- 커뮤니티를 만들어보자 -->
	
	<h1>커뮤니티</h1>
	<p>이런 기능</p>
	<p>저런 기능</p>
	<!-- 재사용을 많이 하는 코드인 copyright.jsp -->
	<!-- copyright.jsp를 가져오자 -->
	<!-- iframe은 클라이언트 기술 -> 브라우저가 합쳐줌 -->
	<iframe src="inc/copyright.jsp" width ="800" scrolling="no" frameborder="no"></iframe>
	
	<!-- include 지시자를 사용해보자 -->
	<!-- 서버 기술 -> 톰캣이 합쳐줌 -->
	<!-- 어차피 똑같은거 아님? -> 결론이 다름 -->
	<!-- iframe은 소스 보면 iframe 태그만 보임 -->
	<!-- iframe 태그가 가져온 것, 소스 차원에서 합친게 아님 -->
	<!-- 톰캣이 include를 만나면 소스 자체를 통째로 복사해와서 붙여넣음 -->
	<!-- include를 쓸 때 조심해야할것 -> 어떤 것의 일부분이 된다는걸 인지해야함 	-->
	<!-- 그래서 include로 가져올 코드는 html태그나 body 태그 이런걸 작성하지 	않음 -->
	<!-- 생산성이 높아지고, 전화번호나 이메일이 바뀔 때 copyright 스크립트만 	고치면 됨 -->
	<%@ include file="inc/copyright.jsp"%>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>