<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h2>폼 #1 결과 출력</h2>
<h3>
이름 : ${mdto.name}<br>
핸드폰 : ${mdto.hp}<br>
주소 : ${mdto.addr}<br>
파일명 : ${mdto.photo}<br>

</h3>
<hr>
    <c:forTokens var = "photo" items="${mdto.photo}" delims = "," varStatus="n">
        <div style="font-size: 20px">
            ${n.count}/${photo}<br>
            <img src = "../photo/${photo}" width="200">
            <hr>
        </div>
    </c:forTokens>


</body>
</html>
