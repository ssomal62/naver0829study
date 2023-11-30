<%@ page import="org.json.simple.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String name = request.getParameter("name");
    String addr = request.getParameter("addr");

    JSONObject ob = new JSONObject();
    ob.put("name", name);
    ob.put("addr", addr);
    ob.put("age", "33세");
%>
<%=ob.toString()%>