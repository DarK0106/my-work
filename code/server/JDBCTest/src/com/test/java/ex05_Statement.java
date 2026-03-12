package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ex05_Statement {

	public static void main(String[] args) {

		// m1();
		// m2();
		// m3();
		// m4();
		m5();
	}

	private static void m5() {
		// hr계정을 가지고 tblInsa에 select문을 날리자
		// 1. 어떤 부서들이 있는지 출력
		// 2. 사용자가 부서명 중 한개를 입력(부서를 선택)
		// 3. 오라클이 해당 부서의 모든 직원 명단을 출력하는 프로그램
		// 4. 가져오는건 num name jikwi basicpay
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = util.open("localhost", "hr", "java1234");
			stat = conn.createStatement();
			
			//SQL
			String sql = "select distinct buseo from tblInsa order by buseo asc";
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[부서명]");
			System.out.println("========");
			
			while (rs.next()) {
				System.out.println(rs.getString("buseo"));
			}
			
			rs.close(); //부서 테이블 > 출력 > 임무 완수
			
			
			System.out.println();
			System.out.print("부서명: ");
			String buseo = scan.nextLine();
			
			
			//두번째 쿼리
			sql = "select num, name, jikwi, basicpay from tblInsa where buseo = '" 			+ buseo + "'";
			
			rs = stat.executeQuery(sql);

			System.out.println("[번호]\t[이름]\t[직위]\t[급여]");
			
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%,d원\r\n"
								, rs.getString("num")
								, rs.getString("name")
								, rs.getString("jikwi")
								, rs.getInt("basicpay"));				
			}
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	private static void m4() {
		// 다중 레코드
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL
			String sql = "select * from tblAddress";

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);

				int age = rs.getInt("age");
				System.out.println(age);

				String address = rs.getString("address");
				System.out.println(address);
				System.out.println();
			}

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		// 다중값 반환
		// 1행 N열
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL
			String sql = "select name from tblAddress where seq = 12";

			rs = stat.executeQuery(sql);

			// 결과셋에 레코드가 유효한지 검사
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");

				System.out.println(name);
				System.out.println(age);
				System.out.println(address);
			}

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		Scanner scan = new Scanner(System.in);

		System.out.print("번호: ");
		String seq = scan.nextLine();

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL
			String sql = "select name from tblAddress where seq = " + seq;

			rs = stat.executeQuery(sql);

			// 결과셋에 레코드가 유효한지 검사
			if (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			} else {
				System.out.println(seq + "번 데이터 없음.");
			}

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {
		// 반환값이 있는 쿼리, select
		// 결과셋이 단일값일 때
		// - 1행 1열
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = util.open();
			stat = conn.createStatement();

			// SQL 진행 ..
			String sql = "select count(*) as cnt from tblAddress";

			rs = stat.executeQuery(sql);
			
			// 커서 전진
			rs.next(); // 첫 번째 레코드를 가리키게 됨

			int count = rs.getInt("cnt"); // 컬럼명
			System.out.println(count);

			// 자원 해제
			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}