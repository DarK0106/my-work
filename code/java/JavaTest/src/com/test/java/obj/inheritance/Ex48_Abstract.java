package com.test.java.obj.inheritance;

public class Ex48_Abstract
{
	public static void main(String[] args)
	{
		// Ex48_Abstract.java
		/*
		 * 
		 * 추상, Abstract
		 * - 여러 가지 사물이나 개념에서 공통되는 속성 따위를 추출하여 파악하는 작용
		 * 
		 * 추상화
		 * - 우리집에 다리 짧고 주둥이가 납작하고 털 길고 먹성이 엄청 좋음
		 * - 옆집에도 다리 짧고 주둥이가 납작하고 털 길고 먹성이 엄청 좋음
		 * - 앞집에도 나이는 좀 들었지만 다리 짧고 주둥이가 납작하고 털 길고 먹성이 엄청 좋음
		 * - 이런 애들을 시츄라고 부르자!
		 * 
		 * 여러 클래스들이 가지는 공통된 특성을 수집, 추출해서 클래스 추상화
		 * 표현을 쉽게 하기 위해서
		 * 
		 * 추상 클래스,Abstract Class
		 * 추상 클래스 안에 추상 메서드를 만든다, Abstract Method
		 * 객체를 생성할 수 없다 -> 추상 메서드 때문
		 * 붕어빵을 못 만드는 붕어빵 틀
		 * 참조 변수는 생성할 수 있다
		 * 클래스 상속에 개입할 수 있다 -> 일반 클래스의 부모 클래스가 될 수 있다
		 * 
		 * 
		 */
		
		VXE m1 = new VXE();
		
		m1.click();
		m1.click();
		m1.click();
		
		G305 m2 = new G305();
		
		// m2.click(); <- 이전에 사용했던 마우스의 경험이 새로운 마우스에서는 도움이 안됨
//		m2.push();
//		m2.push();
//		m2.push();
		
		// Cannot instantiate the type Mouse <- 추상 클래스는 객체를 생성할 수 없다
		// Mouse m3 = new Mouse();
		
//		Mouse m3 = new Mouse();
		// m3.click(); // 호출 -> 결과 -> 뭘 해야할지 모름 -> 문제가 생김
		
		// Mouse = G305
		// 부모 = 자식
		// 업캐스팅
		// m3 = m2; // m3 = (Mouse)m2; <- 원랜 이런 형태
		
		Mouse m4 = new G305(); // 자식을 만들어서 부모 클래스에 넣은 것, 업캐스팅
		Mouse m5 = new VXE();
		
		VXE m6 = new VXE();
		G305 m7 = new G305();
		
		// 구현된 멤버의 역할 -> 모든 마우스가 동일한 동작
		m6.color = "black";
		m6.checkColor();
		
		// 추상 멤버 -> 구현함 -> 껍데기는 동일한데 -> 마우스마다 다른 동작
		m6.click();
		
		m7.color = "white";
		m7.checkColor();
		m7.click();
	} // main
}

// 추상 클래스
// 추상 클래스는 일반 클래스(구현된 멤버)를 가질 수 있고, 추상 멤버(추상 메서드)도 가질 수 있다.
abstract class Mouse // 적어도 기본적인 마우스 기능은 click push 이러지 말고 통일을 좀 하자
{
	// 구현된 멤버 <- 실제로 메모리에 생성되는 완성된 멤버
	// 변수 <- 실제로 잡히는 공간 있음
	// 메서드 <- 호출 + 실행 가능
//	public int a;
//	public int b;
//	
//	public void ccc()
//	{
//		
//	}
//	
//	public void ddd()
//	{
//		
//	}
	
	// 구현된 멤버
	public String color;
	
	public void checkColor()
	{
		
	}
	
	// 추상 메서드는 구현부 { } 가 없는 메서드이다
	public abstract void click();
} // Mouse

// 마우스 클래스
class VXE extends Mouse
{
	public int price;
	public String color;
	
	public void click()
	{
		System.out.println("VXE 마우스 클릭");
	}
	
	// public abstract void test(); // 일반 클래스는 절대 추상 메서드를 소유할 수 없다.
}

class G305 extends Mouse // The type G305 must implement the inherited abstract method Mouse.click() <- click 안만들면 에러남
{
	public int weight;
	public String color;
	
//	public void push()
//	{
//		System.out.println("로지텍 마우스 클릭");
//	}
	
	// 추상 클래스 Mouse의 추상 메서드 click을 구현했다.(메서드 오버로딩했다.)
	public void click()
	{
		System.out.println("로지텍 마우스 클릭");
	}
}

class M100 extends Mouse
{
	@Override
	public void click() // 구현부가 없는 메서드 = 추상 메서드 -> 객체의 행동을 표준화 -> 고객 편의성 개선
	{
		
	}
}
// 클래스를 설계하는 사람을 위한 기술이 아니고 그 클래스로부터 객체를 만드는 사람을 위한 것