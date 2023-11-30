<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Title</title>
    <style>
        ul.menu a:link, a:visited{
            color : sienna;
            font-size: 16px;
            text-decoration: black;
        }
        ul.menu{
            list-style: none;
            width: 900px;
            height: 60px;
            margin: auto;
            line-height: 60px;
            border: 1px double sienna;
            border-radius: 50px;
        }

        ul.menu li{
            float: left;
            width: 150px;
            font-size: 20px;
            margin-left:10px;
            cursor: pointer;
        }
    </style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<body>
<div class="menu_frame">
<ul class="menu">
    <li>
        <a href="${root}/">HOME</a>
    </li>
    <li>
        <a href="${root}/member/list">MEMBER LIST</a>
    </li>
    <li>
        <a href="${root}/board/list">BOARD</a>
    </li>
    <li>
        <a href="${root}/guest/list">GUEST BOOK</a>
    </li>
    <li>
        <a href="${root}/map">LOCATION</a>
    </li>
</ul>
</div>

</body>
</html>
