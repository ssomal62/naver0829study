<%@ page import="student.data.StudentDao" %>
<%@ page import="student.data.StudentDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String phone = request.getParameter("phone");
    String mbti = request.getParameter("mbti");


    StudentDao dao = new StudentDao();
    StudentDto dto = new StudentDto();

    dto.setName(name);
    dto.setAge(age);
    dto.setPhone(phone);
    dto.setMbti(mbti);

    dao.insertStudent(dto);
%>