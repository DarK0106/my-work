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

}
