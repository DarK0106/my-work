package com.test.java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// AI 에게 답변을 받기 위한 용도로 사용해보자
// m5
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
	private String answer;
	private int count;
	private String color;
	private String[] names;
}
