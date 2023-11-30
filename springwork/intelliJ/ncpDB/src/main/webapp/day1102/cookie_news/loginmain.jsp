<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body * {
	    font-family: "Noto Sans KR";
            font-size: 20px;
        }


    </style>
    <script>
        $(function () {

        });

    </script>
</head>


<%
    Cookie[] cookies = request.getCookies(); // 배열로 반환됨.
    boolean find = false;
    if(cookies != null){
        for(Cookie ck : cookies){
            String name = ck.getName();
            if(name.equals("loginok")){
                find = true; //해당 쿠키가 존재하먼 true
            }
        }
    }
%>
<body>

<div style="margin: 30px;">
    <%
        //find가 트루일경우 이미 로그인을 했다는 의미이다. 그래서 로그아웃폼을 나타낸다.
        if(find){%>
    <jsp:include page="logoutform.jsp"/>
    <%}else{%>
    <jsp:include page="loginform.jsp"/>
    <%}%>
    <hr width="500">
    <!-- 뉴스 기사 인클루드-->
    <jsp:include page="paper.jsp"/>

</div>

</body>
</html>