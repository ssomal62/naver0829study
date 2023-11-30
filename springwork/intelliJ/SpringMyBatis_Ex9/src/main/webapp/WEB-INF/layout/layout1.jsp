<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Title</title>
    <style>

        body * {
            font-family: "Noto Sans KR";
            color: sienna;
        }

        div.main_container div{
            border: 0px solid gray;

        }

        a:link, a:visited{
            color : sienna;
            text-decoration: black;
        }

        div.main_container div.header{
            width: 100%;
            height: 200px;
            text-align: center;
            font-size: 16px;
            font-weight: bold;
        }
        div.main_container div.menu{
            text-align: center;
            width : 100%;
        }

        div.main_container div.info{
            width: 20%;
        }

        div.main_container div.home{
            margin-left: 20%;
            margin-right: 20%;
            width : 60%;
        }


    </style>
</head>
<body>

<div class="login">
    <tiles:insertAttribute name="login"/>
</div>

<div class="main_container">

    <div class="header">
        <!--tilesder.xml에 정의된 name을 사용해야함-->
        <tiles:insertAttribute name="header"/>

    </div>
    <div class="menu">
        <tiles:insertAttribute name="menu"/>
    </div>

    <div class="info">
        <tiles:insertAttribute name="info"/>
    </div>

    <div class="home">
        <tiles:insertAttribute name="home"/>
    </div>

</div>
</body>
</html>
