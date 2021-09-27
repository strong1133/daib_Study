<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>엑셀업로더</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

    <div class = "container">
        <h2>파일 업로드</h2>
        <form name="dataForm" id="dataForm" onsubmit="return registerAction()" enctype="multipart/form-data" >
            <button id="id-upload" type="button" style="border: 1px solid #ddd; outline: none;"> 파일 추가</button>
            <button id="post-file" type="button" style="border: 1px solid #ddd; outline: none;"> 파일 저장</button>
            <input id="input_file" multiple="multiple" type="file" style="display: none"/>
            <div class="data_file_txt" id="data_file_txt" style="margin: 40px">
                <span>첨부 파일</span>
                <br/>
                <div id="fileChange"></div>
            </div>
        </form>
    </div>

    <script>
        let fileArr = {}
        $(document).ready(function (){
            $("#input_file").on("change", fileCheck);
        });

        $(function (){

            $("#id-upload").click(function (e){
                e.preventDefault();
                $('#input_file').click();
            });

            $("#post-file").click(function (e){
                postFile(fileArr);
            })
        })

        let fileCount = 0;
        const totalCount = 5;
        let fileNum = 0;
        let content_files = [];

        const fileCheck =(e)=>{
            // 올라온 파일 담기
            let files = e.target.files;
            fileArr = Array.prototype.slice.call(files);

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
                    $('#fileChange').append(addHtml(fileNum, f.name, f.size));
                    fileNum ++;
                };
                reader.readAsDataURL(f);
            });
            console.log(fileArr);
            $("#input_file").val("")

        }

        const addHtml=(fileNum, name, size)=>{
            let tempHtml = `<div id='file-\${fileNum}' onclick='fileDelete(file-\${fileNum})'>
                                <font style='font-size:12px'>  \${name}  size:  \${size}  </font>
                            <div/>`
            return tempHtml;
        }

        const postFile = (fileArr)=> {
            console.log("==== postFile 진입 ====")

            let formDataArr = new FormData();
            formDataArr.append("key", "value");
            for(i of fileArr){
                console.log(i)
                formDataArr.append("files",i)
            }
            console.log(formDataArr);

            $.ajax({
                url:"/file",
                method:'POST',
                data : formDataArr,
                processData: false,
                contentType: false,
                success : function(data) {
                    console.log(data)
                },
                error : function(request, status, error) {
                    alert("code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + error);
                }

            })

        }

    </script>
</body>
</html>