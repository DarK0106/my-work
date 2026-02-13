package com.test.java.obj;

public class Ex34_accessTwo
{
	public static void main(String[] args)
	{
		//Ex34_accessTWoo
		Mouse m1 = new Mouse();
		m1.setModel("VXE");
		System.out.println(m1.getModel());
		
		// 객체의 price 상태가 값을 넣을 수는 있는데 가져올 수는 없는 경우 -> 쓰기 전용 멤버 라고 부름
		m1.setPrice(5000);
		// System.out.println(m1.getPrice()); <- getter 안 만들어놨음
		
		System.out.println(m1.getColor()); // <- setter 안 만들어놨음 -> 읽기 전용
		
		m1.setButtons(5);
		
		// 프로퍼티(Property) -> 속성
		// - 객체의 상태(객체가 가지고 있는 데이터)
		// 진정한 의미의 프로퍼티는 멤버 변수
		// - Setter/Getter 라는 메서드를 프로퍼티라고 한다
		
		// 쓰기 전용 멤버 -> 계산된 프로퍼티, 가상 프로퍼티
		// - 실제로 멤버 변수로는 존재하지 않는데 마치 존재하는 것처럼 동작한다
		System.out.println(m1.getType());
	}
}

// 클래스 -> 객체 생성 -> 객체(데이터(변수) + 행동(메서드))
class Mouse
{
	// 이클립스에서 빨간 네모: private, 녹색 동그라미: public
	private String model;
	private int price;
	private String color = "white";
	private int buttons;
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String model)
	{
		// 마우스 모델명으로 적절하지 않은 값이 들어오면 
		// 통과시키지 않는다 (유효성 검사) <- 아직 안 만들었음
		this.model = model;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getColor()
	{
		
		// 마우스 회사 정책에 따라 가격별로 색상이 정해져 있다면?
		
		if (price >= 0 && price <= 10000)
		{
			color = "black";
		}
		else if (price <= 30000)
		{
			color = "white";
		}
		else
		{
			color = "gold";
		}
		return color;
	}

	public void setButtons(int buttons)
	{
		this.buttons = buttons;
	}
	
	public String getType()
	{
		String type = "";
		
		if (buttons <= 3)
		{
			type = "초보자용";
		}
		else if (buttons <= 5)
		{
			type = "사무용";
		}
		else
		{
			type = "전문가용";
		}
		
		return type;
	}
	
}