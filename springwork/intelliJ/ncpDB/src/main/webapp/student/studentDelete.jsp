<%@ page import="student.data.StudentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    int id = Integer.parseInt(request.getParameter("id"));

    StudentDao dao = new StudentDao();

    dao.deleteStudent(id);
%>