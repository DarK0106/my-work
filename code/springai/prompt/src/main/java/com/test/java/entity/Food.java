package com.test.java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// m8
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Food {
	
	// 질문: 직장인들이 좋아하는 간식명과 칼로리를 알려줘
	
	// 현재 상태: name, calorie 멤버 변수의 이름이 어떤 성격의 데이터인지 추측이 가능하다.
	// LLM이 알아서 질문의 항목과 엔티티의 멤버를 서로 연결
	
	// 지금은 얻어걸려서 잘 된거고 .system()에 직접적인 정보를 입력해서 안정성을 높여야 함
	private String name;
	private Integer calorie;
}
