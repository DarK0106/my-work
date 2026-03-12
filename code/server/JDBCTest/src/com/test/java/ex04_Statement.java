package com.test.java;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class ex04_Statement {
	public static void main(String[] args) {
		// ex04_Statement
		/*
		 * Statement - 모든 SQL 실행
		 * 
		 * Statement 종류 1. Statement - 기본 - 정적 쿼리
		 * 
		 * 2. PreparedStatement - 특화 - 매개변수가 있는 쿼리
		 * 
		 * 3. CallableStatement - 특화 - PreparedStatement의 일종 - 프로시저 호출 특화
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
		m6();
	}

	private static void m6() {
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		// 여태까지 한건 모두 정적 쿼리
		// UI를 만들어서 사용자 테이터 입력을 받아 DB에 저장해보자
		Scanner scan = new Scanner(System.in);
		
		// 자바(입력) -> 오라클(저장)
		// String	  -> varchar2
		// String	  -> number
		// 언어가 다르면 자료형은 아무 의미 없다
		// 그럼 어떻게 데이터를 넘김?
		// 자바와 오라클은 대화할때 SQL이라는 언어를 쓴다
		
		// varchar2(30)
		System.out.println("이름: ");
		String name = scan.nextLine();
		
		// number(3)
		System.out.println("나이: ");
		String age = scan.nextLine();
		
		// 나중에 쿼리만 잘 하면 됨
		
		System.out.println("성별(m, f): ");
		String gender = scan.nextLine();
		
		System.out.println("전화번호: ");
		String tel = scan.nextLine();
		
		System.out.println("주소: ");
		String address = scan.nextLine();
		
		// 입력받은 데이터를 ''로 묶어서 작성
		// ''로 묶으면 오라클이 문자열로 구별함
		// 나이는 문자열이 아니니 ''로 묶지 않음
		String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextval, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
		
		try {
			conn = util.open();
			stat = conn.createStatement();

			// 적용된 행의 개수
			int result = stat.executeUpdate(sql);

			System.out.println(result);

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m5() {
		// 반환값이 없는 쿼리
		// - DML -> insert, update, delete
		// - DDL
		// - DCL
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL 진행
			String sql = """
						create table tblAddress2 (
					    seq number PRIMARY KEY,
					    name varchar2(30) NOT NULL,
					    age number(3) NOT NULL CHECK ( age BETWEEN 0 and 120),
					    gender char(1) NOT NULL CHECK ( gender in('m', 'f') ),
					    tel varchar2(15) NOT NULL ,
					    address varchar2(300) NOT NULL ,
					    regdate date DEFAULT SYSDATE NOT NULL
					)
						""";

			// 적용된 행의 개수
			int result = stat.executeUpdate(sql);

			System.out.println(result);

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m4() {
		// 삭제 구문
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL 진행
			String sql = "delete from tblAddress";
			int result = stat.executeUpdate(sql);

			System.out.println(result);

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m3() {
		// 업데이트 구문
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL 진행
			String sql = "update tblAddress set age = age + 1";
			int result = stat.executeUpdate(sql);

			System.out.println(result);

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m2() {

		// 자동 커밋 끄기
		// 두 번의 쿼리 중 둘 다 성공 / 하나는 실패
		// 트랜잭션 처리 연습
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;

		try {

			conn = util.open(false);

			stat = conn.createStatement();

			if (!conn.isClosed()) {

				// 성공
				String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextval, '강아지', 20, 'm', '010-1234-5678', '서울시 강남구 대치동', default)";

				int result = stat.executeUpdate(sql);

				if (result == 1) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}

				// 성공 or 실패
				sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextval, '고양이', 20, 'm', '010-1234-5678', '서울시 강남구 대치동', default)";

				result = stat.executeUpdate(sql);

				if (result == 1) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}

				// 둘다 성공 시 커밋
				conn.commit();

				stat.close();
				conn.close();

			} else {
				System.out.println("DB 접속 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();

			// 둘 중 하나 실패 시 롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	private static void m1() {
		// (*중요) JDBC는 자동 커밋이 기본 설정이다.
		// 1. DB 연결
		// 2. SQL 실행
		// 3. DB 종료

		// 1. DB 연결
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;

		try {
			conn = util.open();

			// 2. SQL 실행
			stat = conn.createStatement();

			if (!conn.isClosed()) {
				// 자바는 SQL이 뭔지 모른다
				// 자기가 모르는 언어는 무조건 문자열 취급한다
				// 즉 쿼리를 문자열로 짠다

				// Statement
				// Statement는 한 번에 한개의 SQL만 실행 가능하다
				String sql = "INSERT INTO tblAddress (seq, name, age, gender, tel, address, regdate)\r\n"
						+ "VALUES (seqAddress.nextval, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 대치동', DEFAULT)";

				// 쿼리 실행
				// - 반환값 O: ResultSet executeQuery()
				// - 반환값 X: void executeUpdate()

				int result = stat.executeUpdate(sql); // Ctrl + Enter 역할

				if (result == 1) {
					// 글쓰기 성공
					System.out.println("성공");
				} else {
					// 글쓰기 실패
					System.out.println("실패");
				}

				// 작업이 끝나면 반드시 자원 해제
				// XE 버전이 무료다보니 메모리가 1GB 넘어가는 순간 다운됨
				stat.close();
				conn.close();

			} else {
				System.out.println("DB 접속 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
