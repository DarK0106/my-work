package com.test.semi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.test.semi.model.BoardDao;
import com.test.semi.model.BoardDto;

public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("인증 필터 동작");

		// 권한 체크
		// - 익명 사용자가 URL을 통해 직접 접근하는 것을 방지
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.getAttribute("auth") == null) {
			// System.out.println("익명 사용자");

			System.out.println(req.getRequestURI());

			// URL을 직접 입력해서 접속을 시도하는 경우
			if (req.getRequestURI().endsWith("add.do") || req.getRequestURI().endsWith("edit.do")
					|| req.getRequestURI().endsWith("del.do")) {
				// 쫓아내야 함
				response.getWriter().print("<script>alert('not allowed');history.back();</script>");
				response.getWriter().close();
				return;
			}

		} else {
			// System.out.println("인증 사용자");

			// 수정하기, 삭제하기 -> 작성자 본인만 접속할 수 있게
			if (req.getRequestURI().endsWith("edit.do") || req.getRequestURI().endsWith("del.do")) {

				// 현재 글 + 본인 글?
				// 1. 현재 글 번호?
				// System.out.println(req.getRequestURI());
				// System.out.println(req.getQueryString());
				System.out.println(req.getParameter("seq"));
				
				String seq = req.getParameter("seq");
				
				BoardDao dao = new BoardDao();
				BoardDto dto = dao.get(seq);

				// dto.getId() <- 현재 글쓴이의 아이디
				// session.getAttribute("auth"); <- 현재 접속자의 아이디

				if (!session.getAttribute("auth").toString().equals(dto.getId())) {
					response.getWriter().print("<script>alert('not allowed');history.back();</script>");
					response.getWriter().close();
					return;
				}

			}

		}

		chain.doFilter(request, response);
	}
}
