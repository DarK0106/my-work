package com.test.java.obj.inheritance;

public class Ex46_Final
{
	public static void main(String[] args)
	{
		// Ex46_Final.java
		/*
		 * 
		 * final 키워드
		 * 
		 * 	- 한 번 결정하면 바꿀 수 없다.
		 * 	- 왜? 안정성을 높이기 위해서
		 * 
		 * 	1. (지역 또는 멤버)변수에 적용
		 * 	- 의미를 가진 상수를 만들기 위함
		 * 	- 초깃값 이후 수정 불가능
		 * 	- 식별자는 모두 대문자로 작성
		 * 
		 * 	2. 메서드에 적용
		 * 	- 메서드 재정의를 방지할 때
		 *  
		 * 	3. 클래스에 적용
		 * 	- 내가 만든 클래스가 누군가의 부모 클래스가 될 수 있기 때문에 설계를 신중히 해야함
		 * 	- 내가 예측을 못함 부모 클래스는 누군가의 부모가 될지 말지 선택권이 없다
		 * 	- 나는 자식을 갖지 않겠습니다 라고 선언할 때 클래스 앞에 붙이는 final
		 * 
		 */
		
		// 10 -> 데이터, 상수, 리터럴(Literal) -> Constant 랑 다른 의미의 상수
		
		int a = 10;
		final int B = 10; // final 변수 또는 상수(Constant)라고 읽음
		System.out.println(a);
		System.out.println(B);
		
		a = 20; // 변수는 수정이 가능하다
		// b = 20; // 상수는 수정이 불가능하다 The final local variable b cannot be assigned.
		
//		double pi = 3.14; // <- 절대로 변하면 안되는 값을 변수로 선언하면 누가 건들 수 있음
		
		final double PI = 3.14;
		
		// 변수와 상수를 많이 만들다보면 기억이 잘 안남
		// 가독성이 너무 떨어져 상수 변수를 만들 때는 무조건 이름을 대문자로만 쓰기로 약속함
		
//		int NUM = 30; // 반대로 변수를 대문자로 만들면 안됨 
		
		User u1 = new User();
//		u1.gender = "남자";
//		u1.gender = 1;
		u1.gender = Gender.MALE; // 이 안에 숫자 1 들어있음
		
		User u2 = new User();
//		u2.gender = "여자";
		u2.gender = 2;
		u2.gender = Gender.FEMALE; // 이 안에 숫자 2 들어있음
		// 의미없던 1과 2에 의미를 부여, 수정도 못하게 상수로 선언
		
//		if (u1.gender == 1)
//		{
//			System.out.println("군대"); // 이러면 1이 남잔지 여잔지 데이터에 의미가 없음
//			// 다루기 쉬워지고 오타 나기도 힘들지만 숫자는 가독성이 없음
//		}
		
//		if (u1.gender == u1.male)
//		{
//			System.out.println("군대"); // 이러면 가독성도 좋은데 변수라서 누가 바꿀 수 있음 -> final을 써야함
//		}
		
//		if (u1.gender == u1.MALE)
//		{
//			System.out.println("군대"); <- name이랑 age가 u1에도 있고 u2에도 있어서 문제가 있음
//		}
		
		if (u1.gender == User.MALE)
		{
			System.out.println("군대");
		}
		
		System.out.println(Gender.MALE);
		// Calendar.YEAR가 대표적인 열거형 상수
		
		FinalParent fp1 = new FinalParent();
		System.out.println(fp1.plus()); // 30 출력
		
//		FinalChild fc1 = new FinalChild();
//		System.out.println(fc1.plus()); // 10*20 -> 200 출력
		// 오버라이딩을 남발하지 말자, 이건 상속받은거 재정의할게 아니라 새로 만들어야함
		// 문법적으로는 문제 없지만 부모의 의도에 크게 벗어나지 않는 선에서 재정의를 해야한다
		
	} // main
}

class Gender
{
	// 열거형 상수라고 한다
	public final static int MALE = 1;
	public final static int FEMALE = 2; // 애초에 name이랑 age를 잘못 선언한거라 static도 넣어야한다?
	
	// 성별은 수많은 클래스들이 다같이 사용해야하는 데이터다보니까 성별 선언하는 클래스를 따로 만든다
}

class Member
{
	public String name;
	public int age;
	public int gender;
	
}

class User
{
	public String name;
	public int age;
	
	// 성별
//	public String gender; // 문자열로 선언 -> "남자", "여자" 로 쓰고 싶었음 <- 근데 사람들이 이상하게 쓸 것 같음
	public int gender; // 그래서 성별을 숫자로 구분하자 -> 남자(1), 여자(2) <- 근데 숫자는 가독성이 안 좋아서 문제임
	
//	public int male = 1;
//	public int female = 2;
	
	public final static int MALE = 1;
	public final static int FEMALE = 2; // 애초에 name이랑 age를 잘못 선언한거라 static도 넣어야한다?
}

final class FinalParent
{
	// 멤버 변수와 멤버 메서드 선언
	public int a = 10;
	public int b = 20;
	
	// 멤버 메서드를 오버라이딩 금지시키기 위해 final을 쓸 수 있음
	// final도 지정자고 public도 지정자임, 쓰는 순서 상관없음
	// 클래스 상속 때 안정성이 높아지지만 다형성은 떨어짐
	public final int plus()
	{
		return a + b;
	}
}

// class FinalChild extends FinalParent // The type FinalChild cannot subclass the final class FinalParent <- 부모 클래스에 final 붙이니 상속을 못함
// {
	// 부모가 물려준 메서드가 싫어서 오버라이드를 하겠다
//	@Override // 재정의를 하는 이유: 부모가 구현했던걸 버리고 내방식대로 구현하겠다
	// 문법적으로는 문제 없지만 부모의 의도에 크게 벗어나지 않는 선에서 재정의를 해야한다
	// 이건 그걸 무시한 예
	// 헤더(메서드 이름)에 벗어나지 않는 선에서 재정의를 해라
	// 이런걸 방지하기 위해 쓰는게 final
//	public int plus() // Cannot override the final method from FinalParent <- final로 막아버리면 재정의 못함
//	{
//		return a*b;
//	}
// }