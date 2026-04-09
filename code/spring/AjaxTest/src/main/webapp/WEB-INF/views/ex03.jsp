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
	<!-- ex03.jsp -->
    <!-- 버튼을 누르면 tblAddress의 총 인원수를 가져와서 출력하는 페이지 -->
    <h1>Ajax <small>으하하</small></h1>
    
    <div>
        <input type="button" value="클릭" id="btn1">
    </div>
    
    <div id="result" class="message"></div>
    
    <div>
        <input type="text">
    </div>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        /*  
        
            동기(Synchronous) vs 비동기(Asynchronous)
        
            동기 방식으로 카페에 가서 음료를 주문
            - 내가 매장에 가서 음료를 주문함
            - 이 카페는 주문한 그 자리에서 주문한 음료를 받는다고 가정
            - 음료를 제조를 하는데 손님(나)은 그 자리에서 계속 기다림
            - 손님은 다른 짓을 못하고 가만히 기다려야 함
            - 완성된 음료를 전달받음(요청에 따른 응답을 받음)
            - 손님(나)이 음료를 들고 자기가 하고 싶은 일을 하러 가면 됨
            - 앞에 일들이 완벽하게 끝나야지만 다음 일을 할 수 있는 방식인 동기 방식
            - 어느 특정 단계가 시간이 너무 오래 걸려도 기다릴 수 밖에 없는 방식인 동기 방식
            
            비동기 방식으로 카페에 가서 음료를 주문
            - 커피 주문하는건 똑같음
            - 직원이 커피 만들러 가기 전에 손님한테 진동벨을 줌
            - 직원이 나중에 벨이 울리면 음료 가지러 오라고 함
            - 직원은 음료 만들러 감
            - 손님은 주문한 자리에서 기다릴 필요가 없음
            - 손님은 자기 하고 싶은 일 하면 됨
            - 직원이 완성된 음료를 제공하려 할 때 진동벨에 알림을 줌
            - 손님은 진동벨이 울린 걸 보고 음료를 받으러 감
            - 어느 특정 단계가 시간이 너무 오래 걸려도 손님은 다른 일을 할 수 있음
            - 언젠가 가까운 미래에 진동벨이라는 신호를 받으면 음료를 받을 수 있음
        
        */
    
        $('#btn1').click(() => {
        	
        	// XMLHttpRequest은 기본이 비동기 통신
            const ajax = new XMLHttpRequest();
            
        	// 이벤트가 전형적인 비동기
        	// 이 사건이 언제 발생할지 모르니까 예약만 걸어놓은 것
        	// 이게 진동벨 역할인 callback 함수
            ajax.onreadystatechange = function() {
            	
                console.log(ajax.status);
                
            	if (ajax.readyState == 4 && ajax.status == 200) {
            		
            		$('.message').append(`<div>데이터 수신 완료!</div>`);
            		$('.message').append(`<div>레코드의 총 개수: \${ajax.responseText}</div>`);
            	} else if (ajax.readyState == 4 && ajax.status != 200) {
            		$('.message').append(`<div>오류 발생 !!</div>`);
            	}
            	
            };
            
            // .open에 인자를 하나 더 줄 수 있는데
            // 기본값이 비동기(true), 동기는 false
            // 동기(false)로 바꾸니까 버튼 클릭하고 텍스트에 입력이 안 됨
            ajax.open('GET', '/ajax/ex03ok.do', true);
            
            ajax.send();
            
        });
    </script>
</body>
</html>