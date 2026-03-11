package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private Connection conn;

	// 1. 기본 DB 접속 메서드 (localhost, 기본 계정)
	public Connection open() {
		// 코드가 중복되는 것을 막기 위해, 아래에 만든 오버로딩 메서드를 		재사용
		return open("localhost", "server", "java1234");
	}

	// 2. 서버 주소, 아이디, 비밀번호를 직접 지정해서 접속하는 	메서드(오버로딩)
	public Connection open(String server, String id, String pw) {
		// 전달받은 server 변수를 활용하여 완전한 URL을 조립
		// 오라클 기본 포트인 1521과 SID인 xe는 고정이라고 가정
		String url = "jdbc:oracle:thin:@" + server + ":1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 파라미터로 받은 id와 pw를 바로 사용
			conn = DriverManager.getConnection(url, id, pw);

			return conn;

		} catch (Exception e) {
			System.out.println("DB 연결 실패: " + server);
			e.printStackTrace();
		}

		// 연결 실패 시
		return null;
	}
}