package com.test.java.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// DB의 tblUser 테이블과 1:1 매핑되는 JPA 엔티티
@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblUser")
public class User {
	
	@Id
	@Column(name = "seq")
	@SequenceGenerator(name = "seqUser", allocationSize = 1, sequenceName = "seqUser")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
	private Long seq;
	
	
	private String username;
	private String name;
	private String email;
	private String role;
	private String provider;
	@Column(name = "providerid")
	private String providerId;
}
