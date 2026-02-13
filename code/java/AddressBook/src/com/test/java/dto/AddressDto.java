package com.test.java.dto;

// 계층과 계층간에 데이터를 전달하는 택배상자
// 클래스 or HashMap or Record
// DTO(Data Transfer Object)
// VO(Value Object)
public class AddressDto
{
	
	
	// 김민수	25	1	010-1234-5678	서울시 강남구 역삼동 101-2
	private String name;
	private String age;
	private String gender;
	private String tel;
	private String address; // <- 상자
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	
	
}
