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
	<!-- ex06.jsp -->
    <h1>입력하기</h1>
    
    <form method="POST" action="/java/ex06ok.do">
    <table class="vertical">
        <tr>
            <th>데이터</th>
            <td><input type="text" name="data"></td>
        </tr>
    </table>
    <div>
        <button>보내기</button>
    </div>
    </form>
    
    <form method="POST" action="/java/ex06ok.do">
    <table class="vertical">
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="호날두"></td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="text" name="age" value="11"></td>
        </tr>
        <tr>
            <th>주소</th>
            <td><input type="text" name="address" value="하와이"></td>
        </tr>
    </table>
    <div>
        <button>보내기</button>
        <input type="hidden" name="id" value="SIU">
    </div>
    </form>
    
    <form method="POST" action="/java/ex06ok.do">
    <table class="vertical">
        <tr>
            <th>취미</th>
            <td>
                <input type="checkbox" name="cb" value="독서"> 독서
                <input type="checkbox" name="cb" value="운동"> 운동 
                <input type="checkbox" name="cb" value="여행"> 여행
            </td>
        </tr>
    </table>
    <div>
        <button>보내기</button>
    </div>
    </form>
    
	<script src="https://bit.ly/4cMuheh"></script>
    <script>
    
    </script>
</body>
</html>