<%@ page import="java.util.Vector" %>
<%@ page import="data.shopDTO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-13
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
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
        div.box {
            width: 80px;
            height: 80px;
            border: 1px solid black;
            text-align: center;
            line-height: 150px;
        }
        .photo{
            width: 150px;
            height: 150px;
            border-radius: 10px;
        }
    </style>

</head>
<body>


<%
    List<shopDTO> list = new Vector();
    list.add(new shopDTO("상품1", "14", 23000, "red"));
    list.add(new shopDTO("상품2", "18", 14000, "black"));
    list.add(new shopDTO("상품3", "20", 49000, "blue"));
    list.add(new shopDTO("상품4", "29", 88000, "pink"));
    list.add(new shopDTO("상품5", "5", 109000, "green"));
%>


<table class="table table-bordered" style="width: 500px;">
    <tr style="text-align: center">
        <th style="width: 100px">번호</th>
        <th style="width: 200px">상품명</th>
        <th style="width: 100px">가격</th>
        <th style="width: 300px">사진</th>
        <th style="width: 100px">색상</th>

    </tr>
    <%
        int n = 0;
        for (shopDTO dto : list) {
    %>
    <tr>
        <td><%=++n%></td>
        <td><%=dto.getProduct()%></td>
        <td><%=dto.getPrice()%></td>
        <td><img src = "../29cm/<%=dto.getPhoto()%>.jpg" class="photo"></td>
        <td><div class="box" style="background-color: <%=dto.getColor()%>";></div> </td>
    </tr>
    <% }
    %>
</table>

</body>
</html>
