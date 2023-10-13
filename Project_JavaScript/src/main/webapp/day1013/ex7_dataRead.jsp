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

<%
    String[] langR = request.getParameterValues("lang");
    String[] hobbyR = request.getParameterValues("hobby");
%>

<body>
<h5>
    구현 가능 언어 갯수 : <%= langR == null ? 0 : langR.length %>
    <%
        if (langR != null) {
            for (String s : langR) {%>
                <b style="margin-left : 30px; color : red;"><%=s%></b>
            <% }
            }
            %>

    <br>
    선택한 취미 갯수 : <%=hobbyR == null ? 0 : hobbyR.length%>
    <%
        if (hobbyR != null) {
            for (String s : hobbyR) {%>
    <b style="margin-left : 30px; color : red;"><%=s%></b>&nbsp
    <% }
    }
    %>
</h5>
</body>
</html>
