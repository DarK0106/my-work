package com.test.java.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tblUserInfo")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
	
	@Id
	@Column(name = "id", length = 50)
	private String id;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "address", nullable = false, length = 500)
	private String address;
	
	@Column(name = "gender", length = 1)
	private String gender;
	
	// 부모 테이블 역할을 하는 user
	// 어떤 관계인지 작성해야함, 관계 차수를 작성해야함
	// 관계 차수(1:1 1:N N:N ...)
	// 1:1 -> @OneToOne
	// 자식 -> (참조) -> 부모 를 한 상황임
	@OneToOne
	// 그 때 사용할 Foreign Key 도 알려줘야 함
	@JoinColumn(name = "id")
	private User user;
	
}







