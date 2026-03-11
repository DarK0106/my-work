<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	/* 로그인부터 성공을 해야 아이디를 저장함 */
	String cbRemember = request.getParameter("cbRemember");
	
	// 로그인 처리
	if((id.equals("hong") && pw.equals("1234"))
		|| (id.equals("test") && pw.equals("1234"))) {
		// 로그인 성공
		// 인증 티켓(세션 or 쿠키)
		
		// 이걸 계속 들고 다니고 여기저기 쓰기 때문에
		// 의미 있는 값인 id를 넣음
		session.setAttribute("id", id);
		
		// 아이디 기억하기 O, X
		if (cbRemember != null && cbRemember.equals("y")) {
			// 아이디 기억하기
			// - 쿠키에 아이디 저장하기
			// - Servlet/JSP에서 쿠키 조작하기
			Cookie cookie = new Cookie("id", id); // 쿠키 생성(setCookie와 같은 역할)
			
			// 쿠키 만료 시간 지정
			cookie.setMaxAge(365 * 24 * 60 * 60);
			
			response.addCookie(cookie); // 서버 -> 쿠키 생성 -> 클라이언트
			
		} else {
			// 아이디 기억하기 X(체크 해제)
			// 서버가 클라이언트에 기억해놨던 아이디(쿠키)를 삭제하기
			// 아이디 기억하기 체크를 해제하면 더 이상 아이디(쿠키)가
			// 자동으로 저장되어있지 않음
			// 클라이언트에 있는 모든 쿠키가 항상 서버로 전송됨
			// 그래서 Cookie[] 배열을 돌려받음
			Cookie[] cookies = request.getCookies();
			
			// 돌려받은 쿠키 배열에서 id를 찾음
			for (int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("id")) {
					
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
			}
		}
		
		
	} else {
		// 로그인 실패
		
		
		
	}
	
	response.sendRedirect("ex23_cookie.jsp");

%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!--  -->
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>