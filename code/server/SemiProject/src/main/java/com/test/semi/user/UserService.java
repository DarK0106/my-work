package com.test.semi.user;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.semi.model.UserDao;
import com.test.semi.model.UserDto;

// 서비스 객체
// 사용자(JSP 화면) ➔ 컨트롤러(Register.java) ➔ 서비스(UserService.java) ➔ DAO(UserDao.java) ➔ 서비스 ➔ 컨트롤러 ➔ 사용자(완료 화면)
public class UserService {

	// 컨트롤 객체 대신 회원가입 업무를 담당
	public int register(HttpServletRequest req) {
		try {
			// req.setCharacterEncoding("UTF-8");
			
			// 사진 파일을 서버 폴더에 저장
			// req 객체는 텍스트만 읽을 수 있음
			// cos.jar의 MultipartRequest 사용
			// req: 원본 요청 데이터
			/*
			req.getServletContext().getRealPath("/asset/pic"): 
			사진이 실제로 저장될 서버 컴퓨터의 폴더 경로
			*/
			/*
			new DefaultFileRenamePolicy(): 만약 '고양이.jpg'가 이미 폴더에 있는데 
			똑같은 이름으로 또 올라오면, 알아서 '고양이1.jpg'로 이름을 바꿔서 
			덮어쓰기를 방지해 주는 옵션
			*/
			MultipartRequest multi = new MultipartRequest(req, req.getServletContext().getRealPath("/asset/pic"),
					1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

//			System.out.println(req.getServletContext().getRealPath("/asset/pic"));
			
			// multi 객체에서 하나씩 꺼냄
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pw");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String attach = multi.getFilesystemName("attach");
			String intro = multi.getParameter("intro");

//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(attach);

			// 상자 안에 포장
			UserDto dto = new UserDto();

			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setEmail(email);
			dto.setPic(attach);
			dto.setIntro(intro);

			// 포장한걸 위임받은 DAO
			UserDao dao = new UserDao();

			int result = dao.register(dto);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			// 좀 더 다양한 상황을 고려해 이곳에도 alert 작성
//			resp.getWriter().print("<script>alert('failed');history.back();</script>");
//			resp.getWriter().close();
		}

		return 0;
	}

	// Login 서블릿이 id와 pw를 줄테니 인증 처리 좀 하라고 맡긴 것
	public UserDto login(UserDto dto) {
		// 인증 처리 어떻게함? -> DB 갔다 와야 함
		// 1. DB 작업: select
		// 2. 결과에 따른 인증 티켓 발급
		// DB 관련 일은 Dao에게 맡김
		// Dao가 보낸 결과를 컨트롤러에게 보냄
		UserDao dao = new UserDao();

		UserDto result = dao.login(dto);

		return result;

	}

	// Info 서블릿이 id를 줄테니 그 고객의 모든 내용을 돌려달라고 시킨 것
	public UserDto info(String id) {
		
		// Dao 고용
		UserDao dao = new UserDao();
		
		UserDto dto = dao.info(id);
		
		return dto;
	}

}
