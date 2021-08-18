<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Jsp page sample</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/main.js" ></script>
</head>
<body>

    <h1>안뇽 안뇽</h1>
    <a href="/uploader">업로더</a>

    <hr/>
    <div>
        <table>
            <tr>
                <th>제목</th>
                <td><input style="width: 500px" type="text" id="title" name="title" /></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><input style="width: 500px"  type="text"  id="content" name="content"/></td>
            </tr>
            <button onclick="writeBoard()" >제출하기</button>
        </table>
    </div>
    <hr/>
    <form action="post" id="formBox">
        <div class="wrap">
            <input type="text" name="name" id="name" value=""/>
            <input type="checkbox" name="chk" id="chk_01" value="A"/>
            <input type="checkbox" name="chk" id="chk_02" value="B"/>
            <input type="checkbox" name="chk" id="chk_03" value="C"/>
        </div>
    </form>
    <button id="chkBtn" onclick="chkBtnClick()">체크버튼</button>
    <hr/>
    <table border="1">
        <thead>
            <tr>
                <th>타이틀</th>
                <th>내용</th>
                <th>완료여부</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="boardList" items="${boardList}" >
                <tr>
                    <td><c:out value="${boardList.title}"/></td>
                    <td><c:out value="${boardList.content}"/></td>
                    <td><c:out value="${boardList.completed}"/></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</body>
<style>
    .wrap{
        display: flex;
        flex-direction: column;
    }
</style>
</html>
