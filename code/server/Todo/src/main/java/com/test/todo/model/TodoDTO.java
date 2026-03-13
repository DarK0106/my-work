package com.test.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Data Transfer Object == 택배 상자 역할
// Getter Setter 작성 시 lombok 활용: 유지보수 용이, 가독성 개선
@Setter
@Getter
// @ToString
// @NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode
@Data
public class TodoDTO {
	// 테이블의 컬럼
	// 이 데이터 4개를 갖고있다면
	// DB의 레코드와 같은 형식이다
	// 그 레코드 여러개를 모은걸 List로 만들면
	// List는 테이블과 같은 형식이 된다
	private String seq;
	private String todo;
	private String state;
	private String regdate;
	
}
