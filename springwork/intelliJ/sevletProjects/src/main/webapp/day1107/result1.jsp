
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>서블릿으로부터 전달받은 데이터 출력</h2>
<h4>메시지 : ${message},${requestScope.message}</h4>
<h4>날짜 : ${today}</h4>

<h4>날짜 : <fmt:formatDate value = "${today}" pattern = "yyyy-MM-dd HH:mm"/></h4>
<h4><fmt:formatDate value = "${today}" pattern = "yyyy-MM-dd EEEE a HH:mm"/></h4>
<h4><fmt:formatDate value = "${today}" pattern = "yyyy-MM-dd EEE HH:mm:ss"/></h4>
<h4><fmt:formatDate value = "${today}" type = "date"  dateStyle ="short"/></h4>
<h4><fmt:formatDate value = "${today}" type = "both"  dateStyle ="long"/></h4>

<hr>
<table class = "table table-bordered" style="width:400px">
    <caption align="top">[전체출력 #1]</caption>
    <tr>
    <th>count</th>
    <th>index</th>
    <th>color</th>
    </tr>
    <c:forEach var="s" items="${list}" varStatus="n">
    <tr>
        <td>${n.count}</td>
        <td>${n.index}</td>
        <td style="color:${s}">${s}</td>
    </tr>
    </c:forEach>

    <hr>
    <table class = "table table-bordered" style="width:400px">
        <caption align="top">[부분 출력 #2]</caption>
        <tr>
            <th>count</th>
            <th>index</th>
            <th>color</th>
        </tr>
        <%--1번 인데스 ~3번 인덱스 부분적으로 출력--%>
        <c:forEach var="s" items="${list}" begin="2" end="4" varStatus="n">

            <tr>
                <td>${n.count}</td>
                <td>${n.index}</td>
                <td style="color:${s}">${s}</td>
            </tr>
        </c:forEach>
</table>
    <hr>
    <h3>0~100까지 10단위로 출력</h3>
    <c:forEach var="n" begin="0" end="100" step="10">
    <b>${n}</b> &nbsp;
    </c:forEach>
</body>
</html>
