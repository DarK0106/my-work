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
	<!-- index.jsp -->
    <!-- 카카오톡으로 치면 홈 화면 -->
    <h1>WebSocket <small>쌍카오톡</small></h1>
    
    <div>
        <div class="group">
            <label>채팅방 제목</label>
            <input type="text" name="name" id="name" class="short">
        </div>
    </div>
    
    <hr>
    
    <div>
        <button type="button" class="in">채팅방 접속하기</button>
        
        <button type="button" class="in" data-name="강아지">채팅방 접속하기(강아지)</button>
        <button type="button" class="in" data-name="고양이">채팅방 접속하기(고양이)</button>
        <button type="button" class="in" data-name="병아리">채팅방 접속하기(병아리)</button>
    </div>

    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        
        // 접속하기 버튼 기능 구현
        $('.in').click(() => {
        	
        	// let name = $('#name').val().trim();
        	
        	// 테스트하기 귀찮으니까 버튼 누르면 바로
        	// 채팅방 제목 작성해서 채팅방에 접속하기 위한 로직
        	let name = $(event.target).data('name');
        	
        	if (name == null || name == '') {
        		name = $('#name').val().trim();
        	} else {
        		$('#name').val(name);
        	}
        	
        	// 채팅창 역할의 창을 여는 작업
        	const child = window.open('/socket/chat.do', 'chat', 'width=406, height=518');
        	
        	// 채팅창이 열리면 채팅방 이름을 비활성화
        	$('#name').prop('readOnly', true);
        	// 채팅창이 열렸으니 접속하기 버튼도 비활성화
        	$('.in').prop('disabled', true);
        	
        	// 자식 창에 채팅방 이름을 넘긴다
        	// 부모가 자식 창이 뜨기까지 충분히 기다린 다음
        	// 창이 뜨면 connect라는 함수가 정의될 수 있도록 만든다
        	// child.connect(name);
        	
        	// 근데 1초 기다리라는 설정을 할게 아니고
        	// 자식 창에 onload라는 이벤트를 건다
        	// 뭔가를 load한 직후 발생하는 이벤트
        	// 자식 창의 모든 내용이 로드된 후에 발생한다
        	child.addEventListener('load', () => {
        		child.connect(name);
        	});
        	
        });
    
    </script>
</body>
</html>