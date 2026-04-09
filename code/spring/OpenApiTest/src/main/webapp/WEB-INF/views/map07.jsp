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
    <!-- map07.jsp -->
    <h1>Kakao Map <small>길찾기</small></h1>
    
    <div>
        <div id="map"></div>
    </div>
    <hr>
    <div>
        <!-- 지도에서 어딘가를 누르면 거기가 출발점, -->
        <!-- 또 다른곳을 누르면 그곳이 도착점 -->
        <input type="button" value="길찾기" id="btnSearch">
        <input type="button" value="초기화" id="btnReset">
        <input type="button" value="새로고침" onclick="location.reload();">
    </div>
    
    <form method="POST" action="/api/map07ok.do">
        <input type="hidden" name="startLat">
        <input type="hidden" name="startLng">
        <input type="hidden" name="endLat">
        <input type="hidden" name="endLng">
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
		
		let startMarker = null; // 출발지
		let endMarker = null; // 도착지
		
		// 출발지 찍기
		kakao.maps.event.addListener(map, 'click', evt => {
			
			if (startMarker == null) {
			    
				const path = '/api/resources/marker/navigator.png';
				const size = new kakao.maps.Size(64, 64);
				const op = { offset: new kakao.maps.Point(32, 64) };
				const img = new kakao.maps.MarkerImage(path, size, op);
				
				startMarker = new kakao.maps.Marker({
					position: evt.latLng,
					image: img
				});
				
				startMarker.setMap(map);
				$('input[name=startLat]').val(evt.latLng.getLat());
				$('input[name=startLng]').val(evt.latLng.getLng());
				
			} else if (startMarker != null && endMarker == null) {   // 종착지 찍기
				const path = '/api/resources/marker/bus-stop.png';
                const size = new kakao.maps.Size(64, 64);
                const op = { offset: new kakao.maps.Point(32, 64) };
                const img = new kakao.maps.MarkerImage(path, size, op);
                
                endMarker = new kakao.maps.Marker({
                    position: evt.latLng,
                    image: img
                });
                
                endMarker.setMap(map);
                $('input[name=endLat]').val(evt.latLng.getLat());
                $('input[name=endLng]').val(evt.latLng.getLng());
			}
			
		});
		
		// 초기화 버튼 기능 구현하기
		$('#btnReset').click(() => {
			
			if(startMarker != null) startMarker.setMap(null);
			if(endMarker != null) endMarker.setMap(null);
			startMarker = null;
			endMarker = null;
			
		});
		
		$('#btnSearch').click(() => {
			
			$('form').submit();
			
		});
		
<c:if test="${not empty routeData}">
        
        var routeData = ${routeData};
        
        function drawPath(result) {
            
            var linePath = [];
            var bounds = new kakao.maps.LatLngBounds();

            result.routes[0].sections.forEach(function(section) {
                section.roads.forEach(function(road) {
                    for (var i = 0; i < road.vertexes.length; i += 2) {
                        var point = new kakao.maps.LatLng(road.vertexes[i+1], road.vertexes[i]);
                        linePath.push(point);
                        bounds.extend(point);
                    }
                });
            });

            /*
                dashdot
                longdashdot
                longdash
            */
            var polyline = new kakao.maps.Polyline({
                path: linePath,
                strokeWeight: 5,
                strokeColor: 'cornflowerblue',
                strokeOpacity: .7,
                strokeStyle: 'solid'
            });
   
            polyline.setMap(map);
            //map.setBounds(bounds);
            
            
            
            //시작/도착 마커 표시
            
            const path = '/api/resources/marker/navigator.png';
            const size = new kakao.maps.Size(64, 64);
            const op = { offset: new kakao.maps.Point(32, 64) }
            const img = new kakao.maps.MarkerImage(path, size, op);
            
            startMarker = new kakao.maps.Marker({
                position: linePath[0],
                map: map,
                image: img
            });
            
            
            const path2 = '/api/resources/ marker/bus-stop.png';
            const size2 = new kakao.maps.Size(64, 64);
            const op2 = { offset: new kakao.maps.Point(32, 64) }
            const img2 = new kakao.maps.MarkerImage(path2, size2, op2);

            // 도착지 마커
            endMarker = new kakao.maps.Marker({
                position: linePath[linePath.length - 1],
                map: map,
                image: img2
            });            
            
            
            function animatePath() {
                var index = 0;
                var intervalId = setInterval(function() {
                    if (index >= linePath.length) {
                        clearInterval(intervalId);
                        return;
                    }
                    map.panTo(linePath[index]);
                    index++;
                }, 500); // 100ms마다 이동
            }

            //animatePath();
            
        }

        drawPath(routeData);
        </c:if>
		
	</script>
    
</body>
</html>