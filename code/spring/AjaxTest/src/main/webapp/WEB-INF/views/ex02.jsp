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
	<!-- ex02.jsp -->
    <!-- 버튼을 누르면 tblAddress의 총 인원수를 가져와서 출력하는 페이지 -->
    <h1>Ajax <small>어휴 시벌</small></h1>
    
    <div>
        <input type="button" value="클릭" id="btn1">
    </div>
    
    <div id="result" class="message"></div>
    
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
            /*  
                비동기 자바스크립트 통신
                자바스크립트를 통해 통신한다
                
                방법 1. 순수 자바스크립트, 즉 바닐라 자바스크립트인
                XMLHttpRequest를 구현
                방법 2. jQuery Ajax 라이브러리(내부 XMLHttpRequest 구현)
                방법 3. axios 라이브러리
                방법 4. 순수 자바스크립트 -> fetch API(XMLHttpRequest의 다음 세대)
            
            */
            
            // ajax 객체 생성
            // 눈에 안 보이는 통신 도구
            const ajax = new XMLHttpRequest();
                
            // $('.message').append(`<div>이벤트 발생: \${ajax.readyState}</div>`);
            
            /*  
                readyState값이 변경되는 이벤트
                
                0의 의미: const ajax = new XMLHttpRequest(); 여기서 처음에 객체를 만들고
                아무 짓도 안했을때, 즉 객체 생성 직후, Uninitialized 상태
                
                1의 의미: 객체를 만들고 open 메서드(ajax.open)가 호출될 때, Loading 상태
                
                2의 의미: send 메서드(ajax.send)가 호출될 때, Loaded 상태
                이 주소값(/ajax/ex02ok.do)으로 알바생을 호출하러 감 
                알바생이 일을하고 데이터를 호출하는데
                그럴 동안에 시간이 좀 걸림.
                서버가 응답을 시작해서 편지 봉투(헤더, 상태 코드 등)는 도착했지만, 
                아직 안에 든 편지 내용물(본문 데이터)은 오지 않은 상태
                
                3의 의미: 데이터의 일부가 수신되는 상태, Interactive
                
                4의 의미: 데이터를 전부 받은 상태, Completed
            
            */
            
            // readystate라는 값이 변할 때 마다 발생하는 이벤트
            ajax.onreadystatechange = function() {
            	
                // HTTP Status Code
                // - 클라이언트와 서버 간의 HTTP를 사용한 통신에서 사용하는 상태 코드
                // 200이라고 출력되면 브라우저가 내가 정상적인 데이터를 받았다고 생각함
                // console.log(ajax.status); // 200 이면 정상
                console.log(ajax.status); // 500 이면 에러 페이지를 돌려줌
                
                // 200, 500 같이 상황에 따라 번호를 정해놓은 것
                // 201 Created: 글쓰기 같이 데이터가 새로 생성되었을 때
                	
            	// 데이터를 받아서 눈으로 확인할 수 있음
            	// append로 누적시키기
            	// $('.message').append(`<div>이벤트 발생: \${ajax.readyState}</div>`);
            	
            	// 0, 1, 2, 3 일때는 뭘 못함
            	// 그래서 readyState 4일때만 동작함
            	// 그리고 서버쪽이 올바르게 응답했을 때인 200일 때만 동작하게 해야함
            	if (ajax.readyState == 4 && ajax.status == 200) {
            		// '.message'는 /ajax/ex02ok.do가 돌려준 것
            		// 난 서버한테 tblAddress에 있는 인원수를 돌려받고 싶었는데
            		// 그냥 HTML 페이지 통째로 돌려받음
            		// ajax는 자바스크립트 객체기 때문에 HTML이 뭔지 모름
            		// ajax는 그냥 문자열로 인식함
            		
            		// ex01이랑 뭐가 다른거임? -> 새로고침이 일어나지 않음
            		// ex02 페이지는 바뀌지 않고 브라우저는 가만히 있고
            		// 별도의 통신 도구가 있어서 ajax가 서버랑 통신해서
            		// 서버가 요청에 응답해서 숫자만 돌려준다
            		$('.message').append(`<div>데이터 수신 완료!</div>`);
            		$('.message').append(`<div>레코드의 총 개수: \${ajax.responseText}</div>`);
            		// console.log(ajax.responseText); // ajax가 이건 그냥 문자열로밖에 인식을 못함
            	} else if (ajax.readyState == 4 && ajax.status != 200) {
            		$('.message').append(`<div>오류 발생 !!</div>`);
            	}
            	
            };
            
            // 서버하고는 그 어떤 접점도 안 생기고(연결은 안한다는거)
            // 설정만 한다는 것
            // <form method="GET" action="/ajax/ex02ok.do"> 랑 똑같음
            // 이걸 HTTP Method라고 부름
            // 이 다음에 submit을 해야 연결
            ajax.open('GET', '/ajax/ex02ok.do');
            
            // 이게 btn1.submit() 역할
            // send가 데이터를 달라고 요청함
            // 데이터를 주면 ajax객체가 데이터를 받음
            ajax.send();
            
        });
    </script>
</body>
</html>