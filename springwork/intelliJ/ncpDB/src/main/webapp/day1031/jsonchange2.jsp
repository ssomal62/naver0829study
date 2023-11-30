<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-31
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String name = "마이클";
    int age = 34;

    JSONObject jo = new JSONObject();
    jo.put("name",name);
    jo.put("age",age);
%>

<%=jo.toString()%>
