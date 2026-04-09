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
	<!-- ex06.jsp -->
    <h1>회원 가입</h1>
    
    <table class="vertical">
        <tr>
            <th>이름</th>
            <td><input type="text"></td>
        </tr>
        <tr>
            <th>아이디</th>
            <td>
                <div class="group">
                    <input type="text" id="id" class="short">
                    <input type="button" value="중복 검사" id="btnCheck">
                    <span id="result"></span>
                </div>
            </td>
        </tr>
        <tr>
            <th>암호</th>
            <td><input type="text"></td>
        </tr>
    </table>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        
        $('#btnCheck').click(() => {
        	
        	$.ajax({
        		type: 'GET',
        		url: '/ajax/ex06ok.do',
        		data: 'id=' + $('#id').val().trim(),
        		success: function(result) {
        			// console.log(result);
        			
        			// 중복된 아이디를 입력했을 때('1')
        			if (result == '1') {
        				$('#result').css('color', 'tomato').text('사용할 수 없는 아이디입니다.');
        			} else {
        				$('#result').css('color', 'cornflowerblue').text('사용 가능한 아이디입니다.');
        			}
        		},
        		error: function(a,b,c) {
        			console.log(a,b,c);
        		}
        	});
        	
        });
    
    </script>
</body>
</html>