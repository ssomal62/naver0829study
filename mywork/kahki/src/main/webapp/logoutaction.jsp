
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //loginok 세션 제거
    session.removeAttribute("loginCheck");

    //메인페이지로 이동
    response.sendRedirect("loginmain.jsp");
%>


