<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-13
  Time: 오후 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table table-bordered tb">
    <thead>
    <tr>
        <%
            for (int dan = 2; dan <= 9; dan++) {
        %>
        <th><%=dan%>단</th>

        <% }
        %>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 1; i <= 9; i++) {
    %>
    <tr><%
        for (int dan = 2; dan <= 9; dan++) {
    %>
        <td><%=dan%>×<%=i%> = <%=dan * i%>
        </td>
        <%}%>
    </tr>

    <%
        }
    %>
    </tbody>
</table>


</body>
</html>
