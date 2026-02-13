package com.test.java.obj;

public class Ex33_Access
{
	public static void main(String[] args)
	{
		// Ex33_Access.java
		/*
		 * 
		 * 000 지정자(제어자) -> 클래스 또는 클래스 변수, 메서드 3가지 애들한테 
		 * 원래 자신이 하던 일에서 확장이 되서 부가적인 기능을 제공하는 키워드
		 * 
		 * 접근 지정자(제어자), Access Modifier
		 * - 클래스에 붙일 수 있다.
		 * - 클래스 멤버 변수에 붙일 수 있다. <- 이 예제에서 해볼 것
		 * - 클래스 멤버 메서드에 붙일 수 있다. <- 이 예제에서 해볼 것
		 * - 지역 변수에는 사용이 불가능하다.
		 * - *멤버 자신이 속한 영역 밖으로 자신을 공개를 할지 말지 정하는 키워드*
		 * - 캡슐화 / 정보은닉화 -> 객체의 안정성 or 사용법 통제
		 * 
		 * 1. public
		 * 		- 100% 공개
		 * 2. private
		 * 		- 100% 비공개
		 * 3. protected
		 * 4. (default, package) <- 생략을 하는 키워드. 눈에 안 보임
		 * 
		 */
		
		// m1();
		// m2();
		m3();
	}

	private static void m3()
	{
		Note n1 = new Note();
		
		// n1.color
		// n1.price
		n1.setColor("파란색");
		System.out.println(n1.getColor());
		
		n1.setPrice(3000);
		System.out.println(n1.getPrice());
	}

	private static void m2()
	{
		Book b1 = new Book();
		
//		b1.title = "sasdadasdazxczxcz"; <- 멤버 변수를 public으로 해놓으면 이런 말도 안 되는 값 넣는걸 제어롤 못함
//		b1.price = 3506666666555555555550; <- 멤버 변수를 public으로 해놓으면 이런 말도 안 되는 값 넣는걸 제어롤 못함
//		
//		System.out.println(b1.title);
//		System.out.println(b1.price);
		
		b1.aaa();
		// b1.bbb();
		b1.ccc("자바의 정석"); // "자바의 정석" 이란 값을 주는 것
		System.out.println(b1.ddd()); // 값을 돌려받는 것
		
		b1.eee(30000);
		System.out.println(b1.fff());
	}

	private static void m1()
	{
		Book b1 = new Book();
		
		// System.out.println(b1.a);
		// System.out.println(b1.b); <- The field Book.b is not visible <- private 해놓으면 안보임
		
	}
}

class Note
{
	// 1. 우선 모든 멤버 변수는 private으로 하는게 좋다 <- 이상한 값 넣는걸 막기 위해서
	private String color;
	private int price;
	
	// 2. 통로(인터페이스) 역할을 하는 public 메서드 구현
	// 외부 -> 값 -> 내부
	// - Setter 라고 함
	// - 이름: set멤버변수() 이런 식으로 짓는다
	public void setColor(String color)
	{	
		// 멤버 변수(파란색 color)와 지역 변수(String color에서의 color)의 충돌 
		// <- 멤버 변수와 지역 변수는 이름이 똑같아도 에러가 안 남
		// 그래서 앞에 this.를 붙임
		this.color = color;
	}
	
	// 내부 -> 값 -> 외부
	// - Getter 라고 함
	// - 이름: get멤버변수()
	public String getColor()
	{
		return this.color;
	}
	// Note 클래스 안에서 우클릭 -> Source -> Generate Getter and Setters..
	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}
	
}

class Book
{	
	// 멤버 변수 = 필드(field)
	// public int a = 10;
	// private int b = 20;
	
//	public String title;
//	public int price;
	
	private String title;
	private int price;
	
	public void aaa()
	{
		System.out.println("aaa");
	}
	
	private void bbb()
	{
		System.out.println("bbb");
	}
	
	public void ccc(String a)
	{
		title = a;
		// ccc() 메서드는 title이랑 같이 private 울타리 안에 있어서 title의 값을 볼 수 있음
		// ccc는 public이라 울타리 넘어서 접근 가능
		// 그래서 m2에서 ccc 호출하면 title에 있는 값 출력 가능
	}
	
	public String ddd()
	{
		return title;
	}
	
	public void eee(int a)
	{
		if (a >= 0 && a <= 1000000) // 여동생한테 줘도 되는 선물인지 아닌지 오빠가 먼저 까보고 괜찮으면 전달함
		{
			price = a;
		}
		else
		{
			System.out.println("책 가격 오류");
		}
	}
	
	public int fff()
	{
		return price;
	}
}