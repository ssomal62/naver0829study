<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap"
          rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
    <script>

    </script>
</head>
<body>

<h5>자바 배열의 값을 테이블로 출력해보자</h5>
<%
    String[] arr1 = {"red", "blue", "green"};
%>
<table class="table table-bordered" style="width:200px;">
    <tr>
        <th width="50">NO</th>
        <th>Color</th>
    </tr>

    <%
        for (int i = 0; i < arr1.length; i++) {
    %>
            <tr>
                <td align="center"><%=i+1%></td>
                <td style="color : <%=arr1[i]%>"><%=arr1[i]%></td>
            </tr>
    <%
        }
    %>

</table>

</body>
</html>