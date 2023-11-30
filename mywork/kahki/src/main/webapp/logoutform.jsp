<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
</head>
<%
    String loginId=(String)session.getAttribute("loginId");
%>
<body>
<div class="input-group" style="width:400px;margin:30px 100px;">
    <h4><%=loginId %>님이 </h4>
    <button type="button" class="btn btn-danger"
            style="width:100px;margin-left:20px;"
            onclick="location.href='logoutaction.jsp'">로그아웃</button>
</div>
</body>
</html>