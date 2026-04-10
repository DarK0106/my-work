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
    <!-- ex08.jsp -->
    <h1>REST Client</h1>
    <div>
        <!-- 이 버튼을 누르면 모달이 떠서 입력할 수 있는 폼이 생성됨 -->
        <button type="button" class="add" data-modal-button="add">추가하기</button>
        <button type="button" class="del" onclick="del();">삭제하기</button>
    </div>
    <table id="tbl1">
        <thead>
        <tr>
            <th></th>
            <th>번호</th>
            <th>이름</th>
            <th>나이</th>
            <th>성별</th>
            <th>주소</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td colspan="6">데이터가 없습니다.</td>
            </tr>
        </tbody>
    </table>
    
    <div id="loader" style="display: none;">
        <img src="/ajax/resources/images/loader.gif" style="width: 100px; display: block; margin: 0px auto; margin-top: -10px;">
    </div>
    
    <div>
        <!-- <button type="button" onclick="list();">주소록 가져오기</button> -->
        <button type="button" id="more" onclick="more();">더보기</button>        
    </div>
    
    <!-- 추가하기 기능의 입력창 -->
    <div data-modal-window="add" data-modal-title="주소록 추가하기">
        
        <!-- 사용자로부터 이름 나이 성별 주소를 받아서 서버에 입력하기 -->
        <form id="form1">
        <table class="vertical">
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" id="name" class="short"></td>
            </tr>
            <tr>
                <th>나이</th>
                <td><input type="number" name="age" id="age" min="0" max="120"></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <select name="gender" id="gender">
                        <option value="m">남자</option>
                        <option value="f">여자</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>주소</th>
                <td><input type="text" name="address" id="address" class="full"></td>
            </tr>
        </table>
        </form>
        
        <hr>
        
        <div>
            <button type="button" data-modal-ok="add" id="btnAdd">추가하기</button>
            <button type="button" data-modal-cancel="add">닫기</button>
        </div>
        
    </div>
    
    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>   
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
        function list() {
            
        	$.ajax({
        		type: 'GET',
        		url: '/ajax/address',
        		// 받을 데이터 타입(ajax가 인식)
        		dataType: 'json',
        		success: function(list) {
        			// console.log(list);
        			// 성공했으니 화면에 출력 -> 클라이언트 측 화면 구성 -> Client-Side Rendering = CSR
        			$('#tbl1 tbody').html('');
        			
        			list.forEach(item => {
        				$('#tbl1 tbody').append(`
        						<tr>
        						   <td><input type="checkbox" name="seq" value="\${item.seq}"></td>
        						   <td>\${item.seq}</td>
        						   <td>\${item.name}</td>
        						   <td>\${item.age}</td>
        						   <td>\${item.gender}</td>
        						   <td>\${item.address}</td>
        						</tr>
        						`);
        			});
        		},
        		error: function(a,b,c) {
        			console.log(a,b,c);
        		}
        	});
            
        }
        
        list();
        
        $('#btnAdd').click(() => {
        	
        	// 입력한 데이터를 서버로 전송
        	// 전송하는 방법 1. QueryString
        	// - name=홍길동&age=20&gender=m&address=서울시
        	// 방법 2. 객체로 넘기는 방법
        	// 진짜 객체로 넘어가는게 아니고 매핑이 되어서 쿼리스트링으로 넘어감
        	// 방법 3. 직렬화
        	// - <form> 의 모든 입력 양식을 직렬화(한 줄의 문자열로 변경한다.)
        	// - <form> 이 있어야만 가능
        	
        	// 이건 순수한 자바스크립트 객체인데 이걸 JSON 형태의 문자열로 바꿔야 함
            // 자바스크립트의 기본 기능인 JSON.stringify(data)를 사용
        	const data = {
                name: $('#name').val(),
                age: $('#age').val(),
                gender: $('#gender').val(),
                address: $('#address').val()
            };
        	//- {"name":"홍길동","age":"20","address":"서울시"}
            //alert(JSON.stringify(data));
        	
        	$.ajax({
        		// 서버측 엔드 포인터(URL)
        		type: 'POST',
        		url: '/ajax/address',
        		
        		// 서버에게 보내는 데이터 설정
        		data: JSON.stringify(data),
        		contentType: 'application/json; charset=UTF-8',
        		
        		// 서버한테 수신받는 데이터 설정
        		dataType: 'json',
        		success: function(result) {
        			if (result == '1') {
        			    list();	
        			} else {
        				alert('실패했습니다 ㅠㅠ');
        			}
        		},
        		error: function(a,b,c) {
        			console.log(a,b,c);
        		}
        	});
        
        	/*
        	$.ajax({
        		type: 'POST',
        		url: '/ajax/address',
        		data: {
        			name: $('#name').val(),
        			age: $('#age').val(),
        			gender: $('#gender').val(),
        			address: $('#address').val()
        		}
        	});
        	*/
        	
        	// alert($('#form1').serialize());
        	
        });
        
        // 더보기 버튼 기능 구현
        let index = 6;
        function more() {
        	
        	// 로딩 이미지 보여주기
        	$('#loader').show();
        	// 로딩 이미지 보이는 동안 더보기 버튼 못 누르게 막기
        	$('#more').prop('disabled', true).css('cursor', 'not-allowed');
        	
        	// 의도적으로 0.5 초 뒤에 시작(로딩 이미지 띄우려고)
        	setTimeout(() => {
        		$.ajax({
                    type: 'GET',
                    url: '/ajax/address/more',
                    data: 'index=' + index,
                    // 돌려받을 데이터
                    dataType: 'json',
                    success: function(list) {
                        
                        // 더 이상 가져올게 없을 때
                        if (list.length == 0) {
                            alert('더 이상 가져올 항목이 없습니다.');
                            return;
                        }
                        
                        list.forEach(item => {
                            $('#tbl1 tbody').append(`
                                    <tr>
                            		   <td><input type="checkbox" name="seq" value="\${item.seq}"></td>
                                       <td>\${item.seq}</td>
                                       <td>\${item.name}</td>
                                       <td>\${item.age}</td>
                                       <td>\${item.gender}</td>
                                       <td>\${item.address}</td>
                                    </tr>
                                    `);
                        });
                        
                        // 더보기를 또 누르면 
                        // 그 다음 5개를 가져오기 위해
                        index += 5;
                        
                        // 로딩 이미지 치우기
                        $('#loader').hide();
                        // 더보기 버튼 못 누르게 막은거 풀기
                        $('#more').prop('disabled', false).css('cursor', 'default');
                    },
                    error: function(a,b,c) {
                        console.log(a,b,c);
                    }
                    
                });
        	}, 500); // 의도적으로 0.5 초 뒤에 시작
        	
        }
        
        // 삭제하기 버튼 기능 구현
        function del() {
        	// console.log($('input[name=seq]:checked').val);
        	
        	/*
        	const seqList = [];
        	
        	$('input[name=seq]:checked').each((index, item) => {
        		seqList.push(item.value);
        	});
        	*/
        	
        	const seqList = $('input[name=seq]:checked').map((index, item) => item.value).get();
        	
        	// console.log(seqList);
        	
        	const data = {
        			slist: seqList
        	};
        	
        	// 사용자가 어떤 애들을 체크했는지 알아냈으니 지우러 가야 함
        	// ajax로 여러개의 항목을 지워달라고 요청하자
        	$.ajax({
        		type: 'DELETE',
        		url: '/ajax/address',
        		data: JSON.stringify(data),
        		contentType: 'application/json; charset=UTF-8',
        		dataType: 'json',
        		success: function(result) {
        			
        			if (result > 0) {
        				list();
        			
        			// 방금 삭제된 애의 seq
        			// DOM으로는 <tr>을 지워야 하는 상황
        			// 모든 <tr>을 다 찾아서 두번째 <td>에 있는 번호가
        			// 내가 찾던 번호면 그 <tr> 삭제
        			/*
        			seqList.forEach(seq => {
        				$('#tbl1 tr td:nth-child(2)').each((index, item) => {
        					
        					if ($(item).text() == seq) {
        						$(item).parent().remove();
        					}
        					
        				});
        			});
        			*/
        			
        		    } else {
        		        alert('삭제 실패 ㅠㅠ');
        		    }
        		},
        		error: function(a,b,c) {
                    console.log(a,b,c);
                }
        	});
        }
        
    </script>
</body>
</html>
