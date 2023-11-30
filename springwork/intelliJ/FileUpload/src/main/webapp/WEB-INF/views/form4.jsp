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
<form action="./process4" method="post">

    상품명 <input type = "text" name = "sang"><br>
    사진 :
    <select name = "photo">
        <option>8.jpg</option>
        <option>16.jpg</option>
        <option>24.jpg</option>
    </select>

    <br>
    수량 : <input type = "text" name = "su"><br>
    단가 : <input type = "text" name = "dan"><br>
    색상 : <input type = "text" name = "color" value="#ccffcc"><br>

    <button type = "submit">전송 #4</button>
</form>

</body>
</html>
