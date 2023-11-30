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
    String myName =  request.getParameter("name");
    String scoreJava =request.getParameter("java");
    String scoreJsp = request.getParameter("jsp");
    String scoreSpring = request.getParameter("spring");
    String hp1 = request.getParameter("hp1");
    String hp2 = request.getParameter("hp2");
    String textColor = request.getParameter("tcolor");
    String backColor = request.getParameter("bcolor");

    int sum = Integer.parseInt(scoreJava)+Integer.parseInt(scoreJsp)+Integer.parseInt(scoreSpring);
    double avg = sum/3.0;

%>
<body>

<div style="width: 400px; border: 1px solid black; background-color:<%=backColor%> ; color : <%=textColor%>;" >
    <div>이름 : <%=myName%> </div>
    <div>총합 : <%=sum%> </div>
    <div>평균 : <%=avg%> </div>
    <div>휴대폰 : 010-<%=hp1%>-<%=hp2%> </div>
</div>


</body>
</html>
