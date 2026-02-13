package com.test.java.dummy;

import java.util.Random;

public class Test
{
	
	public static void main(String[] args)
	{
		/*
		 * 프로젝트 진행 -> 데이터 필요
		 * 테이블 수준으로 구분
		 * - 기초 데이터(강의실, 선생님, 행정실 ..) + 운영 데이터(개강 관련 정보, 학생 정보 ...)
		 * - 기초 데이터는 미리 준비
		 * - 운영 데이터도 미리 준비
		 * 
		 * - 최소 강의중인 강의실 데이터가 6 개 이상(6개 반)은 있어야 함 -> 한 반당 인원수 25~30명
		 * 수료한 반도 4~5개
		 * 학생 수 대략 300여명
		 * 
		 * 더미 데이터 만드는 법?
		 * 1. 어디서 긁어오기
		 * 	a. 사람이 직접 함
		 * 	b. 크롤링 하는 프로그램
		 * 
		 * 2. 더미 데이터를 제작하는 프로그램을 만들기
		 * 	a. 자바
		 * 
		 * 3. AI 로 만들기
		 * 	a. LLM -> 가상 데이터를 만들자 -> 품질이 낮다?
		 * 		ex) 학생 100명 중복되지 않게 만들어줘?
		 *
		 * 학생 정보 * 100명
		 * - tblStudent 테이블에 추가하기
		 * 
		 *
		 *
		 */
		
		// - Math.random() -> 0.0~0.99
		Random rnd = new Random();
		
		System.out.println(rnd.nextDouble());
		System.out.println(rnd.nextInt(10)); // 0~9 정수 하나를 반환
		// Integer.parseInt(Math.random() * 10)
		System.out.println(rnd.nextBoolean()); // 0,1 -> false, true 
		
		String[] name1 = {"김", "이", "박", "최", "정", "홍", "진", "송", "하", "민", "시"};
		String[] name2 = {"길", "동", "재", "석", "철", "수", "영", "희", "형", "시", "충"};
		
		String[] address1 = {"서울시", "인천시", "수원시", "부산시", "제주시"};
		String[] address2 = {"강남구", "강서구", "강북구", "강동구", "중구"};
		String[] address3 = {"역삼동", "대치동", "방배동", "압구정동", "길동"};
		
		// 학생 번호, 이름, 성별(m, f), 주소
		for (int i =1; i <= 100; i++)
		{
			String gender ="";
			
			if(rnd.nextBoolean())
			{
				gender = "m";
				
			}
			else
			{
				gender = "f";
			}
			
			String name =name1[rnd.nextInt(name1.length)] + name2[rnd.nextInt(name2.length)] + name2[rnd.nextInt(name2.length)];
			
			String address = address1[rnd.nextInt(address1.length)] + (" ") + address2[rnd.nextInt(address2.length)] + (" ") + address3[rnd.nextInt(address3.length)] + (" ") + (rnd.nextInt(200) + 100) + "번지";
			
			String sql = String.format("insert into tblStudent values (%d, '%s', '%s', '%s');", i, name, gender, address);
			
			System.out.println(sql);
		}
	}
	/*
	 * 
	 *	학생 -> 300명
	 *	- 대부분 데이터 -> 검증 필요 X
	 *	- 일부 데이터(예: 이메일) -> 유효한 데이터를 넣어야 한다?
	 *
	 *  5명만 실제 이메일 주소로 생성
	 *  분량 용도의 대부분의 데이터 -> 더미 데이터
	 *  실제 테스트용 실제 데이터 -> 테스트 데이터
	 *  더미 데이터 95% 에 테스트 데이터 5%
	 *  테스트 데이터 5%는 팀원과 의논하에 실제 데이터를 넣어야함
	 * 
	 * 
	 */

}
