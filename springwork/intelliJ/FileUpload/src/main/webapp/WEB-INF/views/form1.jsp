<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
    <style>
        body * {
            font-family: "Noto Sans KR";
        }
    </style>
</head>
<body>
<h3> Get방식으로 데이터 읽기</h3>
<form action="./process1" method="get">
    이름 : <input type = "text" name = "name"><br>
    주소 : <input type = "text" name = "addr"><br>
    나이 : <input type = "text" name = "age"><br>
    <button type = "submit">전송 #1</button>
</form>
</body>
</html>
