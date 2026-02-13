package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class Ex22_DateTime
{
	public static void main(String[] args) throws IOException
	{
		// Ex22_DateTime.java
		/*
		 * 
		 * 날짜와 시간을 다루는 자료형
		 * 1. Date 클래스
		 * 2. Calendar 클래스
		 * --------------------------------------- 위에는 옛날거 밑에는 새거
		 * 3. java.time 패키지에서의 다수의 클래스
		 * 
		 * 시간, 시각
		 * - 개강일: 2025년 12월 29일 오전 9시 00분 00초 -> 시각
		 * - 하루 수업 시간: 8시간 -> 시간
		 * 
		 * 날짜/ 시간 -> 연산
		 * 
		 * 2026년 01월 05일 15시 14분 51초
		 * -
		 * 2025년 12월 29일 09시 00분 00초
		 * 
		 * 시각 + 시각 = 보통 안함
		 * 시각 - 시각 = 엄청 자주 함 -> 결과가 시간으로 나온다
		 * 시각 * 시각 = 안함
		 * 시각 / 시각 = 안함
		 * 
		 * 시간 + 시간 = 가능, 결과가 시간
		 * 시간 - 시간 = 가능, 결과가 시간
		 * 시간 * 시간 = 안함
		 * 시간 / 시간 = 안함
		 * 
		 * 2026년 01월 05일 15시 14분 51초 + 2시간 = 
		 * 
		 * 시각 + 시간 = 가능, 결과가 시각
		 * 시각 - 시간 = 가능, 결과가 시각
		 */
		
		// m1(); 
		// Ctrl + 1, Enter 하면 메서드 바로 생성 가능
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		m8();
		
	} // main

	private static void m8()
	{
		// 연산
		// 시간 + 시간 = 시간
		// 시간 - 시간 = 시간
		
		// 2시간 + 1시간 <- 캘린더로는 표현이 불가
		int h1 = 2;
		int h2 = 1;
		System.out.println(h1 + h2);
		
		// 2시간 30 분 + 1시간 10분
		h1 = 2;
		int m1 = 30;
		h2 = 1;
		int m2 = 10;
		System.out.println((h1 + h2) + "시간" + (m1 + m2) + "분");
		
		// 2시간 30분 + 40분 = 2시간 70분 -> 3시간 10분 <- 어떻게 바꿈 ? 
		h1 = 2;
		m1 = 30;
		m1 += 40;
		
		h1 = h1 + (m1 / 60);
		m1 = m1 % 60;
		System.out.printf("%d시간 %d분\r\n", h1, m1);
		
	}

	private static void m7()
	{
		// 연산
		// 시각 - 시간 = 시간
		
		// 요구사항) 내가 태어나서 총 며칠을 살아왔는지?
		// 현재 - 생일 = 살아온 기간(일 단위로 알고 싶다)
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(2001, 0, 6); // 생일, 1월이 0인 것 주의
		
		// The operator - is undefined for the argument type(s) java.util.Calendar, java.util.Calendar
		// System.out.println(now - birthday);
		// 캘린더끼리의 연산은 어떻게 할 지 약속이 되어있지 않다
		// now랑 birthday가 가리키는 시간 - 시간 이 아니고 now랑 birthday에 있는 주소값 - 주소값을 하려고 시도함
		// *** 메모리 주소는 연산의 대상이 될 수 없다
		// *** 모든 참조형은 산술 연산이 불가능하다.
		// *** 모든 지역 변수는 Stack에 생성된다
		// int num = 10; <- 값형 / String str = "홍길동"; <- 참조형
		// 클래스 = 참조형
		/*
		 *
		 * 2026년 1월 6일 9시 30분 20초
		 * -
		 * 2001년 1월 6일 5시 30분 00초
		 * 
		 * 기준점
		 * -1970년 1월 1일 0시 0분 0초를 기준점으로 하기로 약속했음
		 * 이때 Unix라는 운영체제가 만들어짐, 그래서 Unix Time, Epoch Time으로 부름
		 * 자바도 저 시각을 기준점으로 날짜를 계산함
		 *
		 */
		
		// 1970년 1월 1일 0시 0분 0초로부터 1767660159844ms가 지났다
		System.out.println(now.getTimeInMillis());
		System.out.println(birthday.getTimeInMillis());
		
		// 태어나서부터 지금까지 살아온 일수
		// 시간의 단위는 최대 Hour 까지(Date 까지도 가능)
		System.out.println((now.getTimeInMillis() - birthday.getTimeInMillis()) / 1000 / 60 / 60 / 24); // 9130일 살았다
	}

	private static void m6()
	{
		Calendar now = Calendar.getInstance();
		System.out.printf("%tF %tT\r\n",now, now);
		
		//+- 시간
		
		// 30분 뒤가 궁금하다
		now.add(Calendar.MINUTE, 30);
		System.out.printf("%tF %tT\r\n",now, now);
		
		// 3시간 뒤
		now.add(Calendar.HOUR, 3);
		System.out.printf("%tF %tT\r\n",now, now);
		
		// 5일 뒤
		now.add(Calendar.DATE, 5);
		System.out.printf("%tF %tT\r\n",now, now);
		
		// 1달 뒤
		now.add(Calendar.MONTH, 1);
		System.out.printf("%tF %tT\r\n",now, now);
		
	}

	private static void m5() throws IOException
	{
		// 신생아가 태어난 년월일시분초 입력을 받으면
		// 100일이 언제고
		// 첫돌이 언젠지 알려주는 프로그램
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("생일 입력(년):"); // 2026-01-03 17:30:00, 2026년 1월 3일 5시 30분, 2026/01/03 <- 입력할 수 있는 형태가 너무 다양함
		String input1 = reader.readLine();
		int year = Integer.parseInt(input1); // "2026"을 실제 숫자 2026으로 바뀜
		
		System.out.println("생일 입력(월):");
		String input2 = reader.readLine();
		int month = Integer.parseInt(input2) -1;
		
		System.out.println("생일 입력(일):");
		String input3 = reader.readLine();
		int date = Integer.parseInt(input3);
		
		System.out.println("생일 입력(시):");
		String input4 = reader.readLine();
		int hour = Integer.parseInt(input4);
		
		System.out.println("생일 입력(분):");
		String input5 = reader.readLine();
		int minute = Integer.parseInt(input5);
		
		System.out.println("생일 입력(초):");
		String input6 = reader.readLine();
		int second = Integer.parseInt(input6);
		
		Calendar birthday = Calendar.getInstance();
		birthday.set(year, month, date, hour, minute, second);
		System.out.printf("%tF %tT\r\n", birthday, birthday);
		
		// 백일?
		birthday.add(Calendar.DATE, 99);
		System.out.printf("백일 기념일: %tF %tT\r\n", birthday, birthday);
		
		
		// 첫돌?
		birthday.add(Calendar.DATE, -99); // birthday가 누적이 되기 때문에 99일을 다시 뺌
		birthday.add(Calendar.YEAR, 1);
		System.out.printf("첫돌: %tF %tT\r\n", birthday, birthday);
		
	}

	private static void m4()
	{
		// 연산
		// 시각 + 시간
		// 시각 - 시간
		
		// 오늘 커플이 된 남녀 -> 100일 기념일이 언제일까?
		// 오늘이라는 '시각'에다 100일이라는 '시간'을 더하면 기념일이라는 '시각'이 나온다
		Calendar now = Calendar.getInstance(); // 오늘
		
		System.out.printf("1일차: %tF \r\n", now);
		
		// now + 99일
		now.add(Calendar.DATE, 99); // now가 100일 기념일로 수정됨
		System.out.printf("100일차: %tF \r\n", now);
		
		// 변수 now에 덮어쓰기(초기화) = 현재 시각
		now = Calendar.getInstance();
		
		// 1주일 후?
		now.add(Calendar.DATE, 7);
		System.out.printf("일주일 후: %tF \r\n", now);
		
		now = Calendar.getInstance();
		
		// 3일 전?
		now.add(Calendar.DATE, -3);
		System.out.printf("3일 전: %tF \r\n", now);
		
		now = Calendar.getInstance();
		
		// 3분 뒤?
		now.add(Calendar.MINUTE, 3);
		System.out.printf("컵라면 먹을 시간: %tT \r\n", now);
	}

	private static void m3()
	{
		// 특정 시각 만들기
		// m2() -> 현재 시각 만들기
		// m3() -> 특정 시각 만들기
		
		// Calendar 클래스 메서드
		// 1. int get(int): 읽기
		// 2. void set(오버로딩): 쓰기
		
		// 올해 크리스마스가 되는 시간을 출력하고 싶다
		Calendar christmas = Calendar.getInstance(); // 현재 시각
		
		System.out.printf("%tF %tT \r\n", christmas, christmas);
		
		// 내가 원하는 날짜로 고치자, 수정(덮어쓰기)
		christmas.set(Calendar.MONTH, 11);
		christmas.set(Calendar.DATE, 25);
		christmas.set(Calendar.HOUR_OF_DAY, 0);
		christmas.set(Calendar.MINUTE, 0);
		christmas.set(Calendar.SECOND, 0);
		System.out.printf("%tF %tT \r\n", christmas, christmas);
		
		// 내 생일
		Calendar birthday = Calendar.getInstance();
		
		// birthday.set(2001, 1, 6);
		birthday.set(2001, 1, 6, 15, 30, 0); // 년월일 시분초 다 수정 가능
		System.out.printf("%tF %tT\r\n", birthday, birthday);
	}

	private static void m2()
	{
		// TODO Auto-generated method stub <- stub은 코드를 말한다
		// TODO 키워드는 나중에 해야 할 일을 잊지 않도록 하기 위해 쓴다
		// Window -> Show View -> Tasks 에서 볼 수 있음. 더블클릭하면 바로 이동
		
		
		// Date, Calendar -> 현재 컴퓨터의 메인보드로부터 가져온다. 메인보드에는 수은전지로 돌아가는 시계가 있음.
		// Calendar 클래스 + 현재 시각
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		/* 출력 결과 ->
		 * java.util.GregorianCalendar[time=1767595700551,areFieldsSet=true,areAllFieldsSet=true,
		 * lenient=true,zone=sun.util.calendar.ZoneInfo[id="GMT+09:00",offset=32400000,dstSavings=0,useDaylight=false,transitions=0,
		 * lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2026,MONTH=0,WEEK_OF_YEAR=2,WEEK_OF_MONTH=2,DAY_OF_MONTH=5,
		 * DAY_OF_YEAR=5,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=48,SECOND=20,MILLISECOND=551,ZONE_OFFSET=32400000,DST_OFFSET=0]
		 */
		
		// 캘린더 객체 -> 원하는 항목을 추출
		// - int get(int) (int)<- 인자값 하나를 주면 int<- 반환값 하나를 돌려받는 메서드 get
		
		System.out.println(now.get(0));
		System.out.println(now.get(1));
		System.out.println(now.get(2));
		System.out.println(now.get(3));
		
		int year = 1;
		System.out.println(now.get(year));
		
		System.out.println(Calendar.YEAR); // 숫자 1이 담겨있는 YEAR를 자바가 제공해두었음
		System.out.println(now.get(Calendar.YEAR)); // 2026 -> 년
		System.out.println(now.get(Calendar.MONTH)); // 0 -> java는 월을 셀 때 0부터 센다 그래서 1월인데 0으로 출력
		System.out.println(now.get(Calendar.DATE)); // 5 -> 일
		System.out.println(now.get(Calendar.HOUR)); // 오후 4시 -> 시간(12H)
		System.out.println(now.get(Calendar.HOUR_OF_DAY)); // 16시 -> 시간(24시간 표기법) <- 업무에선 이게 기본
		System.out.println(now.get(Calendar.MINUTE)); // 9분
		System.out.println(now.get(Calendar.SECOND)); // 51초
		System.out.println(now.get(Calendar.MILLISECOND)); // .645 -> 밀리초
		System.out.println(now.get(Calendar.AM_PM)); // 1 -> 오전은 0, 오후는 1, 12시간 표기법을 쓸 때 같이 씀
		System.out.println(now.get(Calendar.DAY_OF_YEAR)); // 올해 들어서 오늘이 몇일째인지, 일(년)
		System.out.println(now.get(Calendar.DAY_OF_MONTH)); // 이번달 들어서 몇일째인지, 일(월)
		System.out.println(now.get(Calendar.DAY_OF_WEEK)); // 이번 주 들어서 몇일째인지, 일(주), 요일, 일요일이 1이고 토요일이 7이다. 
		// <- 메서드가 모두 같은 메서드라 int 밖에 못 씀
		System.out.println(now.get(Calendar.WEEK_OF_MONTH)); // 올해 들어 몇주차인가? 주(년)
		System.out.println(now.get(Calendar.WEEK_OF_YEAR)); // 이번 달 들어서 몇주차인가? 주(월)
		// 달력의 주차를 계산할 때 목요일을 기준으로 삼아 해당 월의 첫 주(1주차)를 정하는 방식
		
		// 요구사항) 오늘의 날짜를 출력하시오.
		
		System.out.printf("오늘은 %d년 %d월 %d일입니다.\r\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		// 요구사항) 오늘의 날짜를 출력하시오. 한 자리 숫자가 나올 때 십의 자리에 0이 출력되어야 함.
		
		int month = now.get(Calendar.MONTH) + 1;
		
		System.out.printf("오늘은 %d년 %s월 %d일입니다.\r\n", now.get(Calendar.YEAR), month < 10 ? "0" + month : "" + month, now.get(Calendar.DATE));
		
		// 요구사항) 오늘의 날짜를 출력하시오.
		
		System.out.printf("오늘은 %d년 %02d월 %02d일입니다.\r\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		// 요구사항) "지금은 오후 4시 38분 14초입니다."
		System.out.printf("지금은 %s %02d시 %02d분 %02d초입니다.\r\n", now.get(Calendar.AM_PM) == 0 ? "오전":"오후", now.get(Calendar.HOUR), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
		
		// printf() -> 형식 문자(날짜 / 시간 관련)
		System.out.printf("%tF\r\n", now); // 2026-01-05 출력
		System.out.printf("%tT\r\n", now); // 16:44:34 출력
		System.out.printf("%tA\r\n", now); // 월요일 출력(운영 체제 언어 설정을 따라감)
	}

	private static void m1()
	{
		// Date 클래스
		Date now = new Date(); // 현재 시각
		
		System.out.println(now);
		
		// ~ 중간 코드 ~
		
		Date now2 = new Date(); // 시간이 흘러가면 now랑 시간이 다르게 출력됨
		
		System.out.println(now2);
	}
}
