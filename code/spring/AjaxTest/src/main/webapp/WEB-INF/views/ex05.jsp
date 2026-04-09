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
	<!-- ex05.jsp -->
    <!-- PK하나 넘기면 DB에서 셀렉트 날려서 그사람의 이름을 가져오는 페이지 -->
    <h1>Ajax <small>jQuery Ajax 연습</small></h1>
    
    <div>
        <input type="text" id="seq" name="seq" value="1">
        <input type="button" value="클릭" id="btn1">
    </div>
    
    <div id="result" class="message"></div>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        
        /* $('#btn1').click(() => {
        	
           $.ajax({
        	   // 객체로 모든 것들을 전달받음
        	   type: 'GET',                        // ajax.open() 설정
        	   url: '/ajax/ex05ok.do',              // ajax.open() 설정
        	   // 전송할 데이터
        	   data: 'seq=' + $('#seq').val(),
        	   success: function(result) {         // 콜백 -> result(ajax.responseText)
        		   $('#result').text(result);
        	   },
        	   // try-catch의 catch와 비슷
        	   error: function(a,b,c) {
        		   console.log(a,b,c);
        	   }
           }); // ajax.send() 호출
           
           // GET방식으로 서버에게 원하는 데이터를 넘기고 결과값을 돌려받은 것
            
        }); */
        
        // POST 방식
        $('#btn1').click(() => {
            
            $.ajax({
                // 객체로 모든 것들을 전달받음
                type: 'POST',                        // ajax.open('POST') 설정
                url: '/ajax/ex05ok.do',              // ajax.open() 설정
                // 전송할 데이터
                data: 'seq=' + $('#seq').val(),
                success: function(result) {         // 콜백 -> result(ajax.responseText)
                    $('#result').text(result);
                },
                // try-catch의 catch와 비슷
                error: function(a,b,c) {
                    console.log(a,b,c);
                }
            }); // ajax.send() 호출
            
         });
    </script>
</body>
</html>