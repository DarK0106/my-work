package com.test.todo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// 모든 데이터를 조작하는 담당자인 TodoDAO
// - JDBC 코드 작업 담당자
public class TodoDAO {
	private DBUtil util;
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	// 생성자
	public TodoDAO() {
		try {
			util = new DBUtil();
			conn = util.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 할일 등록하기
	public int add(String todo) {
		try {
			String sql = "insert into tblTodo(seq, todo, state, regdate)\r\n"
					+ "    values (seqTodo.nextval, ?, default, default)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, todo);

			// pstat.executeUpdate();
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<TodoDTO> list() {
		try {
			String sql = "select * from tblTodo order by seq desc";
			
			rs = stat.executeQuery(sql);
			
			// ResultSet을 돌려줘야하는데 원랜 알아먹지만 지금은 모른다고 가정
			// ResultSet을 다른 구조로 변환한 ArrayList<TodoDTO>
			
			// DTO: 레코드 1줄 역할
			// List<DTO>: 테이블 역할
			ArrayList<TodoDTO> list = new ArrayList<TodoDTO>();
			
			while (rs.next()) {
				// 레코드 1줄을 복사: TodoDTO 객체 1개
				TodoDTO dto = new TodoDTO();
				
				// 복사
				dto.setSeq(rs.getString("seq"));
				dto.setTodo(rs.getString("todo"));
				dto.setState(rs.getString("state"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int del(String seq) {
		// 반환값이 없는 쿼리인 del
		try {
			
			String sql = "delete from tblTodo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			// 반환값이 없는 쿼리라서
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
