
<%@ page import="com.example.kahki.dto.CommentDto" %>
<%@ page import="com.example.kahki.dao.CommentDao" %>


<%


    String user_id = request.getParameter("user_id");
    String event_id = request.getParameter("event_id");
    String content = request.getParameter("content");


    CommentDao commentDao = new CommentDao();
    CommentDto comment = new CommentDto();

    comment.setEvent_id(event_id);
    comment.setUser_id(user_id);
    comment.setContent(content);

    commentDao.createComment(comment);

    response.setStatus(HttpServletResponse.SC_OK);

%>






