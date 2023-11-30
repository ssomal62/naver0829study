<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="com.example.kahki.dto.CommentDto" %>
<%@ page import="com.example.kahki.dao.CommentDao" %>


<%
    String event_id = request.getParameter("event_id");

    CommentDao commentDao = new CommentDao();
    List<CommentDto> comments = commentDao.getCommentsByEvent(event_id);

    JSONArray commentArray = new JSONArray();

    for (CommentDto comment : comments) {

        JSONObject commentJson = new JSONObject();
        commentJson.put("commnet_id", comment.getComment_id());
        commentJson.put("event_id", comment.getEvent_id());
        commentJson.put("user_id", comment.getUser_id());
        commentJson.put("content", comment.getContent());
        commentJson.put("commnet_date", comment.getComment_date().getTime());

        commentArray.add(commentJson);
    }
%>

<%=commentArray.toString()%>





