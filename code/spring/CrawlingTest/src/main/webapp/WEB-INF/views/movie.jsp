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
	<!-- movie.jsp -->
    <h1>영화 순위</h1>
    
    <table>
        <c:forEach items="${mlist }" var="dto">
        <tr>
            <td><img src="https://www.moviechart.co.kr${dto.poster}"></td>
            <td>[${dto.seq }] ${dto.title } - ${dto.genre }</td>
            <td>${dto.date }</td>
            <td>${dto.director }/${dto.actor }</td>
        </tr>
        </c:forEach>
    </table>
        
    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        
    </script>
</body>
</html>