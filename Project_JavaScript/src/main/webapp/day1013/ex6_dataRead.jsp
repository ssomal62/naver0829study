<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-13
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    //post 방식의 한글 인코딩 (사실 나는 왜 한글이 안깨지는지 모르겠다만..) 출력 전에 넣어야함
    request.setCharacterEncoding("utf-8");
    //post 방식의 폼데이터 읽기
    String nameR = request.getParameter("myName");
    String licenseR = request.getParameter("license"); //체크 on, 체크해제 null
    String genderR = request.getParameter("gender");
    String homeR = request.getParameter("home");
%>
<body>
<pre style="font-size: 2em">
    이름 : <%=nameR%>
    운전면허 : <%=licenseR == null? "없음" : "있음"%>
    성별 : <%=genderR%>
    주거지 : <%=homeR%>
</pre>
</body>
</html>
