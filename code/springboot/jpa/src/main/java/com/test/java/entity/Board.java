package com.test.java.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblBoard")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	@Id
	@Column(name = "seq")
	@SequenceGenerator(name = "seqBoard", allocationSize = 1, sequenceName = "seqBoard")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBoard")
	private Long seq;
	
	@Column(name = "subject", nullable = false, length = 1000)
	private String subject;
	
	@Column(name = "content", nullable = false, length = 1000)
	private String content;
	
	@Column(name = "regdate", nullable = false)
	private String regdate;
	
	// 관계차수
	// 보드가 N 이고 유저가 1명
	// 유저 1명이 여러 Board를 가질 수 있으니까
	// User : Board = 1 : N
	// Board : User = N : 1
	// 그래서 @ManyToOne
	// 이름은 ManyToOne 이지만
	// 게시물 1개에 관련된 유저는 1명
	// 그래서 사실 1:1 관계이다
	// 게시물 입장에서는 유저가 1명이니까
	// 기본적으로 fetch 가 EAGER 로 되어있음(ManyToOne이 원래 그럼) 
	@ManyToOne
	// 그 때 사용할 Foreign Key 도 알려줘야 함
	@JoinColumn(name = "id")
	private User user;
	
	// Board : Tagging = 1 : N
	@OneToMany(mappedBy = "board")
	private List<Tagging> tagging;
}
