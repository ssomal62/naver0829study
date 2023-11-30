<%@ page import="student.data.StudentDao" %>
<%@ page import="student.data.StudentDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String search = request.getParameter("search");
    StudentDao dao = new StudentDao();

    List<StudentDto> list = dao.searchStudent(search);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    JSONArray arr = new JSONArray();

    for(StudentDto dto : list){

        JSONObject ob = new JSONObject();

        ob.put("id",dto.getId());
        ob.put("name",dto.getName());
        ob.put("age",dto.getAge());
        ob.put("phone",dto.getPhone());
        ob.put("mbti",dto.getMbti());
        ob.put("date",sdf.format(dto.getDate()));

        arr.add(ob);
    }
%>

<%=arr.toString()%>