<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <title>파일업로드예제</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class = "container">
        <h2>파일 업로드</h2>
        <form name="dataForm" id="dataForm" onsubmit="return registerAction()">
            <button id="id-upload" type="button" style="border: 1px solid #ddd; outline: none;"> 파일 추가</button>
            <input id="input_file" multiple="multiple" type="file" style="display: none"/>
            <div class="data_file_txt" id="data_file_txt" style="margin: 40px">
                <span>첨부 파일</span>
                <br/>
                <div id="fileChange"></div>
            </div>

        </form>
    </div>
    <script>
        $(document).ready(function (){
            $("#input_file").on("change", fileCheck);
        });

        $(function (){
            $("#id-upload").click(function (e){
                e.preventDefault();
                $('#input_file').click();
            });
        })

        let fileCount = 0;
        const totalCount = 5;
        let fileNum = 0;
        let content_files = [];

        const fileCheck =(e)=>{
            // 올라온 파일 담기
            let files = e.target.files;
            let fileArr = Array.prototype.slice.call(files);

            // 총 파일 갯수 제한
            if(fileCount + fileArr.length > totalCount){
                alert("더이상 파일을 올릴 수 없습니다.")
                return;
            }else{
                fileCount = fileCount + fileArr.length;
            }

            fileArr.forEach(function (f){
                let reader = new FileReader();
                reader.onload = function (e){
                    content_files.push(f);
                    $('#fileChange').append(addHtml(fileNum, f.name));
                    fileNum ++;
                };
                reader.readAsDataURL(f);
            });
            console.log(content_files);
            $("#input_file").val("")

        }

        const addHtml=(fileNum, name)=>{
            let tempHtml = `<div id='file-\${fileNum}' onclick='fileDelete(file-\${fileNum})'>
                                <font style='font-size:12px'>  \${name}  </font>
                            <div/>`
            return tempHtml;
        }

    </script>
</body>
</html>
