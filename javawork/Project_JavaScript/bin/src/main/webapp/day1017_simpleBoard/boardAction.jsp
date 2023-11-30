
<%@ page import="simpleBoard.SimpleBoardDao" %>
<%@ page import="simpleBoard.SimpleBoardDto" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MultipartRequest multipartRequest = null;
    String realPath = request.getServletContext().getRealPath("/save");
    int uploadSize=1024*1024*3;//3mb

    try{
        multipartRequest = new MultipartRequest(request,realPath,uploadSize,"utf-8", new DefaultFileRenamePolicy());

        SimpleBoardDao dao = new SimpleBoardDao();
        SimpleBoardDto dto = new SimpleBoardDto();

        String writer = multipartRequest.getParameter("writer");
        String subject = multipartRequest.getParameter("subject");
        String content = multipartRequest.getParameter("content");
        String photo = multipartRequest.getFilesystemName("upload");

        if(photo == null){
            photo = "no";
        }

        dto.setWriter(writer);
        dto.setSubject(subject);
        dto.setContent(content);
        dto.setPhoto(photo);

        dao.insertBoard(dto);

        response.sendRedirect("list.jsp");

    }catch (Exception e){
        System.out.print("파일업로드 오류 발생 : " + e.getMessage());
    }


%>