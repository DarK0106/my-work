<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
    <style>
        html, body {
            padding: 0 !important;
            margin: 0 !important;
            background-color: #FFF !important; 
            display: block;
            overflow: hidden;
        }
        
        body > div {
            margin: 0; 
            padding: 0; 
        }
    
        #main {
            width: 400px;
            height: 510px;
            margin: 3px;
            display: grid;
            grid-template-rows: repeat(12, 1fr);
        }
        
        #header {
        
        }
        
        #header > h2 {      
            margin: 0px;
            margin-bottom: 10px;
            padding: 5px;
        }
    
        #list {
            border: 1px solid var(--border-color);
            box-sizing: content-box;
            padding: .5rem;
            grid-row-start: 2;
            grid-row-end: 12;
            font-size: 14px;
            overflow: auto;
        }
        
        #msg {
            margin-top: 3px;
        }
        
        #list .item {
            font-size: 14px;
            margin: 15px 0;
        }
        
        #list .item > div:first-child {
            display: flex;
        }
        
        #list .item.me > div:first-child {
            justify-content: flex-end;
        }
        
        #list .item.other > div:first-child {
            justify-content: flex-end;
            flex-direction: row-reverse;
        }
        
        #list .item > div:first-child > div:first-child {
            font-size: 10px;
            color: #777;
            margin: 3px 5px;
        }
        
        #list .item > div:first-child > div:nth-child(2) {
            border: 1px solid var(--border-color);
            display: inline-block;
            min-width: 100px;
            max-width: 250px;
            text-align: left;
            padding: 3px 7px;
        }
        
        #list .state.item > div:first-child > div:nth-child(2) {
            background-color: #EEE;
        }
        
        #list .item > div:last-child {
            font-size: 10px;
            color: #777;
            margin-top: 5px;
        }
        
        #list .me {
            text-align: right;
        }
        
        #list .other {
            text-align: left;
        }
        
        #list .msg.me.item > div:first-child > div:nth-child(2) {
            background-color: rgba(255, 99, 71, .2);
        }
        
        #list .msg.other.item > div:first-child > div:nth-child(2) {
            background-color: rgba(100, 149, 237, .2);
        }
        
        #list .secret.me.item > div:first-child > div:nth-child(2) {
            background-color: gold;
        }
        
        #list .secret.other.item > div:first-child > div:nth-child(2) {
            background-color: gold;
        }
        
        #list .msg img {
            width: 150px;
        }
    </style>
</head>
<body>
	<!-- chat.jsp -->
    <div id="main">
        <div id="header"><h2>WebSocket<small id="name"></small></h2></div>
        <div id="list"></div>
        <input type="text" id="msg" placeholder="대화 내용을 입력하세요!">
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/dayjs@1/dayjs.min.js"></script>
    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
    // 클라이언트 <- (전송) -> 서버
    
    // 메시지(Message) 형식 -> 프로토콜 설계
    // 지금 너한테 보낸 메시지가 이런 의미다 라고
    // code(상태코드)를 사용해서 서버에게 알려주도록 정하자
    // 이걸 내가 직접 만들어야 함
    // 상태코드 1: 새로운 유저가 들어옴
    // 상태코드 2: 기존 유저가 나감
    // 상태코드 3: (전역) 메시지 전달
    // 상태코드 4: (귓속말) 메시지 전달
    // 상태코드 5: (전역) 이모티콘 전달
    // sender: 메시지를 보내는 유저명
    // receiver: 메시지를 받는 유저명(1:1 채팅, 즉 귓속말일때만 사용)
    // content: 메시지(대화 내용)
    // regdate: 날짜/시간
    
    let ws; // 소켓 변수
    // 서버 종단점(주소)
    const url = 'ws://localhost:8080/socket/chatserver.do';
    
        function connect(name) {
        	// 매개변수로 넘어온 name을 출력
        	// = 채팅방 이름 출력하기
        	// 부모 페이지에서 입력한 채팅방 이름을
        	// 자식 페이지에서 사용한 것
        	$('#name').text(name);
        	
        	// 진짜 연결하기(+ 소켓 생성)
        	ws = new WebSocket(url);
        	log('채팅 서버에 연결을 시도합니다.');
        	
        	// 소켓 이벤트 추가
        	ws.onopen = evt => {
        		// 서버와 연결이 성공하면 발생
        		log('채팅 서버에 연결되었습니다.');
        		
        		// 그룹 채팅이기 때문에
        		// 내가 누군지 서버에게 알려야 함
        		// 즉 접속한 채팅방 이름을 서버에게 전달해야 함
        		// ws.send("강아지"); 이렇게 넘겨버리면
        		// 서버는 이게 채팅방 이름인지 채팅 내용인지
        		// 알아듣질 못함
        		const message = {
        				// 상태코드 1: 새로운 유저가 들어옴
        				// 저 처음 들어왔어요
        				code: '1',
        				// 보낸 사람의 이름
        				// 저 OOO 인데요
        				sender: $('#name').text(),
        				receiver: '',
        				content: '',
        				regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
        		};
        		
        		// 네트워크에 주고 받은 데이터는 일렬로 늘어진 문자열만 받을 수 있음
        		// 근데 위 message는 복합적이고 한줄도 아님
        		// 그래서 직렬화를 해야함
        		// 그래서 JSON 형태의 1줄의 문자열로 만들어야 함
        		// 자바스크립트 객체를 JSON 포맷의 문자열로 만든다
        		// alert(JSON.stringify(message));
        		// JSON으로 바꿔서 서버한테 보냄
        		// 그럼 서버에선 OnMessage가 발생함
        		ws.send(JSON.stringify(message));
        		
        		
        	};
        	
        	ws.onmessage = evt => {
        		log('채팅 서버로부터 메시지가 도착했습니다.');
        	};
        	
        	ws.onclose = evt => {
        		log('채팅 서버에 연결이 종료되었습니다.');
        	};
        	
        	ws.onerror = evt => {
        		log(evt);
        	};
        }
        
        function log(msg) {
        	console.log(dayjs().format('HH:mm:ss'), msg);
        }
    </script>
</body>
</html>