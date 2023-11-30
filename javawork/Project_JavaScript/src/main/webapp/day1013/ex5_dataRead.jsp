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

<%
    //get 방식 폼데이터 읽기
    String name = request.getParameter("myName"); //input 태그의 name에 입력한 값을 문자열 형식으로 반환한다.
    String currentPage = request.getParameter("currentPage");
    String message = request.getParameter("message");

%>
<body>
<h5>jsp Action(get방식)으로 Form에서 입력한 값 출력 : 톰캣 8부터 한글 인코딩 지원</h5>
<pre style="font-size: 2em">
    이름 : <%=name%>
    페이지 : <%=currentPage%>
    메세지 : <%=message%>
</pre>
</body>
</html>
