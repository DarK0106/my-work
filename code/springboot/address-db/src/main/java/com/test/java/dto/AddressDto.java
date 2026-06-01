package com.test.java.dto;

import com.test.java.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
	
	private Long seq;
	private String name;
	private Long age;
	private String gender;
	private String address;	
	
	public static AddressDto toDto(Address address) {
		
		return new AddressDto(
			address.getSeq(),
			address.getName(),
			address.getAge(),
			address.getGender(),
			address.getAddress()
		);
	}
	
	public Address toEntity() {
		
		return new Address(
			this.getSeq(),
			this.getName(),
			this.getAge(),
			this.getGender(),
			this.getAddress()
		);
	}

}
