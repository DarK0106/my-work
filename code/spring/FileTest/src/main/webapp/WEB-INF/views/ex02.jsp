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
    <!-- ex02.jsp -->
    <h1>파일 업로드 <small>다중 파일, multiple</small></h1>
    
    <form method="POST" action="/file/ex02ok.do" enctype="multipart/form-data">
    <table class="vertical">
        <tr>
            <th>텍스트</th>
            <td><input type="text" name="txt" value="홍길동"></td>
        </tr>
        <tr>
            <th>파일</th>
            <td><input type="file" name="attach" multiple></td>
        </tr>
    </table>
    <div>
        <button>보내기</button>
    </div>
    </form>
    
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
       document.querySelector('form').onsubmit = function() {
            
            //첨부파일
            //alert(document.querySelector('input[name=attach]').files.length);
            
            let totalsize = 0;
            
            Array.from(document.querySelector('input[name=attach]').files).forEach(file => {
                
                //파일 1개씩 유효성 검사
                if (checkFile(file.name, file.size)) {
                    event.preventDefault();
                    return false;
                }
                
                totalsize += file.size;
                
            });
            
            if (totalsize > 52428800) {
                alert('총 파일 크기의 합은 50MB 이하만 가능합니다.')
                event.preventDefault();
                return false;
            }           
            
        };
        
        function checkFile(filename, filesize) {
            
            const maxsize = 10485760; //10MB
            const regex = /(.*?)\.(exe|sh|bat)$/gi; //test.exe, test.sh
            
            if (filesize > maxsize) {
                alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
                return true;
            }
            
            if (regex.test(filename)) {
                alert('해당 파일은 업로드할 수 없습니다.');
                return true;
            }
            
            return false;           
        }
    
    </script>
    
</body>
</html>
