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
    <!-- map05.jsp -->
    <h1>Kakao Map <small>마커 추가하기</small></h1>
    
    <div>
        <div id="map"></div>
    </div>
    
    <form method="POST" action="/api/add.do">
    <div>
        <input type="submit" value=" 마커 추가하기 ">
    </div>
    <input type="hidden" name="lat">
    <input type="hidden" name="lng">
    </form>
    
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eae9c04f98071de9360c7a08ce15c93"></script>


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
		
		let m = null;
		
		// 콜백 함수는 인자로 전달되는 함수
		kakao.maps.event.addListener(map, 'click', evt => {
			
			if (m != null) m.setMap(null);
			
			const img = new kakao.maps.MarkerImage(
			    '/api/resources/marker/favorite.png',
			    new kakao.maps.Size(64, 64),
			    { offset: new kakao.maps.Point(32, 64) }
			);
			
			m = new kakao.maps.Marker({
				position: evt.latLng,
				image: img
			});
			
			m.setMap(map);
			
			// 클릭 좌표 -> 히든 태그
			$('input[name=lat]').val(evt.latLng.getLat());
			$('input[name=lng]').val(evt.latLng.getLng());
			
		});
	</script>
</body>
</html>