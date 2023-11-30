<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //loginok 세션 제거
    session.removeAttribute("loginok");

    //메인페이지로 이동
    response.sendRedirect("loginmain.jsp");
%>


