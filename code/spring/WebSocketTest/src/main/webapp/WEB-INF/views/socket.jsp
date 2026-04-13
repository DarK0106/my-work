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
	<!-- socket.jsp -->
    <h1>WebSocket <small>웹소켓의 기본적인 사용법</small></h1>
    
    <div>
        <button type="button" id="btn-connect">연결하기</button>
        <button type="button" id="btn-disconnect" disabled>연결 끊기</button>
    </div>
    
    <hr>
    
    <div>
        <!-- 클라이언트가 데이터를 보내면 데이터가 소켓을 타고 -->
        <!-- 서버가 잘 수신했는지 확인하고 -->
        <!-- 보낸 데이터를 출력해보자 -->
        <input type="text" class="long" id="msg" disabled>
        <button type="button" id="btn-echo" disabled>에코 테스트</button>
    </div>
    
    <hr>
    
    <!-- 무슨 일이 일어나는지 log를 출력할 공간 -->
    <div class="message full"></div>
    
    <script src="https://cdn.jsdelivr.net/npm/dayjs@1/dayjs.min.js"></script>
    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
    // 소켓 변수를 전역으로 뺀다
    let ws = null;
    
    // 서버측의 종단점(주소)
    const url = "ws://localhost:8080/socket/server.do";
    
    //
    $('#btn-connect').click(() => {
    	
    	// 1. 소켓이라는 전화기를 만들어야함
    	// 연결하기 버튼을 누르는 순간
    	// 소켓이 만들어지면서 서버에 연결 요청이 들어감
    	// 웹소켓이 우리 모르게 처리하는 일이 많아서
    	// 소켓을 만드는 순간 서버와 연결이 된다고 생각하면 편함
    	ws = new WebSocket(url); // 전화 걸기
        log('소켓 상태: ' + ws.readyState);
    	
    	// 소켓 이벤트
    	// - ws.readyState
    	// - 0: 연결 전
    	// - 1: 연결 완료
    	// - 2: 연결 종료 중
    	// - 3: 연결 종료 완료
    	
    	// 왜 소켓 만들기만 한건데 서버랑 연결됐다고 하는걸까?
    	// 소켓에도 이벤트가 있다.
    	// SocketController의 자바스크립트 버전?
    	// 서버측에서 소켓 연결 요청을 수락하고 
    	// 서로 연결된 직후 발생하는 소켓 이벤트
    	ws.onopen = evt => {
    		log('서버와 연결되었습니다.');
    		log('소켓 상태: ' + ws.readyState);
    		
    		// 연결이 되었으니 비활성화 해둔 텍스트창, 버튼을 다시 활성화
    		$('#btn-disconnect').prop('disabled', false);
    		$('#msg').prop('disabled', false);
    		$('#btn-echo').prop('disabled', false);
    		
    		// 연결이 되었으니 연결이 되었을 때에는 연결하기 버튼을 비활성화
    		$('#btn-connect').prop('disabled', true);
    	};
        
    	// 서버가 클라이언트에게 메세지를 전달하는 순간
    	// 발생하는 이벤트
    	ws.onmessage = evt => {
    		
    		// evt라는 메서드에 담겨서 온다
    	    log('서버로부터 받은 데이터: ' + evt.data);
    	};
    	
    	// 상대방과 연결이 끊기는 순간 발생하는 이벤트
    	// 이게 발생했을때 연결이 끊긴 것
    	ws.onclose = evt => {
    		log('서버와 연결이 종료되었습니다.');
            log('소켓 상태: ' + ws.readyState);
    	};
    	
    	// 소켓 통신을 하다가 오류가 발생했을 때 발생하는 이벤트
    	ws.onerror = evt => {
    		
    		// 버튼 설정을 초기 상태(연결이 없는 상태)로 되돌리기
            $('#btn-disconnect').prop('disabled', false);
            $('#msg').prop('disabled', false);
            $('#btn-echo').prop('disabled', false);
            $('#btn-connect').prop('disabled', true);
    	};
    	
    });
    
    $('#btn-disconnect').click(() => {
    	
    	// 소켓 닫기
    	ws.close(); // close 호출되고 
    	// (이 사이에 - 2: 연결 종료 중) 이게 있음
    	// onclose가 발생해야 연결이 끊긴 것(- 3: 연결 종료 완료)
    	
    	// 연결이 끊겼으니 텍스트창, 버튼을 비활성화
        $('#btn-disconnect').prop('disabled', true);
        $('#msg').prop('disabled', true);
        $('#btn-echo').prop('disabled', true);
        
        // 연결이 끊겼으니 연결하기 버튼을 다시 활성화
        $('#btn-connect').prop('disabled', false);
    	
    });
    
    $('#btn-echo').click(() => {
        
    	// 알 수 없는 이유로 연결이 끊긴 상황에서 메시지를 전송하는 경우를 방지
    	// readyState가 1이 아니면 ~~: 1이 연결된 상태임
    	if (ws == null || ws.readyState != 1) {
    		log('서버와 연결이 끊긴 상태입니다.');
    		return;
    	}
    	
        // 현재 연결된 소켓을 사용해서 상대방에게 데이터를 전달하기
        // 연결 안하고 메세지 보내면 당연히 에러남(자바스크립트 쪽에서)
        // ws.send('안녕하세요.');
        
        // 보낼 메시지 입력해서 보내기
        ws.send($('#msg').val());
        
        log('메시지를 전송했습니다.');
    	
    });
    
    function log(msg) {
    	$('.message').prepend(`
    			<div>[\${dayjs().format('HH:mm:ss')}] \${msg}</div>
    			`);
    }
    
    </script>
</body>
</html>