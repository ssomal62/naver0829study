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
<h3 class='alert alert-danger'>ex4-forword 파일입니다</h3>


<%
    //jsp:param데이터는 getParameter로 읽는다.
    String photo = request.getParameter("photo");
    String msg = request.getParameter("msg");
%>

<img src = "<%=photo%>">
<h4><%=msg%></h4>
</body>
</body>
</html>
