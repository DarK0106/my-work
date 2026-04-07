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
    <h1>결과</h1>
    
    <div>
        <div>txt: ${txt }</div>
    </div>
    
    <div>
        <div><a href="/file/resources/files/${filename}" download>filename: ${filename}</a></div>
    </div>
    
    <div>
        <div><a href="/file/download.do?filename=${filename}">filename: ${filename}</a></div>
    </div>
    
     <!--
        filetype이 아래와 같을 때 ex01ok에서
        미리보기를 출력하는 코드  
        - image/gif
        - image/jpeg
        - image/png
    -->
    <c:if test="${filetype.startsWith('image')}">
    <div>
        <img src="/file/resources/files/${filename}" style="max-width: 700px; border: 1px solid gray; padding: 5px;">
    </div>
    </c:if>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
    </script>
</body>
</html>