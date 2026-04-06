<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- list.jsp -->
    <h1>주소록</h1>
    
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>나이</th>
            <th>성별</th>
            <th>주소</th>
        </tr>
        <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.seq}</td>
            <td>${dto.name}</td>
            <td>${dto.age}</td>
            <td>${dto.gender}</td>
            <td>${dto.address}</td>
        </tr>
        </c:forEach>
    </table>
    
	<script src="https://bit.ly/4cMuheh"></script>
    <script>
    
    </script>
</body>
</html>