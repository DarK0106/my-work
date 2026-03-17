package com.test.semi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDto {
	// Dto의 주 목적은 테이블을 나르는 상자
	// 테이블만 나르진 않음
	private String seq;
	private String subject;
	private String content;
	private String id;
	private String regdate;
	private String readcount;
	
	private String name; // 작성자
	
	private Double isnew; // 최신글
}
