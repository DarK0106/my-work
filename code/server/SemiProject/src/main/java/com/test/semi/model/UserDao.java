package com.test.semi.model;

import com.test.library.BasicDao;

public class UserDao extends BasicDao {

	public int register(UserDto dto) {
		try {
			
			String sql = "insert into tblUser(id, pw, name, email, lv, pic, intro, regdate, ing) values (?, ?, ?, ?, 1, ?, ?, default, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getPic());
			pstat.setString(6, dto.getIntro());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public UserDto login(UserDto dto) {
		try {
			
			String sql = "select * from tblUser " + "where id = ? and pw = ? and ing = 1";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			// 커서를 전진시켰을 때
			if (rs.next()) {
				// 아이디를 발견했다면 세션에 담을 데이터를 반환
				dto.setName(rs.getString("name"));
				dto.setLv(rs.getString("lv"));
				
				return dto;
				
			} else {
				// 아이디를 발견하지 못했다면
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public UserDto info(String id) {
		
		try {
			String sql = "select * from tblUser where id = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				UserDto result = new UserDto();
				
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setLv(rs.getString("lv"));
				result.setPic(rs.getString("pic"));
				result.setIntro(rs.getString("intro"));
				result.setRegdate(rs.getString("regdate"));
				
				return result;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
