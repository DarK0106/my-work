package com.test.java.obj;

public class Ex39_This
{
	public static void main(String[] args)
	{
		// Ex39_This.java
		
		// c1 -> 첫번째 컵 -> 절대표현(이름, 주민등록번호 같은 것)
		Cup c1 = new Cup();
		c1.setColor("black");
		
		Cup c2 = new Cup();
		c2.setColor("white");
		
		Cup c3 = new Cup();
		c3.setColor("yello");
		
		System.out.println(c1.getColor());
		System.out.println(c2.getColor());
		System.out.println(c3.getColor());
		
		
		
	} // main
}


class Cup
{
	private String color;
	private int size;
	
	public void setColor(String color)
	{
		
		// this -> (자신) 객체 접근 연산자
		// this 에도 c1 에 적혀있던 주소랑 같은 주소가 적혀 있는데 this로 접근하면 private 울타리 안으로 접근함
		// this 의 역할 -> 나(자기 자신)
		this.color = color; // 제 이름은 이거에요
		
		// c1.color = color; // 윤재 이름은 윤재에요 <- 애초에 안되긴함
		// 클래스가 먼저 만들어지는데 이때 c1은 존재하지도 않아서 표현이 안됨
	}
	
	public String getColor()
	{
		// return color; <- 이렇게 써도 괜찮음
		// 1. 아래처럼 쓰는 이유는 가독성이 높음
		// 그리고 String color = ""; 이런게 있을 수 있어서 사고 날 수 있음
		// 2. 코딩하기가 쉬움
		return this.color;
	}
}