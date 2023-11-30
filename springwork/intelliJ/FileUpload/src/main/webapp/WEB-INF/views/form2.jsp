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
<h3>POST 방식으로 각각 읽기</h3>
<form action="./process2" method = "post">
    메세지 : <input type="text" name = "message"><br>
    아이콘 선택 :
    <select name = "product">
        <option>1.jpg</option>
        <option>2.jpg</option>
        <option>3.jpg</option>
        <option>4.jpg</option>
        <option>5.jpg</option>
    </select>
    <br>
    <button type = "submit">전송 #2</button>
</form>
</body>
</html>
