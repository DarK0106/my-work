<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
    <style>
        #attach-zone {
            border: 1px solid #CCC;
            background: #EFEFEF;
            width: 300px;
            height: 100px;
            overflow: auto;
        }
        #attach-zone .item {
            font-size: 12px;
            margin: 5px 10px;
        }
    </style>
</head>
<body>
    <!-- ex03.jsp -->
    <!-- 파일을 드래그 앤 드롭 형식으로 업로드 해보자 -->
    <h1>파일 업로드 <small>다중 파일, File Drop</small></h1>
    
    <form method="POST" action="/file/ex03ok.do" enctype="multipart/form-data">
    <table class="vertical">
        <tr>
            <th>텍스트</th>
            <td><input type="text" name="txt" value="홍길동"></td>
        </tr>
        <tr>
            <th>파일</th>
            <td>
                <div id="attach-zone"></div>
                <input type="file" name="attach" style="display: none;">
            </td>
        </tr>
    </table>
    <div>
        <button>보내기</button>
    </div>
    </form>
    
    
    <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
    
        $('#attach-zone')
            .on('dragenter', e => {
                e.preventDefault();
                e.stopPropagation();
            })
            .on('dragover', e => {
                e.preventDefault();
                e.stopPropagation();
            })
            .on('dragleave', e => {
                e.preventDefault();
                e.stopPropagation();
            })
            .on('drop', e => {
                e.preventDefault();
                
                const files = e.originalEvent.dataTransfer.files;
                
                //console.log(files);
                
                if (files != null && files != undefined) {
                    
                    let temp = '';
                    
                    $('#attach-zone').html('');
                    
                    for (let i=0; i<files.length; i++) {
                        
                        let filename = files[i].name;
                        let filesize = files[i].size / 1024 / 1024; //MB
                        
                        filesize = filesize < 1 ? filesize.toFixed(2) : filesize.toFixed(1);
                        
                        temp += `
                            <div class="item">
                                <span>\${filename}</span>
                                <span>\${filesize}MB</span>
                            </div>
                        `;
                        
                    }//for
                    
                    $('#attach-zone').append(temp);
                    
                    $('input[name=attach]').prop('files', files);
                    
                }
                
            });
        
    
    </script>
    
</body>
</html>
