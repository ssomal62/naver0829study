<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-16
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5> include : 다른 파일의 실행결과를 현재파일에 포함시킨다.</h5>

<hr>
<h5>구구단</h5>

<jsp:include page="../day1013/index2.jsp"/>
<hr>
<jsp:include page="../day1013/Ex4_list.jsp"/>
</body>
</html>
