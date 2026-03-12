package com.test.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ex06_PreparedStatement {
	public static void main(String[] args) {
		// ex06_PreparedStatement
		
		String name = "엄준식";
		int age = 3;
		String gender = "m";
		String tel = "010-1234-5678";
		String address = "서울시 강동구 천호동";
		
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		//address = address.replace("'", "''");
		
		try {
			
			conn = util.open();
			
			// 1. Statement를 사용했을 때의 모습
			// 객체 만들기
//			stat = conn.createStatement();
//			
//			//SQL
//			String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextval, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
//			
//			System.out.println(stat.executeUpdate(sql));
			
			// 2. PreparedStatement
			// SQL의 데이터(값)을 미리 준비함
			// ?: 오라클의 매개변수 리터럴
			String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextval, ?, ?, ?, ?, ?, default)";
			
			// ? 때문에 쿼리를 먼저 줘야함
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, name);
			pstat.setInt(2, age);
			pstat.setString(3, gender);
			pstat.setString(4, tel);
			pstat.setString(5, address);	
			
			pstat.executeUpdate();
			
			//pstat.close();			
			//stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
