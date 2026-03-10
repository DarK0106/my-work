<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//1. 대상 폴더의 파일 객체 생성(webapp > files)
	//2. 폴더의 내용을 가져오기(listFile())
	//3. 파일만 출력하기 > 테이블에 출력
	//	- 파일명 > 그대로
	//	- 크기 > B, KB, MB > 소수이하 1자리까지
	//	- 수정 날짜 > 2025-09-04 (목) 오후 4: 31
	//	- 정렬 > 파일명 오름차순
	//4. 파일명 클릭 > 파일 다운로드(download.jsp 사용)
	//5. 아이콘
	
	//디렉토리 탐색
	String path = application.getRealPath("/files");

	File dir = new File(path);
	File[] list = dir.listFiles();
		
	Arrays.sort(list, (o1, o2) 
					-> o1.getName().compareTo(o2.getName()));
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		#tbl1 th:nth-child(1) { width: auto; }
		#tbl1 th:nth-child(2) { width: 100px; }
		#tbl1 th:nth-child(3) { width: 220px; }
		#tbl1 th:nth-child(4) { width: 40px; }
		
		#tbl1 td:nth-child(1) { text-align: left; }
		#tbl1 td:nth-child(1) img { width: 18px; float: left; margin-right: 5px; }
		#tbl1 td:nth-child(4) span { cursor: pointer; }
	</style>
</head>
<body>
	<!-- ex19.jsp -->
	<!--  
		webapp > files 폴더 관리
	-->
	<h1>자료실 <small>탐색기</small></h1>
		
	<table id="tbl1">
		<tr>
			<th>파일명</th>
			<th>크기</th>
			<th>수정된 날짜</th>
			<th>삭제</th>
		</tr>
		<% 
			for (File file : list) {
				if (file.isFile()) {
					
					String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
					
					if (extension.equals("doc")) {
						extension = "doc.png";
					} else if (extension.equals("gif")) {
						extension = "gif.png";
					} else if (extension.equals("js")) {
						extension = "js.png";
					} else if (extension.equals("html")) {
						extension = "html.png";
					} else if (extension.equals("mp4")) {
						extension = "mp4.png";
					} else if (extension.equals("pdf")) {
						extension = "pdf.png";
					} else if (extension.equals("png")) {
						extension = "png.png";
					} else if (extension.equals("sql")) {
						extension = "sql.png";
					} else if (extension.equals("txt")) {
						extension = "txt.png";
					} else if (extension.equals("xls")) {
						extension = "xls.png";
					} else if (extension.equals("xml")) {
						extension = "xml.png";
					} else if (extension.equals("zip")) {
						extension = "zip.png";
					} else {
						extension = "other.png";
					}
					
					String size = "";
					
					if (file.length() < 1024) {
						size = String.format("%,dB", file.length());
					} else if (file.length() < 1024 * 1024) {
						size = String.format("%,.1fKB", file.length() / 1024.0);
					} else if (file.length() < 1024 * 1024 * 1024) {
						size = String.format("%,.1fMB", file.length() / 1024.0 / 1024.0);
					}
					
					Calendar time = Calendar.getInstance();
					time.setTimeInMillis(file.lastModified());
					
					String lastModified = String.format("%tF (%s) %s %d:%d", time, time.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.KOREAN), time.get(Calendar.AM) == 1 ? "오전":"오후", time.get(Calendar.HOUR), time.get(Calendar.MINUTE));
			
		%>
		<tr>
			<td>
				<img src="icon/<%= extension %>">
				<%= file.getName() %>
			</td>
			<td><%= size %></td>
			<td><%= lastModified %></td>
			<td><span class="material-symbols-outlined" onclick="del('<%= file.getName() %>');">delete</span></td>
		</tr>
		<% }} %>
	</table>
	
	<hr class="thick">
	
	<form method="POST" action="ex19ok.jsp" enctype="multipart/form-data">
		<div>파일: <input type="file" name="attach" required></div>
		<div><button class="attach">업로드</button></div>	
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		function del(filename) {
			
			if (confirm('delete?')) {
							
				location.href = 'ex19del.jsp?filename=' + filename;
				
			}
			
		}
	</script>
</body>
</html>
