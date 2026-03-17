package com.test.semi.model;

import java.util.ArrayList;

import com.test.library.BasicDao;

public class BoardDao extends BasicDao {

	public int add(BoardDto dto) {

		try {

			String sql = "insert into tblBoard (seq, subject, content, id, regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// DAO에서는 데이터 가공 최대한 금지
	public ArrayList<BoardDto> list() {
		try {
			String sql = "select * from vwBoard";

			rs = stat.executeQuery(sql);

			ArrayList<BoardDto> list = new ArrayList<BoardDto>();

			// rs -> 복사 -> list
			while (rs.next()) {
				// 레코드 1줄을 DTO 1개에 옮겨담는 작업
				BoardDto dto = new BoardDto();

				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));

				dto.setName(rs.getString("name"));
				dto.setIsnew(rs.getDouble("isnew"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public BoardDto get(String seq) {

		try {

			String sql = "select a.*, (select name from TBLUSER where id = a.id) as name from tblBoard a where seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			// rs(ResultSet)의 레코드 한개를 DTO 1개로 바꾸자
			if (rs.next()) {
				BoardDto dto = new BoardDto();

				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));

				dto.setName(rs.getString("name"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void increaseReadcount(String seq) {
		try {
			String sql = "update tblBoard set readcount = readcount + 1 where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int edit(BoardDto dto) {

		try {
			String sql = "update tblBoard set subject = ?, content =? where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int del(String seq) {

		try {
			String sql = "delete from tblBoard where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
