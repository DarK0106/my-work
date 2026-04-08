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
    
    <!-- ex03.jsp -->
    <h1>결과</h1>
    
    <div>
        <div>txt: ${txt}</div>
    </div>
    
    <div>
        <c:forEach items="${attach}" var="file">
        <div><a href="/file/download.do?filename=${file.originalFilename}">${file.originalFilename}</a></div>
        </c:forEach>
    </div>
    
</body>
</html>
