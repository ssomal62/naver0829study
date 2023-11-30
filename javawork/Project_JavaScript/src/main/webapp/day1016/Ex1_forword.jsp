<%@ page import="java.util.Vector" %>
<%@ page import="data.shopDTO" %>
<%@ page import="java.util.List" %>
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
<!--
jsp에서 페이지 이동하는 방법
1. forword : url주소 안바뀜, request, response 등이 그대로 전달됨
2. redirect  : url 주소 바뀜 request, reponse 등이 새로 생성되므로 전달 안됨
-->

<h3> forword를 이용해서 페이지 이동하기</h3>

<%
    //request에 데이터를 저장해보자
    String msg = "apple";
    List<shopDTO> list = new Vector<>();
    list.add(new shopDTO("상품1", "14", 23000, "red"));
    list.add(new shopDTO("상품2", "18", 14000, "black"));
    list.add(new shopDTO("상품3", "20", 49000, "blue"));
    list.add(new shopDTO("상품4", "29", 88000, "pink"));
    list.add(new shopDTO("상품5", "5", 109000, "green"));

    request.setAttribute("msg",msg);
    request.setAttribute("list",list);
%>

<jsp:forward page="Ex2_forword.jsp"/>
</body>
</html>
