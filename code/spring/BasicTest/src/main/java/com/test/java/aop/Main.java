package com.test.java.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		 * AOP, Aspect Oriented Programming - 관점 지향 프로그래밍 - 주 업무 코드와 보조 업무 코드를 나눠서 표현 -
		 * 보통 주 업무와 보조 업무를 같은 파일에 작성하는 경우가 흔했다 -> 코드 관리가 불편함, 가독성 저하, 중복 코드 발생 - 이걸 해결하기
		 * 위해서 중복되는 보조업무들이 주 업무에 횡단으로 끼어들어서 들어가는 식으로 해결? 횡단 관심사(Cross-Cutting Concerns)?
		 * core concern?
		 * 
		 * 
		 * 
		 * 
		 */

		// m1();
		// m2();
		// m3();
		m4();
	} // Main

	private static void m4() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/java/aop/memo.xml");
		Memo memo = (Memo) context.getBean("memo");

		// memo.addMemo("메모를 작성합니다.");
		// memo.del("1");

		// boolean result = memo.del("1");

		try {
			System.out.println(memo.readMemo("4"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		// 우리가 직접 만든 객체는 스프링의 관리를 받지 못한다.
//		Memo memo = new MemoImpl();

		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/java/aop/memo.xml");
		Memo memo = (Memo) context.getBean("memo");
		memo.addMemo("메모입니다.");

		try {
			String content = memo.readMemo("1");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(memo.edit("1", "수정합니다 ^^"));

		System.out.println(memo.del("1"));
	}

	// 문제점 -> 유지보수 매우안좋음(log 안 남기기로 결정했으면 일일이 다 지워야함)
	private static void m2() {
		// 순수 자바
		Memo memo = new MemoImpl();
		memo.addMemo("메모입니다.");

		try {
			String content = memo.readMemo("1");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(memo.edit("1", "수정합니다 ^^"));

		System.out.println(memo.del("1"));
	}

	private static void m1() {

		// 순수 자바
		Memo memo = new MemoImpl();
		memo.addMemo("메모입니다.");

		try {
			String content = memo.readMemo("1");
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(memo.edit("1", "수정합니다 ^^"));

		System.out.println(memo.del("1"));

	}

}
