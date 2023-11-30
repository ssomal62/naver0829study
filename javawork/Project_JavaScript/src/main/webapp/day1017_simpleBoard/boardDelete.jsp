<%@ page import="simpleBoard.SimpleBoardDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%
    String num = request.getParameter("num");

    SimpleBoardDao dao = new SimpleBoardDao();

    dao.deleteBoard(num);

    response.sendRedirect("list.jsp");

%>