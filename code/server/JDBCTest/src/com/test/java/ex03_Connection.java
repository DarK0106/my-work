package com.test.java;

import java.sql.Connection;

public class ex03_Connection {
	public static void main(String[] args) {
		// ex03_Connection.java
		DBUtil util = new DBUtil();
		Connection conn = null;
		
		try {
			
			// DB에 연결
			conn = util.open();			
			// conn = util.open("localhost", "hr", "java1234");			
			System.out.println(conn.isClosed());
			
			// 다 썼으니 연결 종료
			conn.close();
			System.out.println(conn.isClosed());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
