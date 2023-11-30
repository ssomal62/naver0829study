<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body * {
            font-family: "Noto Sans KR";
            font-size: 20px;
        }


    </style>
    <script>
        $(function () {

        });

    </script>
</head>


<body>
<div class ="input-group" style="width: 300px;">
    <h3>고객님이 로그인중입니다.</h3>
    <button type="button" class ="btn btn-danger" style="width: 100px; margin-left: 20px;"
            onclick="location.href='loginaction.jsp'">로그아웃</button>
</div>
</body>
</html>