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
<%
    //jsp:param 으로 한글을 전달시 현재 페이지에서 encoding을 해줘야 한다.
    request.setCharacterEncoding("utf-8");
%>
<jsp:forward page="Ex4_forword.jsp">
    <jsp:param value="../29cm/1.jpg" name="photo"/>
    <jsp:param value="Hello! 안녕" name="msg"/>
</jsp:forward>
</body>
</html>
