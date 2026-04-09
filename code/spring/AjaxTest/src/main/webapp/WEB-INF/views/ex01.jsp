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
	<!-- ex01.jsp -->
    <!-- 버튼을 누르면 tblAddress의 총 인원수를 가져와서 출력하는 페이지 -->
    <h1>Ajax <small>에이잭스다 으하하</small></h1>
    
    <div>
        <input type="button" value="클릭" id="btn1">
    </div>
    
    <div id="result" class="message">${count }</div>
    
    <div>
        <!-- 내가 여기다가 뭘 적고있었는데 -->
        <!-- 버튼을 누르면 ex01에서 ex01ok 갔다가 ex01로 다시 보여줘서 -->
        <!-- 내가 작성하던 텍스트가 다 날아가는 새로고침이 발생해버림 -->
        <!-- 내가 뭘 작성하다가 서버와 통신하는 순간 새로운 페이지로 보여짐 -->
        <input type="text">
    </div>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    /*  
        브라우저 입장에서는 아래의 3가지 행동이 전부 동일함
        - A페이지 -> F5 -> A페이지: 새로고침
        - A페이지에서 링크를 클릭해 B페이지로 이동: 이동하기
        - A페이지에서 폼을 보내서 B페이지로 이동: 전송하기
    
    */
        $('#btn1').click(() => {
        	location.href = '/ajax/ex01ok.do';
        });
    </script>
</body>
</html>