<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- ex04.jsp -->
    <!-- PK하나 넘기면 DB에서 셀렉트 날려서 그사람의 이름을 가져오는 페이지 -->
    <h1>Ajax <small>크하하</small></h1>
    
    <div>
        <input type="text" id="seq" name="seq" value="1">
        <input type="button" value="클릭" id="btn1">
    </div>
    
    <div id="result" class="message"></div>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        
    
        $('#btn1').click(() => {
        	
            const ajax = new XMLHttpRequest();
            
            ajax.onreadystatechange = function() {
            	
                console.log(ajax.status);
                
            	if (ajax.readyState == 4 && ajax.status == 200) {
            		$('#result').text(ajax.responseText);
            	}
            	
            };
            
            // 1. GET 방식으로 데이터 전송
            // GET 방식은 쿼리스트링으로 전송
            // ajax.open('GET', '/ajax/ex04ok.do?seq=' + $('#seq').val());
            
            // ajax.send();
            
            // 2. POST 방식으로 데이터 전송
            ajax.open('POST', '/ajax/ex04ok.do');
            // POST 요청 + 헤더 설정
            ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            ajax.send('seq=' + $('#seq').val());
            
        });
    </script>
</body>
</html>