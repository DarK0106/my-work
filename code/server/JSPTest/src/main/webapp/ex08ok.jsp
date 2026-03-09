<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String txt = request.getParameter("txt");
	String color = request.getParameter("color");
	String txtColor = request.getParameter("txtColor");
	String txtSize = request.getParameter("txtSize");
	int btnNum = Integer.parseInt(request.getParameter("btnNum"));
	String btnMarginLR = request.getParameter("btnMarginLR");
	String btnMarginTB = request.getParameter("btnMarginTB");
	String rb1 = request.getParameter("rb1");
	String isborder = request.getParameter("isborder");
	String borderwidth = request.getParameter("borderwidth");
	String bordercolor = request.getParameter("bordercolor");
	String borderstyle = request.getParameter("borderstyle");
	String borderradius = request.getParameter("borderradius");


%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		.button {
            padding-left: 0px;
        }
        .button::before {
            content: none;
        }
	</style>
</head>
<body>
	<!-- ex08ok.jsp -->
	<h1>결과</h1>
	<div>
	<!-- 만들어질 버튼 -->
	<% for(int i=0; i<btnNum; i++) { %>
    <button style="
        width: <%= width %>px; 
        height: <%= height %>px; 
        background-color: <%= color %>; 
        color: <%= txtColor %>; 
        font-size: <%= txtSize %>px; 
        margin: <%= btnMarginTB %>px <%= btnMarginLR %>px; 
        
        <% if (isborder.equals("y")) { %> 
            border: <%= borderwidth %>px <%= borderstyle %> <%= bordercolor %>; 
            border-radius: <%= borderradius %>px; 
        <% } else { %> 
            border: none; 
        <% } %>
    ">
    
    <%-- 영어 단어(value)에 맞춰서 이모지 출력 --%>
    <% if (rb1.equals("home")) { %> 🏚️
    <% } else if (rb1.equals("image")) { %> 📷
    <% } else if (rb1.equals("maps")) { %> 📍
    <% } else if (rb1.equals("github")) { %> 😱
    <% } else if (rb1.equals("link")) { %> 🔗
    <% } %>
    
    <%= txt %>
    </button>
<% } %>
	</div>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>