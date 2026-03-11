package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class ex02_connection {
	public static void main(String[] args) {
		// Ex02_Connection.java
		
		Connection conn = null;
		
		// 연결 문자열(Connection String)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "server";
		String pw = "java1234";
		
		try {
			// 드라이버 로딩
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 접속(JDBC)
			// - Oracle
			// - MySQL
			// - MS-SQL
			// - DB2
			
			// 이 객체가 만들어진 순간 DB에 접속됨
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println(conn.isClosed());
			
			// SQL 실행
			
			// 접속 종료
			// 연결을 했으면 끊어야함
			conn.close();
			System.out.println(conn.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
