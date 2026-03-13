package com.test.java.model;

import com.test.library.BasicDao;

public class AuthDao {
	private DBUtil util;
	private Connection conn;
	private Statement stat;
	private Preparedstatement pstat;
	private ResultSet rs;
	
	public class AuthDao() extends BasicDao {
		public AuthDto login(AuthDto dto) {
			
			try {
				// 로그인?
				String sql = "select * from tblUser where id = ? and pw = ?";
				
				pstat = conn.preparedStatement();
				pstat = setString(1, dto.getId());
				
				rs = pstat.executeQuery();
				
				if (rs.next) {
					// 로그인 성공
					dto.setGrade(rs.getString("grade"));
					dto.setName(rs.getString("name"));
					
					return dto;
				} else {
					// 로그인 실패
					return null;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
}
