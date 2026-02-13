package com.test.java.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Ex69_LambdaTwo
{
	public static void main(String[] args)
	{
		// 람다식 == 추상 메서드의 구현체 == 메서드
		// - 매개변수 유 / 무
		// - 반환값 유 / 무
		// 람다식 왜써? 객체를 편하게 만들기 위해
		
		NoParameterNoReturn pr1 = new NoParameterNoReturn()
		{
			
			@Override
			public void call()
			{
				System.out.println("pr1");
			}
		};
		pr1.call();
		
		NoParameterNoReturn pr2 = () -> {
			System.out.println("pr2");
		};
		pr2.call();
		
		
		// 람다식 구현부 -> 문장이 1개라면 {} 생략 가능
		NoParameterNoReturn pr3 = () -> System.out.println("pr3");
		pr3.call();
		
		ParameterNoReturn pr4 = (int n) ->
		{
			System.out.println("pr4: " + n);
		};
		pr4.call(100);
		pr4.call(200);
		pr4.call(300);
		
		//람다식의 매개변수의 자료형은 언제든 생략할 수 있다
		ParameterNoReturn pr5 = (n) -> {
			System.out.println("pr5: " + n);
		};
		pr5.call(10);
		pr5.call(20);
		pr5.call(30);
		
		
		// 람다식의 매개변수 개수가 1개이면 ()를 생략할 수 있다
		ParameterNoReturn pr6 = n -> {
			System.out.println("pr6: " + n);
		};
		pr6.call(100);
		pr6.call(200);
		
		ParameterNoReturn pr7 = n -> System.out.println(n);
		
		
		// MultiParameterNoReturn
		MultiParameterNoReturn pr8 = (String name, int age) -> {
			System.out.println(name + ": " + age);
		};
		pr8.call("홍길동", 20);
		
		
		MultiParameterNoReturn pr9 = (name, age) ->
		{
			System.out.println(name + ": " + age);
		};
		pr9.call("아무개", 30);
		
		MultiParameterNoReturn pr10 = (name, age) -> System.out.println(name + ": " + age);
		pr10.call("강아지", 3);
		
		// NoParameterReturn
		NoParameterReturn pr11 = () ->
		{
			return 10;
		};
		System.out.println(pr11.call());
		
		
		// 구현부에 return문이 유일한 문장이면 {}와 return 을 모두 생략가능
		NoParameterReturn pr12 = () -> 20;
		System.out.println(pr12.call());
		
		ParameterReturn pr13 = (int a, int b) ->
		{
			return a + b;
		};
		System.out.println(pr13.call(10, 20));
		
		// 최대한 압축
		ParameterReturn pr14 = (a, b) -> a + b;
		System.out.println(pr14.call(10, 20));
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Random rnd = new Random();
		
		while (nums.size() < 10)
		{
			nums.add(rnd.nextInt(10));
		}
		System.out.println(nums);
		
//		nums.sort(new Comparator<Integer>()
//		{
//			@Override
//			public int compare(Integer o1, Integer o2)
//			{
//				return o1 - 02;
//			}
//		}); // <- 원래 이렇게 해야 했는데
		
		nums.sort((o1, o2) -> o2 - o1);
		
		System.out.println(nums);
		
		
		
	} // main
}

interface NoParameterNoReturn 
{
	void call();
}

interface ParameterNoReturn 
{
	void call(int n); // 인자값 하나를 넣는 추상 메서드
}

interface MultiParameterNoReturn 
{
	void call(String name, int age);
}

interface NoParameterReturn 
{
	int call();
}

interface ParameterReturn
{
	int call(int a, int b); // 숫자를 하나 주면 두개 돌려주는 ?
}

