package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex56_Queue
{
	public static void main(String[] args)
	{
		// Ex56_Queue.java
		// 스택과 큐
		/*
		 * 
		 * ADT, Abstract Data Type(추상적 자료형)
		 * - 배열인데 사용법을 용도에 맞게 재구성했다
		 * - Stack
		 * - Queue
		 * 
		 * Stack
		 * 	- 후입선출
		 * 	- LIFO, Last Input First Output
		 * ex) 메모리 구조
		 * ex) 되돌리기(Ctrl + Z), 다시하기(Ctrl + Y)
		 * ex) 브라우저 -> 뒤로가기, 앞으로 가기
		 * 
		 * Queue
		 * 	- 선입선출
		 * 	- FIFO First Input First Output <- 편의점
		 * ex) 줄서기
		 * 
		 */
		// m1(); // Stack
		m2(); // Queue
	}

	private static void m2()
	{
		// Queue
		Queue<String> queue = new LinkedList<String>(); // Queue는 클래스가 아니고 인터페이스이다
		// LinkedList 껍데기만 바꿔서 Queue 로 사용한다?
		
		// 1. 요소 추가하기(공 넣기)
		// - boolean add(T value)
		queue.add("빨강"); // 다른 언어에서는 enqueue()라고 많이 씀
		queue.add("노랑");
		queue.add("파랑");
//		
//		// 2. 요소 개수 확인하기
//		System.out.println(queue.size());
//		
//		// 3. 요소 읽기(공을 꺼내서 확인)
//		System.out.println(queue.poll()); // 다른 언어에서는 dequeue
//		System.out.println(queue.size());
		
		// 공이 없는데 꺼내면 null이 반환된다
		
		// 루프를 돌리고 싶다면
//		while (queue.size() > 0) // 공이 남아있다면 ~
//		{
//			System.out.println(queue.poll()); // 꺼내라
//		}
		
		// 4. 공 안 꺼내고 요소 읽기
		System.out.println(queue.peek()); // 제일 먼저 나올 예정인 빨간색만 보임
		
	}

	private static void m1()
	{
		// Stack
		Stack<String> stack = new Stack<String>(); // String은 클래스이다
		
		// 1. 요소 추가하기
		// - T push(T value)
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		
		// 2. 요소 개수 검사하기
		System.out.println(stack.size()); // ArrayList랑 비슷한 인터페이스를 상속받아서 스택도 size()를 쓸 수 있다
		// (ArrayList의 size()랑은 다르더라도 사용법은 비슷해서 사용하기 쾌적하다)
		
		// 3. 요소 꺼내기 + 읽기
		// - T pop()
//		System.out.println(stack.pop()); // 꺼내서 읽은 것
//		System.out.println(stack.size());
//		
//		System.out.println(stack.pop()); // 꺼내서 읽은 것
//		System.out.println(stack.size());
//		
//		System.out.println(stack.pop()); // 꺼내서 읽은 것
//		System.out.println(stack.size()); // 다 꺼내서 없음, 또 꺼내려고 하면 에러남
		
//		int size = stack.size(); // 루프돌리면서 꺼내니까 stack.size();가 계속 줄어들음, 빨강이 안 나옴. 
//		// 그래서 size로 미리 배열의 길이를 받아옴
//		
//		for (int i = 0; i < size; i++)
//		{
//			System.out.println(stack.pop());
//		}
		
//		while(stack.size() > 0) // 이 방법이 제일 좋다
//		{
//			System.out.println(stack.pop());
//		}
		
		// 4. 배열이 비어있는지 확인하기
		System.out.println(stack.isEmpty()); // 비어있으면 true 출력
		
		// 5. 요소를 꺼내지 않고 읽기
		System.out.println(stack.peek()); // 안 꺼내고 파이프 구멍만 보는거 -> 제일 바깥쪽에 있는 파랑만 보임
		// 계속 해도 제일 바깥쪽에 있는 요소밖에 안 보임
		System.out.println(stack.size());
		
		
	}
}
