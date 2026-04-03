package com.test.java.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
	// 로그를 남기는 보조 업무
	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[%tF %tT] 로그를 기록합니다.\r\n", now, now);
	}

	// 테스트용 보조 업무
	public void test() {
		System.out.println("test: 보조 업무입니다.");
	}

	// 특정 업무가 얼마나 걸리는지 시간을 재는 보조 업무
	public void time(ProceedingJoinPoint jp) {

		long begin = System.nanoTime();

		// 이 시점에서 주 업무를 실행
		// - memo.addMemo("엄준식의 메모입니다."); <- 이렇게 하는거 아님
		// 프록시 객체를 써야한다(jp)
		// addMemo가 호출되면 그 순간 proceed가 반응을해서
		// proceed가 마치 addMemo 역할을 한다
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long end = System.nanoTime();

		System.out.printf("소요 시간: %,dns\r\n", end - begin);
	}
	
	public void checkValid(Object result) {
		// System.out.println("보조 업무 실행: " + result);
		
		if ((boolean)result) {
			System.out.println("주 업무 정상 동작 중");
		} else {
			System.out.println("주 업무 비정상 동작 중");
		}
	}
	
	// 에러 전용 보조 업무 객체
	public void logException(Exception e) {
		System.out.println("보조 업무 실행 > " + e.getMessage());
		
		// 에러가 발생했을 경우의 대처
		// ex) Log 기록
		// ex) 담당자 연락 등 ..
	}
}
