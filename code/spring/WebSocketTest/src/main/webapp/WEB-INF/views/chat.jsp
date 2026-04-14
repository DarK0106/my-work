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
        <input type="text" id="msg" placeholder="대화 내용을 입력하세요!" autofocus>
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
    
    // 이모티콘은 사용자가 임의로 만드는게 아니고
    // 서버에 이미 들어가 있는 이모티콘을 사용
    // 그래야 수익성이 있고 관리가 쉬움
    
    let ws; // 소켓 변수
    // 서버 종단점(주소)
    const url = 'ws://192.168.0.25:8080/socket/chatserver.do';
    
        function connect(name) {
        	// 매개변수로 넘어온 name을 출력
        	// = 채팅방 이름 출력하기
        	// 부모 페이지에서 입력한 채팅방 이름을
        	// 자식 페이지에서 사용한 것
        	$('#name').text(name);
        	
        	// 진짜 연결하기(+ 소켓 생성)
        	// 소켓을 만드는 순간 서버와 연결을 시도
        	ws = new WebSocket(url);
        	log('채팅 서버에 연결을 시도합니다.');
        	
        	// 소켓 이벤트 추가
        	ws.onopen = evt => {
        		// 서버와 연결이 실제로 성공하면 발생
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
        		
        		// 이건 그냥 문자열이라 객체로 바꿔야함
        		// console.log(evt.data);
        		
        		// 자바스크립트 객체를 json형태의 문자열로 바꾸는건
        		// JSON.stringify 이고
        		
        		// json 형태의 문자열을 자바스크립트 객체로 바꾸는건
        		// JSON.parse 이다
        		
        		// json 형태의 문자열을 엄연한 자바스크립트 객체로 바꿨다
        		let message = JSON.parse(evt.data);
        		
        		// 서버가 나한테 1을 보냈는데
        		// 1이면 누군가 채팅방에 새로 들어왔구나
        		if (message.code == '1') {
        			print('', `[\${message.sender}]님이 들어왔습니다.`, 'other', 'state', message.regdate);	
        		} else if (message.code == '2') {
        			// 서버가 상태코드 2를 보냄
        			// 누가 나갔는지 화면에 출력해주면 됨
        			print('', `[\${message.sender}]님이 나갔습니다.`, 'other', 'state', message.regdate);
        		} else if (message.code == '3') {
        			// 누군가가 나한테 말을 한 상황
        			// 그걸 화면에 출력해주면 됨
        			// 말한 사람 이름: message.sender
        		    // 말한 내용: message.content
        			print(message.sender, message.content, 'other', 'msg', message.regdate);
        		} else if (message.code == '4') {
        			// 누군가가 나에게 귓속말을 보낸 상황
        			// 그걸 화면에 출력
        			print(message.sender, message.content, 'other', 'secret', message.regdate);
        		} else if (message.code == '5') {
        			// 누군가가 나에게 이모티콘을 보낸 상황
        			// 그걸 화면에 출력
        			printEmoticon(message.sender, message.content, 'other', 'msg', message.regdate);
        		}
        		
        		scrollList();
        	};
        	
        	ws.onclose = evt => {
        		log('채팅 서버에 연결이 종료되었습니다.');
        	};
        	
        	ws.onerror = evt => {
        		log(evt);
        	};
        }
        
        // OOO가 들어왔습니다! <- 를 화면에 띄우기 위한 함수
        function print(name, msg, side, state, time) {
            
            let temp = `
            <div class="item \${state} \${side}">
                <div>
                    <div>\${name}</div>
                    <div>\${msg}</div>
                </div>
                <div>\${time}</div>
            </div>      
            `;
            
            $('#list').append(temp);
            
        }
        
        // 이모티콘을 화면에 출력하기 위한 함수
        function printEmoticon(name, msg, side, state, time) {
            let temp = `
                <div class="item \${state} \${side}">
                    <div>
                        <div>\${name}</div>
                        <div style='background-color: #FFF;border: 0;'><img src='/socket/resources/emoticon/\${msg.substr(1)}.png'></div>
                    </div>
                    <div>\${time}</div>
                </div>      
                `;
                
            $('#list').append(temp);
            
            setTimeout(scrollList, 100);
        }
        
        function log(msg) {
        	console.log(dayjs().format('HH:mm:ss'), msg);
        }
        
        // 창을 닫기 직전에 발생하는 이벤트
        // 창을 닫으면 소켓이 날라가니까
        // 부모 창에서 초기화를 하는 로직
        // 이걸 안하면 직접 새로고침을 해야 함
        $(window).on('beforeunload', () => {
        	
        	// 부모창 초기화
        	$(opener.document).find('.in').prop('disabled', false);
        	$(opener.document).find('#name').val('').prop('readOnly', false);
        	
        	// disconnect라는 함수로 나가는 작업을 마무리하자
        	disconnect();
        	
        });
        
        // 채팅방을 나갈 때의 로직
        function disconnect() {
        	
        	// 1. 나 나간다고 서버한테 알리기
        	// 2. 웹소켓 종료하기
        	const message = {
        			// 상태코드 2면 이 사람이 나간다
                    code: '2',
                    // 누가 나감? sender에 있는 얘가 나감
                    sender: $('#name').text(),
                    receiver: '',
                    content: '',
                    regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
            };
        	
        	// 소켓을 사용해서? json 형태의 문자열로 바꾸고
        	ws.send(JSON.stringify(message));
        	
        	// 웹소켓을 종료해서 진짜 마무리하기
        	ws.close();
        	
        }
        
        // 채팅 보내기
        $('#msg').keydown(evt => {
        	
        	// 귓속말인지 전체 채팅인지 구분하는
        	// 로직이 있어야 함
        	// 정규표현식을 이용하자?
        	// /고양이 안녕하세요. <- 고양이한테만 안녕하세요 라고 감
        	// \s 는 공백
        	// \S 는 공백이 아닌 나머지 모든 글자가 한 글자 이상인 것
        	// /로 시작하면서 공백을 만나기 전 까지 로 찾아야 함
        	
        	// 이모티콘 보내기 기능
        	// #심쿵 이렇게 하면 이모티콘 보냄
        	// 채팅까지 보내려면 #심쿵 안녕하세요
        	// 귓속말로 이모티콘을 채팅이랑 같이 보내려면
        	// /고양이 #심쿵 안녕하세요
        	
        	// 귓속말 정규표현식
        	const regex = /^\/\S{1,}/;
        	
        	// 이모티콘 정규표현식
        	// 이모티콘 파일명은 다 한글로 통일해뒀음
        	const regex2 = /^#[가-힣]{1,}/;
        	
        	// 귓속말 + 이모티콘 정규표현식
        	
        	// 귓속말 + 이모티콘 + 채팅 정규표현식
        	
        	// 위에 두개는 그냥 안하는걸로 ..
        	
        	// 엔터 치면 채팅 전송
        	if (evt.keyCode == 13) {
        		
        		// 귓속말일 때 ~
        		// 정규표현식으로 테스트해서 이 조건을 만족하면
        		// 아 이건 귓속말이구나
        		if (regex.test($(evt.target).val().trim())) {
        			
        			// 귓속말 전송하기
        			const message = {
                            code: '4',
                            sender: $('#name').text(),
                            // 귓속말이라 받는 사람이 있어야 함
                            // 공백을 자르면 배열로 돌려받는데
                            // substr로 두번째 만 찾는 다 .. ?
                            receiver: $(evt.target).val().split(' ')[0].substr(1),
                            content: $(evt.target).val().substr($(evt.target).val().indexOf(' ') + 1),
                            regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
                    };
                    
                    ws.send(JSON.stringify(message));
                    
                    // 채팅 보내고 끝났으면
                    // 내 화면에도 내 채팅이 떠야 함
                    print(message.sender, message.content, 'me', 'secret', message.regdate);
        			
        		} else if (regex2.test($(evt.target).val().trim())) {
        			
        			// 이모티콘만 전송하기
        			const message = {
                            code: '5',
                            sender: $('#name').text(),
                            receiver: '',
                            content: $(evt.target).val(),
                            regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
                    };
                    
                    ws.send(JSON.stringify(message));
                    
                    // 이제는 print를 못씀
                    // content에 문자열이 있다는 가정 하에 print를 쓴거라
                    // 이젠 이모티콘이니 이미지 태그가 들어가야 함
                    // printEmoticon 이라는 또 다른 함수를 사용
                    printEmoticon(message.sender, message.content, 'me', 'msg', message.regdate);
        			
        		} else {
        			// 전체 채팅 메시지 전송하기
                    const message = {
                            code: '3',
                            sender: $('#name').text(),
                            receiver: '',
                            content: $(evt.target).val(),
                            regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
                    };
                    
                    ws.send(JSON.stringify(message));
                    
                    // 채팅 보내고 끝났으면
                    // 내 화면에도 내 채팅이 떠야 함
                    print(message.sender, message.content, 'me', 'msg', message.regdate);
        		}
        		
        		$(evt.target).val('').focus();
        		
        		// 채팅이 길어지면 아래로 알아서 내려가야 하니까
        		// scrollList라는 함수를 사용하자
        		scrollList();
        	}
        	
        });
        
        function scrollList() {
        	// 채팅 내용이 길면 많이 움직이고
        	// 채팅 내용이 짧으면 적게 움직여야 함
        	$('#list').scrollTop($('#list')[0].scrollHeight + 300);
        }
        
    </script>
</body>
</html>