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

    <c:forEach items="${fileList}" var="file">
        <div>
            <a href="/file/download.do?filename=${file.savedFilename}">${file.originalFilename}</a>
        </div>
    </c:forEach>


    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
					
	</script>
</body>
</html>