package com.test.socket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.socket.model.Message;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

// chat.jsp(강아지)에서 소켓하나를 만들었고
// ChatServer에도 리스너 소켓이 있음
// 종단점이 /chatserver.do 인데 이게 리스너 소켓의 주소임
// chat.jsp 소켓에서 리스너 소켓에 연결이 되는 순간
// ChatServer에서 새로운 소켓이 생성되어 그 소켓이
// chat.jsp(강아지)에 연결된다
// 근데 chat.jsp(강아지) 랑 ChatServer 가 대화하자고 만든게 아님
// 그래서 또다른 고양이 chat.jsp가 있는데
// 고양이도 아까처럼 똑같이 하고
// 고양이가 안녕하세요 라고 보내면
// 안녕하세요가 ChatServer 로 감
// 그럼 아까 생겻던 새로 만든 소켓으로 안녕하세요가
// 강아지 chat.jsp 한테 안녕하세요 가 감
// 소켓은 메모리 상에 상주하는 객체
// 서버는 여러 명의 여러 소켓과 동시에 연결되기 때문에
// 소켓이 많아질수록 서버가 힘들어짐
// 고양이가 채팅방 나가면 소켓도 없어지는데 그러면 진짜로 나간 것
// 서버가 소켓을 관리하는데 그 관리하는 방법이 중요함

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
	// 대화방에 대한 배열
	// 추후 구현
	// private static List<List<User>> roomList;
	
	// 현재 채팅 서버에 접속한 모든 클라이언트를 배열로 관리하자
	private static List<User> userList; // 단톡방에 있는 모든 사람들
	
	// 누구의 소켓인지 식별자가 있으면 좋겠다
	// 그래서 그걸 DTO로 만들자
	// Session session으로 구분하자
	
	// DTO로 쓰려는 내부 클래스
	// User 클래스는 ChatServer 밖에서는 쓸 수 없음
	// 한 클래스 안에서만 사용하는 지역 클래스
	// Session session으로만 구분하긴 불편하니까
	// 채팅방 제목으로도 구별하자
	// session을 wrapping 한게 user 객체이다?
	// 접속이 되는 순간엔 session만 ArrayList에 저장
	// 연결이 완료되었다고 알려지는 순간 메시지를 전송
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	class User {
		// Setter 만들기 귀찮으니까
		public Session session;
		public String name;
	}
	
	// 정적 생성자
	static {
		userList = new ArrayList<User>();
	}
	
	
	// (Session session) <- 웹소켓에서의 세션
	// (Session session) <- 이게 고양이와 서버랑 연결되어 있는 
	// 서버 쪽 소켓을
	// Wrapping하는 객체이다
	// 접속 직후에 일어나는 이벤트(요청을 수락해서 연결이 성공되는 순간 발생)
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("클라이언트가 접속했습니다.");
		
		// null 에 채팅방 이름이 들어가야 함
		User user = new User(session, null);
		userList.add(user);
		
		// 한 사람이 들어올 때 마다 userList를 출력
		System.out.println("userList: " + userList);
	}
	
	// 처음에 접속할때 생성된 Session session이 재사용된다.
	// 메시지를 보낸 Session session이 같은 사람(강아지, 고양이 ..)를 찾으면 된다
	
	// 이젠 또 누가 나갔다고 나한테(서버한테) 메시지가 도착했다
	@OnMessage
	public void handleMessage(String msg, Session session) {
		System.out.println("클라이언트로부터 메시지가 도착했습니다.");
		System.out.println(msg);
		
		// 받은 JSON 형태의 데이터(문자열)을 파싱해서 
		// 자바 데이터(Message <- 이거 DTO)로 바꿔야 한다
		// gson이 이걸 잘함
		Gson gson = new Gson();
		
		Message message = gson.fromJson(msg, Message.class);
		
		// 돌려받은 자바 DTO(JSON으로 온걸 자바로 파싱된 녀석)를 출력해보자
		// System.out.println(message);
		
		// 단톡방에 새로운 유저 진입
		if (message.getCode().equals("1")) {
			
			// 메시지를 보낸 사람이자 단톡방에 방금 막 들어온 사람
			User user = null;
			
			for (User u : userList) {
				if (u.session == session) {
					// 단톡방에 있는 사람들 중 메시지를 보낸 사람
					user = u;
					break;
				}
			}
			
			user.name = message.getSender();
			// user 객체 안에는 session과 name이 들어가게 되었다.
			
			// 새로운 OOO가 접속했습니다. 라는 알림을 띄워주는 로직
			// 연락을 확 뿌리는 행위를 broadcast라고 한다?
			// 상태코드가 1이라고 보낸 그 사람(제가 지금 단톡방에 들어왔어요 라고 하는 사람) 빼고
			for (User u : userList) {
				
				// 방금 들어온 사람을 제외한 전체 사람들 한테 ~
				if (u.session != session) {
					// getBasicRemote는 이미 서버에 붙어있던 소켓들을 말함
					// 정확히는 그 소켓(전화기)를 꺼내는 메서드를 말한다
					// String msg를 재사용 하면 된다?
					try {
						// 나 방금 들어왔다고 메시지를 보낸다
						u.session.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else if (message.getCode().equals("2")) {
			
			// 누가 나갔다고 서버한테 메시지가 왔다
			
			// 유저 객체를 없애야함
			// 그러려면 이 사람 유저 객체를 찾아야함
			System.out.println("클라이언트가 나갔습니다.");
			
			// 향상된 for문은 userList 이 배열에 뭔가를 추가하거나 삭제하면
			// 에러가 남, 미리 찜해놨던 순서가 꼬여버리기 때문
			// 접속한 목록에서 유저를 제거하기
			for (User u : userList) {
				// 루프 돌면서 나간 사람의 유저 객체를 찾자?
				// 근데 u.session == session 이거 뭔말인지 모르겠음
				if (u.session == session) {
					
					// 그 유저 객체를 내보내자
					userList.remove(u);
					break; // 향상된 for 문 에러 방지
				}
			}
			
			// 나머지 유저들에게 누군가가 나갔다고 메시지 전달
			// 유저들을 다 가져온다
			for (User u : userList) {
				// 상태코드1 때와 동일하게 String msg 이걸 재사용
				try {
					u.session.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} else if (message.getCode().equals("3") || message.getCode().equals("5")) {
			
			// 클라이언트로부터 채팅이 왔다 !!
			// 날아온 채팅을 나머지 사람들 소켓을 이용해서
			// 나머지 사람들에게 채팅을 쏴줘야함
			// 추가: 이모티콘 전송도 일반 채팅 전송과 다를 게 없어서
			// or로 5번도 같이 관리
			for (User u : userList) {
				if (u.session != session) {
					try {
						u.session.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if (message.getCode().equals("4")) {
			
			// 클라이언트로부터 귓속말이 왔다
			// 유저 목록을 뒤지자
			// 이 사람의 이름이 방금 보낸
			// 채팅의 reciever 즉 받는 사람의 이름과
			// 똑같은 user를 찾아야 함
			// 이 사람이 귓속말을 받을 당사자이기 때문
			for (User u : userList) {
				if(u.name.equals(message.getReceiver())) {
					try {
						// 귓속말을 받을 당사자에게 귓속말을 쏴줌
						u.session.getBasicRemote().sendText(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트가 접속을 종료했습니다.");
	}
	@OnError
	public void handleError(Throwable e) {
		e.printStackTrace();
	}
	
}
