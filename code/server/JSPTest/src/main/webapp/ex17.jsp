<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		#fileList > div {
			margin-top: 5px;
		}
		#fileList > div > input[type=file] {
			width: 290px;
		}
		#fileList > div > span {
			font-size: 1.5rem;
			cursor: pointer;
			
		}
	</style>
</head>
<body>
	<!-- ex17.jsp -->
	<!-- 다중 파일 업로드 -->
	<h1>파일 업로드 <small>다중 파일</small></h1>
	
	<form method="POST" action="ex17ok.jsp" enctype="multipart/form-data">
	<table class="vertical">
		<tr>
			<th>문자열</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<div><input type="file" name="attach1"></div>
				<div id="fileList"></div>
				<hr class="thin">
				<input type="button" value="첨부파일 추가하기" id="btnFile">
			</td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		let no = 2;
	
		$('#btnFile').click(() => {
			
			$('#fileList').append(`
				<div>
					<input type="file" name="attach\${no}">
					<span onclick="del();">&times;</span>
				</div>
			`);
			
			no++;
			
		});
		
		function del() {
			$(event.target).parent().remove();
		}
	
	</script>
</body>
</html>