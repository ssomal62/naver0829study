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
<h3 class = "alert alert-danger">Spring REST 예제들</h3>

<ul>
    <li>
        <a href="./memo/list">간단한 메모 - 사진 1장 업로드 포함</a>
    </li>

    <li>
        <a href="./storage/form">네이버 스토리지에 사진 올려보기 연습</a>
    </li>

    <li>
        <a href="./storage/common">네이버 스토리지에 사진 DB 저장</a>
    </li>
</ul>

<h5>150 변환 미리보기</h5>

<img src = "https://9oeebhfl1647.edge.naverncp.com/d9GVC7yhi3/photo/003.png?type=f&w=150&h=150&faceopt=true&ttype=jpg">

<h5>원본 사진</h5>

<img src = "https://kr.object.ncloudstorage.com/bitcamp701aiur/photo/003.png">

</body>
</html>
