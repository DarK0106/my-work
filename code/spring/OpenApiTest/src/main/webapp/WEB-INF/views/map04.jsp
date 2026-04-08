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
    <!-- map01.jsp -->
    <h1>Kakao Map <small>마커</small></h1>
    
    <div>
        <div id="map"></div>
    </div>
    <hr>
    <div class="message">&nbsp;</div>
    
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eae9c04f98071de9360c7a08ce15c93"></script>


    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
        var options = { //지도를 생성할 때 필요한 기본 옵션
        		          center : new kakao.maps.LatLng(37.499330, 127.033181), //지도의 중심좌표.
        		          level : 3
        		          //지도의 레벨(확대, 축소 정도)
					  };

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		// 자바 데이터를 자바스크립트 데이터 형태로 매핑해야함
		// 원본이 Array List라서 자바스크립트에선 배열로 만들자
		const mlist =[];
		<c:forEach items="${list}" var="dto">
		mlist.push({
			// dto로 받아놓은걸 하나 꺼내서 자바스크립트 코드로 만들면 된다
			// 그걸 dto로 넘겨준 개수만큼 반복하면된다?
			seq: ${dto.seq},
			lat: ${dto.lat},
			lng: ${dto.lng}
		});
		</c:forEach>
		
		mlist.forEach(item => {
			const m = new kakao.maps.Marker({
				position: new kakao.maps.LatLng(item.lat, item.lng)
			});
			m.setMap(map);
		});
		
		// 현재 보이는 지도상(영역)의 나타난 마커 개수 세기
		let count = 0;
		
		function countMarker() {
			  count = 0;
			  
			  mlist.forEach(item => {
				 if (containMarker(item)) {
					 count++;
				 } 
			  });
			  
			  $('.message').text(`현재 보이는 마커의 개수는 \${count}개입니다.`);
		}
		
		countMarker();
		
		function containMarker(item) {
			
			// 현재 지도의 영역은?
			const sw = map.getBounds().getSouthWest(); // LatLng
			const ne = map.getBounds().getNorthEast();
			
			if (item.lat >= sw.getLat()
					&& item.lat <= ne.getLat()
					&& item.lng >= sw.getLng()
					&& item.lng <= ne.getLng()) {
			        return true;
			}
			return false;
		}
		
		// 지도 이벤트(드래그)
		kakao.maps.event.addListener(map, 'dragend', evt => {
			countMarker();
		});
		
		// 지도 이벤트(줌 인 / 줌 아웃)
		kakao.maps.event.addListener(map, 'zoom_changed', evt => {
			countMarker();
		});
		
	</script>
</body>
</html>