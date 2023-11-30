<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-31
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name ="홍길동";
    int age = 23;
    StringBuffer sb = new StringBuffer();
    sb.append("{\"name\":\""+name+"\",");
    sb.append("\"age\":"+age+"}");

%>

<%=sb.toString()%>