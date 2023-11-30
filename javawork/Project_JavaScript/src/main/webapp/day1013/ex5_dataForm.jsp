<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-13
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body * {
            font-family: "Noto Sans KR";
        }
    </style>
</head>
<body>
<h5>폼 태그 action으로 읽기</h5>
<form action = "./ex5_dataRead.jsp" method="get">
    이름 : <input type = "text" name = "myName"><br>
    페이지번호 : <input type = "number" name = "currentPage" value="1"><br>
    메세지 : <input type = "text" name = "message"><br>
    <button type="submit">서버로 전송</button>
</form>
</body>
</html>
