package com.test.socket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
	
	메시지(Message) 형식 > 프로토콜 설계
    - code: 상태코드
        - 1: 새로운 유저가 들어옴
        - 2: 기존 유저가 나감
        - 3: (전역)메시지 전달
        - 4: (귓속말)메시지 전달
        - 5: (전역)이모티콘 전달
    - sender: 메시지를 보내는 유저명
    - receiver: 메시지를 받는 유저명(1:1 채팅, 귓속말)
    - content: 메시지(대화 내용)
    - regdate: 날짜/시간
	
*/
@Getter
@Setter
@ToString
public class Message {
	private String code;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;	
}
