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
	<!-- ex07.jsp -->
    <h1>Ajax <small>데이터 전송의 모든 방법과 데이터 수신의 모든 방법 알아보기</small></h1>
    
    <h2>수신(응답 데이터)</h2>
    
    <h3>Text 로 응답받기 <small>ajax.responseText, 단일 값만 돌려받기</small></h3>
    
    <!-- 버튼 누르면 데이터 받아서 화면에 출력 -->
    <div>
        <input type="button" value="확인" id="btn1">
        <div class="message" id="result1"></div>
    </div>
    
    <h3>Text 로 응답받기 <small>ajax.responseText, 다중 값을 돌려받기</small></h3>
    
    <!-- 버튼 누르면 데이터 받아서 화면에 출력 -->
    <div>
        <input type="button" value="확인" id="btn2">
        <div class="message" id="result2"></div>
    </div>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        // 단일 값 돌려받기
        $('#btn1').click(() => {
        	$.ajax({
        		// 데이터를 가져오는거라 GET
        		type: 'GET',
        		url: '/ajax/ex07ok.do',
        		// data: 이건 전송하는 데이터
        		// dataType: 이건 수신하는 데이터의 형식
        		// dataType: 'text'가 기본값, text, xml, json이 주로 들어감
        		// 서버가 돌려주는 데이터를 ajax가 'text'라고 생각하는 것
        		dataType: 'text',
        		success: function(result) {
        			$('#result1').text(result);
        		},
        		error: function(a,b,c) {
        			console.log(a,b,c);
        		}
        	});
        });
        
        // 서버에 데이터를 요청해서 서버가 ArrayList Dto를 반환해주면
        // 그걸 json으로 매핑해주고
        // ajax는 받은 json을 가공해서 출력한다
        $('#btn2').click(() => {
        	$.ajax({
        		type: 'GET',
        		url: '/ajax/ex07_2ok.do',
        		dataType: 'json',
        		// 컨트롤러에 있는 result가 아래의 (result)로 넘어온다
        		success: function(result) {
        			// console.log(typeof result);
        			// console.log(result.length);
        			// console.log(result[0]);
        			
                    result.forEach(obj => {
                        
                        $('#result2').append(`
                            <div>\${obj.name}(\${obj.id},\${obj.pw})</div>      
                        `);
                        
                    });
        		},
        		error: function(a,b,c) {
        			console.log(a,b,c);
        		}
        	});
        });
    </script>
</body>
</html>