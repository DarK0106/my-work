<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
    <!-- customlogin.jsp -->
    <!-- 헤더 불러오기 -->
    <%@include file="/WEB-INF/views/inc/header.jsp" %>
    
    <h2>Custom Login Page</h2>
    <!-- 스프링이 이미 action="/java/login"라는 이름으로 만들어놔서 -->
    <!-- 우리도 이거에 따라서 만들어야 스프링이 이걸 로그인이라고 인식함 -->
    <form method="POST" action="/java/login">
    <table class="vertical content">
        <tr>
            <th>아이디</th>
            <!-- 스프링이 이미 name="username"라는 이름으로 만들어놔서 -->
            <!-- 우리도 이거에 따라서 만들어야 스프링이 이걸 아이디라고 인식함 -->
            <td><input type="text" name="username" required></td>
        </tr>
        <tr>
            <th>암호</th>
            <!-- 스프링이 이미 name="password"라는 이름으로 만들어놔서 -->
            <!-- 우리도 이거에 따라서 만들어야 스프링이 이걸 비밀번호라고 인식함 -->
            <td><input type="password" name="password" required></td>
        </tr>
    </table>
    <div>
        <button class="in">로그인 ^^</button>
    </div>
    
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
    </form>
    

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        
    </script>
</body>
</html>