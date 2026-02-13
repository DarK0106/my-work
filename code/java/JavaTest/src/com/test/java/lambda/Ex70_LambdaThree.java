package com.test.java.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ex70_LambdaThree
{
	public static void main(String[] args)
	{
		/*
		 * 람다식은 익명 개체의 구현된 추상 메서드이다 -> 인터페이스 참조 변수에 저장 람다식을 사용하려면 반드시 그 전에 인터페이스를 만들어야한다
		 * 
		 * 자바는 람다식을 저장하기위한 여러가지 인터페이스를 미리 제공해준다 -> 함수형 인터페이스(Functional Interface)
		 * 
		 * 함수형 인터페이스 1. 표준 API 함수형 인터페이스 - JDK에서 제공하는 인터페이스 2. 사용자 정의 함수형 인터페이스 - 개발자가
		 * 만든 인터페이스
		 * 
		 * 1. 표준 API 함수형 인터페이스 카테고리 1. Consumer - Consumer<T> - BiConsumer<T,U> - 기타등등 -
		 * 매개변수가 있고 반환값이 없다 -> 추상 메서드 제공
		 * 
		 * 2. Supplier - Supplier<T> - 기타등등 - 매개변수가 없고 반환값이 있다 -> 추상 메서드 제공
		 * 
		 * 3. Function - Function<T,R> - BiFunction<T,U,R> - 기타등등 - 매개변수가 있고 반환값도 있다 ->
		 * 추상 메서드를 제공
		 * 
		 * 4. Operator - Function 하위셋 - 매개변수가 있고 반환값도 있다 -> 추상 메서드를 제공
		 * 
		 * 5. Predicate - Function 하위셋 - 매개변수가 있고 반환값도 있다 -> 추상 메서드를 제공
		 * 
		 * 
		 * 
		 */

		// m1();
		// m2();
		// m3();
		// m4();
		m5();

	} // main

	private static void m5()
	{
		// Predicate
		// 매개변수를 전달하면 처리 후 반환값을 돌려주는 업무
		// testXXX() 추상 메서드를 제공
		// 인자를 넘기면 반환값이 boolean인 애들만 모아둔 것
		// 성공인지 실패인지 따지는 애들만 모아뒀다?
		
		Function<Integer, Boolean> f1 = num -> num > 0;
		
		Predicate<Integer> p1 = num -> num > 0; // 무조건 반환값이 boolean
		
		System.out.println(f1.apply(10));
		System.out.println(p1.test(10));
		
		BiPredicate<Integer, Integer> bp1 = (a, b) -> a > b; // < > 안에 둘 다매개변수값, 리턴값은 무조건 boolean
		System.out.println(bp1.test(10, 5));
	
	}

	private static void m4()
	{
		// Operator
		// 함수의 일종이다.
		// 주 업무가 매개변수를 전달하면 그걸 처리 후 결과를 돌려주는 업무가 필요할 때 사용하는 메서드가 필요할 떄 사용
		// 주로 메서드 이름이 applyXXX() 추상 메서드 제공
		// 1 + 2 = 3 사칙연산은 보통 피연산자와 연산의 결과가 자료형이 비슷하거나 똑같다
		// 추상 메서드의 매개변수 자료형과 반환값의 자료형이 동일하다

		BiFunction<Integer, Integer, Integer> bf1 = (a, b) -> a + b; // 이걸 쓰지 말고 Operator를 쓰자는 취지
		System.out.println(bf1.apply(13, 42));

		BinaryOperator<Integer> bf2 = (a, b) -> a + b; // 모르면 function 쓰면 되는데 operator가 가독성이 높고 간결하다
		System.out.println(bf2.apply(17, 23));

		UnaryOperator<Integer> bf3 = a -> a * a;
		System.out.println(bf3.apply(3));

	}

	private static void m3()
	{
		// Function
		// 매개변수를 전달하면 그걸 처리 후 결과를 돌려주는 업무가 필요할 때 사용하는 메서드
		// 주로 메서드 이름이 applyXXX() 추상 메서드 제공

		// String 이 매개변수의 자료형이고 Integer가 리턴값의 자료형이다
		Function<String, Integer> f1 = str -> str.length();
		System.out.println(f1.apply("안녕하세요"));

		Function<Integer, Boolean> f2 = num -> num > 0; // 양수면 true 음수면 false
		System.out.println(f2.apply(10));
		System.out.println(f2.apply(-10));

		BiFunction<Integer, Integer, Integer> f3 = (a, b) -> a + b; // 숫자 2개를 주면 숫자 1개를 반환해주겠다
		System.out.println(f3.apply(6, 9));

		BiFunction<Integer, Integer, String> f4 = (a, b) ->
		{
			if (a > b)
			{
				return "크다";
			} else if (a < b)
			{
				return "작다";
			} else
			{
				return "같다";
			}
		};
		System.out.println(f4.apply(10, 5));
	}

	private static void m2()
	{
		// Supplier
		// 매개변수는 필요없고 반환값만 필요한 업무를 구현하는 메서드가 필요할 때
		// getXXX() 라는 추상 메서드를 제공함

		Supplier<Integer> s1 = () -> 100; // 매개변수는 없()고 반환값은 100
		System.out.println(s1.get());

		Supplier<Double> s2 = () -> Math.random();
		System.out.println(s2.get());

		Supplier<String> s3 = () -> "김고수";
		System.out.println(s3.get());

		IntSupplier s4 = () -> 20;
		System.out.println(s4.getAsInt());
	}

	private static void m1()
	{
		// Consumer
		// 업무 구현 -> 메서드 구현
		// 매개변수를 받아서 소비하는 업무를 구현하는 메서드가 필요할 때
		// 매개변수는 있고 반환값은 없는 인터페이스
		// acceptXXX() 의 추상메서드를 제공함

		MyConsumer c1 = new MyConsumer()
		{

			@Override
			public void test(int num)
			{
				System.out.println(num * 2);
			}
		};
		c1.test(100);

		// 람다식
		MyConsumer c2 = num -> System.out.println(num * 2);
		c2.test(200);

		// java.util.function 인 애들만 우리가 쓸 Consumer
		Consumer<Integer> c3 = new Consumer<Integer>()
		{

			// <Integer> 가 (Integer t) 여기로 감
			@Override
			public void accept(Integer t) // 매개변수 t가 있고 반환값이 없(void)다
			{
				System.out.println(t * 2);
			}

		};
		c3.accept(300);

		Consumer<Integer> c4 = num -> System.out.println(num * 2); // num 이라는 변수로 받겠다

		c4.accept(400); // 위에 c3했던거랑 똑같은거

		Consumer<String> c5 = name -> System.out.println(name.length()); // int 뿐만아니라 String도 가능
		c5.accept("대한민국");

		Consumer<Integer> c6 = count ->
		{
			for (int i = 0; i <= count; i++)
			{
				System.out.println(i);
			}
		};
		c6.accept(5);

		Consumer<User> c7 = user ->
		{
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println("주소: " + user.getAddress());
		};// 매개변수를 User로 받는 메서드를 만들겠다
		c7.accept(new User("홍길동", 20, "서울시"));

		// 여지껏 한건 Consumer<T>

		// 앞으로 할건 BiConsumer<T, U> <- 메서드에 매개변수가 2개 <- Consumer<T> / BiConsumer<T, U>
		// 이 둘을 제일 많이 씀 Generic 이라서
		BiConsumer<String, Integer> bc1 = (name, age) ->
		{
			System.out.println("이름: " + name);
			System.out.println("나이: " + age);
		};
		bc1.accept("엄준식", 25);

		BiConsumer<Integer, Integer> bc2 = (a, b) -> System.out.println(a + b);

		bc2.accept(15, 35);

		Consumer<Integer> ic1; // 범용, < > 가 int 아닌 다른걸로도 옴
		IntConsumer ic2; // 전용, 무조건 매개변수가 int

		// 왜 전용컨슈머가 있을까? 범용에서는 타입에 관계없는 업무만 구현할 수 있다?
		// 범용컨슈머는 두루두루 받을 수 있지만 적당한 일만 할 수 있고
		// 전용컨슈머에서는 그 자료형에 맞는 특정 업무를 미리 구현할 수 있다 <- 전문적인 업무가 가능하다

		IntConsumer ic3 = num -> System.out.println(num * num);
		ic3.accept(8); // 8*8 = 64

		DoubleConsumer dc1;
		LongConsumer lc1;
		ObjDoubleConsumer<String> odc1 = (name, weight) ->
		{
			System.out.println(name);
			System.out.println(weight);
		};
		odc1.accept("몸무게", 75.8);

	} // m1
}

interface MyConsumer
{
	void test(int num); // 메서드에 매개변수가 1개 -> Consumer<T>
}

class User
{
	private String name;
	private int age;
	private String address;

	public User(String name, int age, String address)
	{
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
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