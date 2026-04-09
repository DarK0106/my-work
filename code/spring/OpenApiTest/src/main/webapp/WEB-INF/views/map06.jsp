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
<style>
    #map {
        width: 750px;
        height: 500px;
    }
</style>
<body>
    <!-- map06.jsp -->
    <h1>Kakao Map <small>좌표와 주소간의 변환</small></h1>
    
    <div>
        <div id="map"></div>
    </div>
    <hr>
    <div>
        <input type="text" id="address" class="full" placeholder="주소를 입력하세요">
    </div>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eae9c04f98071de9360c7a08ce15c93&libraries=services"></script>


    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
        var options = { //지도를 생성할 때 필요한 기본 옵션
        		          center : new kakao.maps.LatLng(37.505006, 127.053204), //지도의 중심좌표.
        		          level : 3
        		          //지도의 레벨(확대, 축소 정도)
					  };

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		// 해당 위치의 위도 경도를 알아내는 작업
		// 주소를 좌표로, 좌표를 주소로
		$('#address').keydown(evt=> {
			 if (evt.keyCode == 13) {
				 search();
			 }
		});
		
		let m = null;
		
		function search() {
			
			const geocoder = new kakao.maps.services.Geocoder();
			
			geocoder.addressSearch($('#address').val(), function(result, status) {
				
				// console.log(result);
				// result[0].y
				
				// console.log(status);
				
				// 정상적인 응답을 받았다면
				if (status == kakao.maps.services.Status.OK) {
					
					if (m != null) m.setMap(null);
					
					// 입력한 주소에 마커를 찍자
					m = new kakao.maps.Marker ({
						position: new kakao.maps.LatLng(result[0].y, result[0].x)
					});
					m.setMap(map);
					
				} else {
					alert('잘못된 주소를 입력했습니다.');
					$('#address').select();
				}
				
				
			});
			
		}
		
		// 누른 곳이 중앙에 오도록 클릭 이벤트 만들기
		// 누른 곳의 위도 경도를 주소지로 바꿔서 보여주는 기능
		kakao.maps.event.addListener(map, 'click', evt => {
			
			if (m != null) m.setMap(null);
            
            m = new kakao.maps.Marker ({
                position: evt.latLng
            });
            m.setMap(map);
            map.panTo(m.getPosition());
            
            // 좌표를 주소로 변환하기
            const geocoder = new kakao.maps.services.Geocoder();
            
            geocoder.coord2Address(evt.latLng.getLng(), evt.latLng.getLat(), function(result, status) {
            	
            	// 클릭한 곳의 주소를 알아냈다면
            	if (status == kakao.maps.services.Status.OK) {
            		// console.log(result);
            		
            		$('#address').val(result[0].address.address_name);
            		
            	} else {
            		alert('해당 위치의 주소를 찾지 못했습니다.');
            	}
            	
            });
			
		});
		
	</script>
    
</body>
</html>