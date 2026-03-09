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
	<!-- ex05.jsp -->
	<h1>데이터 전송하기</h1>
	<h2>폼태그 + POST 전송하기</h2>
	<form action="ex05ok.jsp" method="POST">
		<div>문자: <input type="text" name="txt"></div>
		<div>숫자: <input type="number" name="num"></div>
		<div><button>보내기</button></div>
	</form>
	
	<h2>폼태그 + GET 전송하기</h2>
	<form method="GET" action="ex05ok.jsp">
		<div>문자: <input type="text" name="txt"></div>
		<div>숫자: <input type="number" name="num"></div>
		<div><button>보내기</button></div>
	</form>
	
	<h2>폼태그를 쓰지 않고 GET 방식으로 전송하기</h2>
	<div>
		<a href="ex05ok.jsp?txt=엄준식&num=123">🔗 ex05ok.jsp로 이동하기</a>
	</div>
	<br>
	<div>
		<input type="button" value="페이지 이동하기" id="btn1">
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		$('#btn1').click(() => {
			location.href = 'ex05ok.jsp?txt=test&num=' + 100;
		});
		
		window.onkeydown = event => {
			location.href = 'ex05ok.jsp?txt=' + event.key;
		}
		
	</script>
</body>
</html>