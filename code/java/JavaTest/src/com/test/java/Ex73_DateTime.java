package com.test.java;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;

public class Ex73_DateTime
{
	public static void main(String[] args)
	{
		/*
		 * 자바 날짜 / 시간
		 * 1. Date
		 * 2. Calendar
		 * 3. java.time 패키지(1.8)
		 * 	- LocalDate(날짜)
		 * 	- LocalTime(시간)
		 * 	- Period(년월일 간의 시간 차이)
		 *	- Duration (시분초 간의 시간 차이)
		 * 
		 * 
		 * 
		 * 
		 */
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		m7();
		
	}

	private static void m7()
	{
		// 시간의 간격
		// 시간 - 시간 = 시간
		
		// 수업 시작한지 몇시간째일까
		LocalTime start = LocalTime.of(9, 0, 0);
		LocalTime now = LocalTime.now();
		
		Duration duration = Duration.between(start, now); // between()을 써서 간격을 얻어낼 수 있다
		
		System.out.println("수업 경과");
		System.out.println("시간 " + duration.toHours());
		System.out.println("분 " + duration.toMinutes() % 60);
		
		
	}

	private static void m6()
	{
		// 날짜간의 간격
		// 시각 - 시각 = 시간
		// - Date, Calendar 때는 getTimeInMilis()로 차이
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.of(2026, 6, 17);
		
		// 며칠이 남았는지 알고싶다
		Period remainDays = Period.between(start, end); // 리턴값은 Period
		System.out.println(remainDays); // P4M29D가 뭐야
		
		System.out.printf("%d년 %d개월 %d일\n", remainDays.getYears(), remainDays.getMonths(), remainDays.getDays());
		
	}

	private static void m5()
	{
		// 시각 비교
		// - Date, Calendar 때는 getTimeInMilis()로 우위 비교를 했다
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.of(2026, 1, 10);
		
		System.out.println(d1.isBefore(d2)); // d1 이 d2 보다 과거냐 ? -> 연산자로 치면 d1 < d2
		System.out.println(d1.isAfter(d2)); // d1 > d2
		System.out.println(d1.isEqual(d2)); // 같은날짜임?
		
		
	}

	private static void m4()
	{
		// 연산
		// Date, Calendar -> 가변
		// java.time -> 불변(읽기 전용)
		
		LocalDate today = LocalDate.now();
		
		LocalDate future = today.plusDays(100); // 100일 뒤
		
		LocalDate oneYear = today.plusYears(1); // today는 변하지 않았다
		
		System.out.println(today); // today는 불변이라 100일 못더함 그래서 새로만든 반환값을 더해줘야함
		System.out.println(future);
		System.out.println(oneYear);
		
		// 메서드 체이닝
		// 얻어낸 today에
		LocalDate someday = today.plusYears(1).minusMonths(2).plusDays(5);
		System.out.println(someday);
		
		
	}

	private static void m3()
	{
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.getYear());
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getHour());
		System.out.println(now.getMinute());
		System.out.println(now.getSecond());
		System.out.println(now.getNano());
		System.out.println(now.getDayOfWeek().getValue()); // 월(1) ~ 토(7)
		
		// 국제표준은 한주가 월요일부터 시작
		// 분명 캘린더는 일요일이 1
		// 미국 영향을 받았기 때문
		// 자바가 미국인들이 만든거라 한주의 시작이 일요일
		// 자바 타임이라는 패키지에서는 국제표준으로 돌아감
		
	}

	private static void m2()
	{
		// 시각 생성
		// 1. 현재 시각 만들기
		LocalDate d1 = LocalDate.now(); // 현재 날짜만
		LocalTime t1 = LocalTime.now(); // 현재 시간만
		LocalDateTime dt1 = LocalDateTime.now();
		
		System.out.println(d1);
		System.out.printf("%tF\n", d1);
		System.out.println(t1);
		
		// 2. 특정 시각 만들기
		LocalDate d2 = LocalDate.of(2026, 12, 25);
		LocalTime t2 = LocalTime.of(12, 3);
		LocalTime t3 = LocalTime.of(12, 3, 10);
		LocalDateTime dt2 = LocalDateTime.of(2026, 12, 25, 15, 30, 40);
		
		System.out.println(d2);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(dt2);
	}

	private static void m1()
	{
		// 기존 Date, Calendar 결함 -> 변경이 가능하다. -> 가변(Mutable) 객체이다.
		Calendar now = Calendar.getInstance();
		
		System.out.printf("%tF\n", now);
		
		now.add(Calendar.YEAR, 10); // 누군가가 10년을 늘려버렸다
		
		System.out.println("%tF\n"); // 10년 뒤로 고치는 순간 현재 시간은 날아가버린다
		
		// now는 now 대로 현재시간을 갖고 있고 반환값은 10년이 더해진 새로운 캘린더가 만들어진다
		
		// 월이 왜 0부터 시작할까? -> 월이라는 애는 서수의 의미가 아니라 선택, 즉 열거형이다
		// 날짜는 년, 일은 1부터 시작한다, 년하고 일은 서수(Index)이다, 순서를 매기는 값
		// 요일도 마찬가지로 순서를 세기 위한 숫자가 아니기 때문에 방 번호로 구분하기 때문에 0부터 나옴
		
		System.out.println(now.get(Calendar.MONTH));
		
		// 1월 2월 3월은 근대화 이후의 얘기
	}
}
