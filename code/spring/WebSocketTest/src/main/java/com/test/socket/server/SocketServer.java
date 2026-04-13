package com.test.socket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

// 소켓을 구현할 서버 역할
// 이 클래스가 server.do라는 주소를 가져야 함
@ServerEndpoint("/server.do")
public class SocketServer {
	
	// 클라이언트가 연결 요청을 했을 때 발생하는 일종의 이벤트
	// 즉 우리가 호출하는게 아니고 특정 상황을 만족하는 순간 호출됨
	// 누군가가 소켓을 만들어서 서버를 부르는 요청을 하는 순간 호출
	@OnOpen
	public void handleOpen() {
		System.out.println("클라이언트가 접속했습니다.");
	}
	
	// 서버와 클라이언트간에 연결이 됐으니 이제 대화를 할 수 있는데
	// 클라이언트가 서버한테 메세지를 보내면 서버쪽에서 그 메세지를
	// 수신하는 순간 발생하는 이벤트
	// 클라이언트가 넘긴 데이터(지금은 문자열)은 String msg 여기로 받아짐
	@OnMessage
	public String handleMessage(String msg) {
		System.out.println("쿨라이언트가 보낸 메시지: " + msg);
		
		// 서버가 클라이언트에게 메세지를 보내보자
		return msg; // 이 때 리턴한 문자열이 클라이언트 쪽으로 감
	}
	
	// 클라이언트가 전화를 끊을 때(전화 끊는 것 자체는 클라이언트, 서버 양쪽에서 끊을 수 있음)
	// 클라이언트와 서버의 연결이 종료될 때 호출되는 메서드
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트와 연결이 종료되었습니다.");
	}
	
	// 에러가 발생했을 때 호출되는 메서드
	// 에러가 발생했을 때의 try-catch에서 catch에 해당하는 메서드
	@OnError
	public void handleError(Throwable e) {
		System.out.println("에러가 발생했습니다." + e.getMessage());
	}
	
}
