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
<pre style="font-size: 20px">
    상품명 : ${dto.sangpum}
    가격 : ${dto.price}
    색상 : ${dto.color}
    입고일 : ${dto.ipgoday}
    파일명 : ${dto.filename}
    사진
    <img src = "./res/photo/${dto.filename}" style="max-width: 300px">
</pre>
</body>
</html>
