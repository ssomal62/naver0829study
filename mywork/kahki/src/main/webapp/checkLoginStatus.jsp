<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.json.simple.JSONObject" %>

<%
    String loginCheck = (String) session.getAttribute("loginCheck");
    String loginId = (String) session.getAttribute("loginId");


    JSONObject checkJson = new JSONObject();
    checkJson.put("loginCheck", loginCheck);
    checkJson.put("loginId", loginId);

%>


<%=checkJson.toString()%>
