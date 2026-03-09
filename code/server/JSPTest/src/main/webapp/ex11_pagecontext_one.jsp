<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ex11_pagecontext_one.jsp
	
	// - response.sendRedirect("URL")
	// - pageContext.forward("URL")
	
	// 우리가 페이지 이동할때 그냥 이동하는게 아니고 데이터를 전달하면서 이동하는 일이 많다
	// A 페이지에 있는 데이터를 B 페이지에서 함부로 접근할 수 없다
	// 1. 어떻게든 데이터에 접근하려고 만든게 form 태그
	// 2. Query String도 데이터를 넘기기 위해 만들어졌음
	// 3. Server 기술로 페이지 간 데이터 전달할 수 있는 방법
	// 	- pageContext.forward("URL")
	//	- pageContext는 그 페이지의 데이터를 관리하기 위한 내장 객체
	//	- 그래서 페이지를 이동하면 pageContext는 사라진다
	//	- 페이지 이동 + request 데이터 전달하기 위해 사용(*중요)
	// forward로 인한 요청은 한번이기 때문에 request는 계속 살아남는다
	
	int a = 10;
	int b = 20;
	// a, b를 어떻게든 ex11_pagecontext_two.jsp에 전달하고 싶음
	// 근데 a, b는 지역변수임 메서드 끝나면 죽음
	pageContext.setAttribute("a", a);
	request.setAttribute("b", b);
	// 이러고 response로 이동
	// 전달이 안됐음
	// pageContext로 이동해보자
	// a는 못살렸지만 b는 살림
	
	/* 
	JSP를 호출하기 전에 pageContext와 request 가 만들어진다? 
	방금 만든 pageContext에 a를 넣고 request에 b를 넣었음
	JSP 실행이 끝나는 순간 pageContext와 request, response의 생명주기가 끝나 사라진다
	그래서 a랑 b도 같이 사라짐
	두번째 페이지 부르러 가는데 JSP 실행하기 직전에 또 다른 pageContext와 request, response가 만들어진다
	ex11_pagecontext_two.jsp를 쭉쭉 읽다가 보니까 pageContext.getAttribute("a") 이런게 있음
	pageContext.getAttribute("a")에서의 pageContext는
	아까 죽어버린 pageContext가 아닌 새로 만들어진 pageContext이다.
	*/
	
	/*
	pageContext.forward("ex11_pagecontext_two.jsp"); 로 이동했을 경우
	pageContext는 죽지만 request와 response는 생존한다
	pageContext가 죽으면서 a도 사라진다
	하지만 request에 있던 b는 살아있어서 두번째 페이지에서 출력된다
	
	
	*/
	
	
	// response.sendRedirect("ex11_pagecontext_two.jsp");
	// 돌려줄 HTML 페이지에 location.href = 'ex11_pagecontext_two.jsp'; 코드를 추가한다
	// 자바스크립트 코드를 생성해서 클라이언트쪽으로갔다가 서버쪽으로 갔다?
	// 클라이언트쪽에서 이동했다
	// 주소가 다르다?
			
	// 브라우저에 1번페이지를 요청 -> 1번페이지 찾음 -> 지금까지 작업했던 1번페이지를 소각(버림)시키고
	// 두번째 페이지로 가서 두번째페이지를 실행시켜서 그걸 다시 톰캣에 돌려준다?
	pageContext.forward("ex11_pagecontext_two.jsp");

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
	<!-- ex11_pagecontext_one -->
	<h1>첫번째 페이지</h1>
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>