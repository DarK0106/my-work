package com.test.java.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
// @Setter
@ToString
@Builder // 객체를 단계별로 생성하는 디자인 패턴?
@NoArgsConstructor // 엔티티는 인자값이 없는 기본 생성자가 필수
@AllArgsConstructor // 사용 편의성 때문에 모든 인자가 있는 생성자를 만듦
// @Table(name = "member")
public class Member {
	
	@Id
	private String username;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	private Integer age;
	private String email;
	private String role;
}
