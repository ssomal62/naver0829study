<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Title</title>
    <style>
        .home_frame{
            margin-top: 30px;
            margin-left: 15%;
        }
        .mainphoto {

            width: 80%;
            rotate: 30deg;
            border-radius: 50%;
        }

        .text1 {
            position: absolute;
            font-size: 150px;
            font-weight: 900;
            color: sienna;
            display: flex;
            justify-items: auto;
            z-index: 10;
        }

        .text2 {
            position: absolute;
            margin-top: 100px;
            font-size: 150px;
            font-weight: 900;
            color: sienna;
            opacity: 0.7;
            display: flex;
            justify-items: auto;
            z-index: 10;
        }

        .text3 {
            position: absolute;
            margin-top: 200px;
            font-size: 150px;
            font-weight: 900;
            color: sienna;
            opacity: 0.5;
            display: flex;
            justify-items: auto;
            z-index: 10;
        }

    </style>
</head>
<c:set var = "root" value = "<%=request.getContextPath()%>"/>
<body>


<div class="home_frame">
    <span class="text1">Spring</span>
    <span class="text2">Spring</span>
    <span class="text3">Spring</span>

    <img class="mainphoto" src = "${root}/res/photo/main.jpg">
</div>
</body>
</html>
