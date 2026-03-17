package com.test.semi.board;

import java.util.ArrayList;
import java.util.Calendar;
import javax.security.auth.Subject;

import com.test.semi.model.BoardDao;
import com.test.semi.model.BoardDto;

// DAO, 컨트롤러가 하지 않는 나머지 일을 담당하는 서비스 객체
// 주로 데이터 조작 담당
public class BoardService {

	public int add(BoardDto dto) {
		BoardDao dao = new BoardDao();

		return dao.add(dto);
	}

	public ArrayList<BoardDto> list() {

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.list();

		Calendar now = Calendar.getInstance();
		String nowDate = String.format("%tF", now); // 2026-03-17

		// 데이터 조작(가공)
		for (BoardDto dto : list) {
			// 날짜 자르기 -> 오늘 작성한 글인지 구분하여
			// 오늘 작성한 글은 시/분/초를 출력
			String regdate = dto.getRegdate();

			if (regdate.startsWith(nowDate)) {
				// 오늘 쓴 글
				// 2026-03-17 <- 여기까지가 9번째자리고
				// 12:17:34 <- 이게 11번째부터니까
				// 시/분/초 를 출력하려면 11번째부터
				regdate = regdate.substring(11);

			} else {
				// 옛날에 쓴 글
				regdate = regdate.substring(0, 10);

			}

			dto.setRegdate(regdate);
			
			// 제목에 HTML 태그 비활성화
			
			
			// 너무 긴 제목은 제목을 자르는 작업 수행
			String subject = dto.getSubject();

			if (subject.length() > 15) {
				subject = subject.substring(0, 15) + "..";
			}

			dto.setSubject(subject);

		} // for

		return list;
	}

	// 글 번호를 가져오기
	public BoardDto get(String seq) {

		BoardDao dao = new BoardDao();

		BoardDto dto = dao.get(seq);

		// 데이터 가공
		// 개행 문자 처리
		String content = dto.getContent();

		if (content != null) {
			content = content.replace("\r\n", "<br>");
			dto.setContent(content);
		}

		return dto;

	}

	public void increaseReadcount(String seq) {

		BoardDao dao = new BoardDao();
		
		dao.increaseReadcount(seq);
	}

	public int edit(BoardDto dto) {
		BoardDao dao = new BoardDao();
		
		return dao.edit(dto);
	}

	public int del(String seq) {

		BoardDao dao = new BoardDao();
		
		return dao.del(seq);
		
	}

}
