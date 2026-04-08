<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
<style>
table td:nth-child(1) {
    width: 120px;
    text-align: center;
}

table td:nth-child(1) img {
    width: 110px;
}
</style>
</head>
<body>
    <!-- list.jsp -->
    <h1 class="main">
        네이버 도서 검색 <small>Open API</small>
    </h1>

    <form method="GET" action="/api/search.do">
        <div class="message">
            <div class="group" style="margin-left: 20px;">
                <label>검색어</label> <input type="text" name="word"
                    class="long" required value="${word}"> <input
                    type="submit" value="검색하기"> <input
                    type="button" value="초기화"
                    onclick="location.href='/api/list.do';">
            </div>
        </div>
    </form>

    <c:if test="${not empty word}">
        <div>'${word}'(으)로 검색한 결과입니다.</div>
    </c:if>

    <table>
        <c:forEach items="${list}" var="dto">
            <tr>
                <td><img src="${dto.image}"></td>
                <td>${dto.title}</td>
                <td>${dto.author}</td>
                <td>${dto.discount}원</td>
                <td>${dto.publisher}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${not empty word}">
        <div style="text-align: center; margin-top: 20px;">

            <c:forEach var="i" begin="1" end="10">

                <c:choose>
                    <%-- 현재 보고 있는 페이지는 빨간색 굵은 글씨로 링크 없이 표시 --%>
                    <c:when test="${i == page}">
                        <span
                            style="font-weight: bold; color: red; margin: 0 5px;">[${i}]</span>
                    </c:when>

                    <%-- 다른 페이지는 클릭 시 해당 페이지로 이동하도록 링크 생성 --%>
                    <c:otherwise>
                        <a href="/api/search.do?word=${word}&page=${i}"
                            style="margin: 0 5px; text-decoration: none; color: black;">
                            [${i}] </a>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

        </div>
    </c:if>

    <script src="https://bit.ly/4cMuheh"></script>
    <script>
					function move(n) {

						if (n > 0) {
							//다음 책보기
							// 1~5페이지를 1페이지로 설정, 6~10페이지를 2페이지라고 설정
							$('input[name=page]').val(
									parseInt($('input[name=page]').val()))
						} else {
							//이전 책보기
						}

					}
				</script>
</body>
</html>
