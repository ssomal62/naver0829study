<%@ page import="myshop.data.myshopDAO" %>
<%@ page import="myshop.data.myShopDTO" %>
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
//한글 엔코딩
request.setCharacterEncoding("utf-8");

//dao, dto선언

    myshopDAO dao = new myshopDAO();
    myShopDTO dto = new myShopDTO();

    String productName = request.getParameter("productName");
    String color = request.getParameter("color");
    int photo = Integer.parseInt(request.getParameter("photo"));
    int price = Integer.parseInt(request.getParameter("price"));

    dto.setProductName(productName);
    dto.setColor(color);
    dto.setPhoto(photo);
    dto.setPrice(price);


    dao.insertShop(dto);

    response.sendRedirect("myshop.jsp");
%>
</body>
</html>
