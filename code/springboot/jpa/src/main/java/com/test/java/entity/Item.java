package com.test.java.entity;

import com.test.java.model.ItemDto;

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

/*
	
	ERD -> 테이블 -> 엔티티
	
	엔티티(Entity) 클래스
	- 역할: tblItem 테이블을 자바와 중계해주는 역할
	- 자바에서 Item 클래스를 조작하면 개발자 개입 없이
	tblItem 테이블에 반영함
	
	엔티티 클래스를 테이블과 그 안에 들어있는 내용물이라고
	생각해도 좋음
	
	DTO랑 뭐가 다른거임? -> DTO는 아무 기능이 없는 데이터를 담는 상자
	엔티티(Entity) -> 테이블을 조작하는 기능이 있는 상자
	
*/

@Entity
@Getter
// @Setter
@ToString
@Builder // 객체를 단계별로 생성하는 디자인 패턴?
@NoArgsConstructor // 엔티티는 인자값이 없는 기본 생성자가 필수
@AllArgsConstructor // 사용 편의성 때문에 모든 인자가 있는 생성자를 만듦
// 컬럼명이랑 멤버이름 명시한것과 같이 @Table로 테이블명이랑 클래스명도 명시
@Table(name = "tblItem")
public class Item {
	
	// 이 seq가 Primary Key 라고
	// @Id 붙여서 명시를 함
	
	// 데이터베이스에 seq라는 컬럼이
	// 이 seq랑 연관이 있는 애라고
	// @Column 붙여서 표시를 함
	// 지금처럼 seq 로 이름이 똑같으면
	// 생략해도 됨
	
	// 시퀀스 객체 쓰는것도
	// @GeneratedValue 붙여서 명시 가능
	// @GeneratedValue 는 무슨 정책을 쓸건지
	// 명시하는 어노테이션
	// sequence는 오라클에만 있기 때문에
	// 사용하는 DB 종류에 따라 정책도 다르게 설정
	// GenerationType.AUTO 라고 하면 알아서 정함
	// 시퀀스 객체가 만들어주는 번호를 사용하겠습니다
	// 라고 알려주는것
	// @SequenceGenerator 를 써서
	// 시퀀스 객체 이름도 알려줘야함
	// 보통 @SequenceGenerator 에서 name 이랑
	// @GeneratedValue 에서의 generator 를 같게 함
	@Id
	@Column(name = "seq")
	@SequenceGenerator(name = "seqItem", allocationSize = 1, sequenceName = "seqItem")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	private Long seq;
	
	// 혹시라도 DB 에 있는 컬럼명이랑 이곳에서의 멤버 이름이 다르면
	// 따로 매핑을 해줘야하니 @Column 으로 명시해줌
	// 제약사항도 작성할 수 있음
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "qty", nullable = true)
	private Integer qty;
	
	@Column(name = "description", nullable = true)
	private String description;

	//매핑 메서드
	// 엔티티를 DTO로 바꾸려고
	// select 하려고 만들었음
	public ItemDto toDto() {
			
		return ItemDto.builder()
					  .seq(this.seq)
					  .name(this.name)
					  .price(this.price)
					  .color(this.color)
					  .qty(this.qty)
				      .description(this.description)
					  .build();
		}
	
	// CRUD 중 UPDATE 하려고
	// Setter 역할을 하는 메서드를 정의
	public void update(String name, Integer price, String color, Integer qty, String description) {
		
		this.name = name;
		this.price = price;
		this.color = color;
		this.qty = qty;
		this.description = description;
		
	}

}
