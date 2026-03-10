<%@page import="java.util.Comparator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 디렉토리 탐색
	// C:\Ssangyong\code\server\.metadata\...\JSPTest\pic
	String path = application.getRealPath("/pic");
	
	File dir = new File(path);
	File[] list = dir.listFiles();
	
	System.out.println(Arrays.toString(list));
	
	// 이미지 정렬하기
	Arrays.sort(list, new Comparator<File> () {
		public int compare(File o1, File o2) {
			// return o2.getName().compareTo(o1.getName()); <- 이름순
			// return Double.compare(o1.length(), o2.length()); <- 크기순
			return Long.compare(o1.lastModified(), o2.lastModified()); // <- 시간순 정렬
		}
	});

%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		#list {
			width: 750px;
			display: flex;
			flex-wrap: wrap;
			margin-left: 25px;
		}
		#list .item {
			border: 1px solid #999999;
			width: 126px; height: 126px;
			margin: 11px;
			background-size: contain;
			background-repeat: no-repeat;
			background-position: center center;
			position: relative;
			left: 0px;
			top: 0px;
		}
		#list .item span {
			position: absolute;
			right: 5px;
			top: 0px;
			color: black;
			text-shadow: 0px 0px 2px #black;
			cursor: pointer;
			display: none;
		}
		
		#list .item:hover span {
			display: inline;
		
		}
		
		#img1 {
			max-width: 490px;
			display: block;
			margin: 15px auto;
		}
	</style>
</head>
<body>
	<!-- ex18.jsp -->
	<!--  
	
		클라이언트 측에서 할 작업
		1. HTML
		2. CSS
		3. JavaScript
		
		서버 측에서 할 작업
		1. JSP
		
		작업 순서
		HTML -> CSS -> JavaScript
	
	-->
	<h1>Image Gallery</h1>
	
	<div id="list">
    <% for (File file : list) { %>
    <div class="item" style="background-image:url('pic/<%= file.getName() %>')" data-modal-button="view">
    <span title="delete" onclick="del();" data-filename="<%= file.getName() %>">&times;</span>
    </div>
    <% } %>
	</div>
	
	<hr />
	<form action="ex18ok.jsp" method="POST" enctype="multipart/form-data">
	<table class="vertical">
		<tr>
			<th>이미지</th>
			<td>
				<input type="file" name="attach" required 
				accept="image/*" />
			</td>
		</tr>
	</table>
	<div><input type="submit" value="  업로드  " /></div>
	</form>
	
	<!-- 팝업창 구현하기 -->
	<div data-modal-window="view"data-modal-title="Image">
		<img src="" alt="" id="img1" />
		<hr />
		<div>
			<button class="ok" data-modal-ok="view">확인</button>
		</div>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		$('#list .item').click(() => {
			let filename = $(event.target).children('span').data('filename');
			$('#img1').attr('src', 'pic/' + filename);
		})
	
		function del() {
			
			// alert(event.target.dataset['filename']);
			// ex18del한테 지울 파일명 알려주기
			if (confirm('이미지를 삭제하시겠습니까?')) {
			location.href = "ex18del.jsp?filename=" + event.target.dataset['filename'];
			}
			// 이벤트 전팦 방지
			event.stopPropagation();
			return false;
			
			
		}
	</script>
</body>
</html>