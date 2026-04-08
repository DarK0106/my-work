<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
    <style>
        #map {
            width: 770px;
            height: 500px;
        }
    </style>
</head>
<body>
    <!-- map03.jsp -->
    <h1>Kakao Map <small>클릭 이벤트 + 마커 표시</small></h1>
    
    <div>
        <div id="map"></div>
    </div>
    <hr>
    <div class="message">&nbsp;</div>
    
    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bc11f2c1d9ac19ad396b5861eb348a12"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
        var container = document.getElementById('map');
        
        var options = {
            center: new kakao.maps.LatLng(37.504742, 127.053156),
            level: 3
        };
    
        var map = new kakao.maps.Map(container, options);
        
        let m1 = null;
        let info = null;
        
        kakao.maps.event.addListener(map, 'click', function(evt) {
            
            //위치 정보(위도,경도)
            //alert(evt.latLng);
            
            let msg = `클릭 위치: 위도(\${evt.latLng.getLat()}), 경도(\${evt.latLng.getLng()})`;
            $('.message').text(msg);
            
            
            
            
            
            if (m1 != null) {
                // 지도에 이전 마커가 존재한다. > 삭제
                m1.setMap(null);
                //info.open(null, null);
            }
            
            
            //마커 만들기
            //1. 일반 마커
            //2. 사용자 이미지 마커
            
            const path = '/api/resources/marker/pointing.png';
            const size = new kakao.maps.Size(128, 128);
            const op = {
                offset: new kakao.maps.Point(0, 50)
            };
            const img = new kakao.maps.MarkerImage(path, size, op);         
            
            m1 = new kakao.maps.Marker({ 
                position: evt.latLng,
                image: img
            });
            
            //m1.setTitle('풍선 도움말');
            
            m1.setMap(map);
            
            
            
            //인포 윈도우
            /*
            info = new kakao.maps.InfoWindow({
                position: evt.latLng,
                content: '<div style="color: tomato;">장소 설명</div>'
            });
            
            info.open(map, m1);
            */
            
        });
        
    
    </script>
</body>
</html>
