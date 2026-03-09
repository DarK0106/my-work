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
	<!-- ex08.jsp -->
	<h1>버튼 만들기</h1>
	<form action="ex08ok.jsp" method="POST">
		<table class="vertical">
			<tr>
				<th>너비(px)</th>
				<td><input type="number" min="100" max="500" step="10"
					name="width" value="100" /></td>
			</tr>
			<tr>
				<th>높이(px)</th>
				<td><input type="number" min="100" max="500" step="10"
					name="height" value="100" /></td>
			</tr>
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="txt" value="상자" /></td>
			</tr>
			<tr>
				<th>배경색</th>
				<td><input type="color" name="color" value=#FFFFFF /></td>
			</tr>
			<tr>
				<th>글자색</th>
				<td><input type="color" name="txtColor" value=#000000 /></td>
			</tr>
			<tr>
				<th>글자 크기(px)</th>
				<td><input type="number" min="1" max="50" step="1"
					name="txtSize" /></td>
			</tr>
			<tr>
				<th>버튼 개수(ea)</th>
				<td><input type="number" min="1" max="10" step="1"
					name="btnNum" /></td>
			</tr>
			<tr>
				<th>버튼 간격</th>
				<td>좌우 간격: <input type="range" min="1" max="100" step="1"
					name="btnMarginLR" /> <br /> 상하 간격: <input type="range" min="1"
					max="100" step="1" name="btnMarginTB" /></td>
			</tr>
			<tr>
				<th>아이콘</th>
				<td><label><input type="radio" name="rb1" value="null"
						checked>없음</label> <label><input type="radio" name="rb1"
						value="home">🏚️</label> <label><input type="radio"
						name="rb1" value="image">📷</label> <label><input
						type="radio" name="rb1" value="maps">📍</label> <label><input
						type="radio" name="rb1" value="github">😱</label> <label><input
						type="radio" name="rb1" value="link">🔗</label></td>
			</tr>
			<tr>
				<th>테두리</th>
				<td><select name="isborder" id="isborder">
						<option value="n">감추기</option>
						<option value="y">보이기</option>
				</select>

					<div id="borderbox" style="display: none; margin-top: 10px;">
						<div>
							두께(px) : <input type="number" name="borderwidth" min="0" max="10"
								value="1" />
						</div>
						<div>
							색상 : <input type="color" name="bordercolor" value="#000000" />
						</div>
						<div>
							스타일 : <select name="borderstyle">
								<option value="solid">실선(solid)</option>
								<option value="dashed">쇄선(dashed)</option>
								<option value="dotted">점선(dotted)</option>
							</select>
						</div>
						<div>
							모서리 둥글기(px) : <input type="number" name="borderradius" min="0"
								max="50" value="0" />
						</div>
					</div></td>
			</tr>
		</table>

		<div>
			<button type="submit">만들기</button>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-4.0.0.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		// id가 isborder인 셀렉트 박스의 값이 '변경(change)'될 때마다 안쪽 코드를 실행
		$('#isborder').change(function() {

			// 만약 방금 내가 선택한 값($(this).val())이 'y(보이기)' 라면
			if ($(this).val() == 'y') {
				$('#borderbox').show(); // 숨겨둔 디테일 창을 보여줌
			} else {
				$('#borderbox').hide(); // 그게 아니면('n'이면) 다시 숨긴다
			}

		});
	</script>
</body>
</html>