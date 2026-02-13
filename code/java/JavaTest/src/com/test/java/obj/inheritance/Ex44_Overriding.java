package com.test.java.obj.inheritance;

public class Ex44_Overriding
{
	public static void main(String[] args)
	{
		// Ex44_Overriding
		/*
		 * 
		 * 메서드 오버로딩, Method Overloading
		 * 	- 메서드 이름을 똑같이 만들면서 메서드 여러개를 선언하는 기술
		 * 
		 * 메서드 오버라이딩, Method Overriding
		 *  - 클래스를 상속할 때 발생
		 *  - 메서드 재정의라고도 한다 -> 상속받은 메서드를 수정하는 기술
		 */
		
		OverridingParent o1 = new OverridingParent();
		o1.name = "홍길동";
		o1.hello();
		
		OverridingChild o2 = new OverridingChild();
		o2.name = "홍철수";
		o2.hello(); // 아빠한테 상속받은 hello인지 철수가 선언한 hello인지?? -> 철수가 선언한 hello가 찍힘
		// o2.hi(); // 이게 왜 문제냐 -> 내가 폰을 쓰고 있는데 갑자기 일본어밖에 안써짐 -> 한글로 바뀌지도 않음
		
	} // main
}

class OverridingParent
{
	public String name;
	
	public void hello()
	{
		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n", this.name);
	}
}

// 상속 거부는 절대 불가능하다
class OverridingChild extends OverridingParent
{
	// 철수가 부모의 메서드를 사용하기 싫다면?
	
	public void hi()
	{
		System.out.printf("즐거운 아침입니다~ %s입니다.\n", this.name);
	}
	
	// 메서드 재정의(메서드 오버라이딩)
	// - 부모가 물려준 메서드를 감추고, 내가 만든 메서드를 사용하겠다.
	@Override // 어노테이션(일종의 주석), 주석은 적어놔도 아무 일도 안하지만, 어노테이션은 약간의 기능을 함
	public void hello()
	{
		System.out.printf("즐거운 아침입니다~ %s입니다.\n", this.name);
	}
}