package com.test.java.model;

import com.test.java.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

	private Long seq;
	private String name;
	private Integer price;
	private String color;
	private Integer qty;
	private String description;
	
	// 우리가 여지껏 컨트롤러에서
	// 생성자를 만들거나 빌더 패턴을
	// 일일이 코딩해서 DTO를 엔티티로 바꾼건데
	// 이렇게 해두면 그럴 필요가 없이 이곳에서
	// 매핑해서 보내줌
	// 매핑 메서드
	
	public Item toEntity() {
		
		return Item.builder()
					.seq(this.seq)
					.name(this.name)
					.price(this.price)
					.color(this.color)
					.qty(this.qty)
					.description(this.description)
					.build();
	}
	
	// 특정 컬럼만 갖고 오고 싶을 때 사용함
	// 반환된 엔티티를 DTO로 매핑하기 위해 작성
	public ItemDto(String name, String color, Integer qty) {
		this.name = name;
		this.color = color;
		this.qty = qty;
	}

}
