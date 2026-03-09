<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<!-- ex06.jsp -->
	<h1>폼 입력 태그</h1>
	<!-- form 태그 만들때 GET으로 만들까 POST로 만들까? -->
	<!-- 일단 열에 아홉은 POST니까 POST로 만들고 보자 -->
	<form action="ex06ok.jsp" method="POST">
	<table class="vertical">
		<tr>
			<th>텍스트 박스</th>
			<td><input type="text" name="txt1"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="txt2"></td>
		</tr>
		<tr>
			<th>텍스트 박스</th>
			<td><textarea name="txt3"></textarea></td>
		</tr>
		<tr>
			<th>체크 박스들</th>
			<td>
				<h3>취미를 선택(복수 선택 가능)</h3>
				<label><input type="checkbox" name="cb2" value="독서">독서</label>
				<label><input type="checkbox" name="cb3" value="운동">운동</label>
				<label><input type="checkbox" name="cb4" value="코딩">코딩</label>
			</td>
		</tr>
		<tr>
			<th>체크 박스들</th>
			<td>
				<h3>취미를 선택(복수 선택 가능)</h3>
				<label><input type="checkbox" name="cb5" value="독서">독서</label>
				<label><input type="checkbox" name="cb5" value="운동">운동</label>
				<label><input type="checkbox" name="cb5" value="코딩">코딩</label>
			</td>
		</tr>
		<tr>
			<th>라디오 버튼</th>
				<td>
					<h3>성별을 선택하시오.</h3>
					<label><input type="radio" name ="rb1" value="M" checked>남자</label>
					<label><input type="radio" name ="rb1" value="F">여자</label>
				</td>
		</tr>
		<tr>
			<th>셀렉트 박스</th>
			<td>
				<select name="sel1">
					<option value="1">강아지</option>
					<option value="2">고양이</option>
					<option value="3">병아리</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>다중 선택 셀렉트 박스</th>
			<td>
				<select name="sel2" multiple>
					<option value="1">강아지</option>
					<option value="2">고양이</option>
					<option value="3">병아리</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>히든 태그</th>
			<td><input type="hidden" name="id" value="엄준식은 살아있다" /></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><input type="date" name="regdate" /></td>
		</tr>
		<tr>
			<th>색상</th>
			<td><input type="color" name="myColor" /></td>
		</tr>
		
		<tr>
			<th>사용자 정의 컨트롤(JavaScript, jQuery 등)</th>
			<td><img src="images/catty01.png" id="cat1" /></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	
	<!-- 고양이 이동시키기 -->
	<input type="hidden" name="left">
	<input type="hidden" name="top">
	</form>
	
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://code.jquery.com/ui/1.14.2/jquery-ui.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		$('#cat1').draggable({
			stop: function(event, ui) {
				/* alert(ui.position.left);
				alert(ui.position.top); */
				
				$('input[name=left]').val(ui.position.left);
		        $('input[name=top]').val(ui.position.top);
			}
		});
		/* 고양이 이미지를 움직인 좌표를 서버로 보내보고 싶다 */
	</script>
</body>
</html>