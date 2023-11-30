
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.example.kahki.dao.MemberDao" %>
<%@ page import="com.example.kahki.dto.MemberDto" %>


<%
    MultipartRequest multipartRequest=null;
    ServletContext context = request.getServletContext();
    String realPath = context.getRealPath("/save");
    System.out.println("realPath = " + realPath);
    int uploadSize = 1024 * 1024 * 5; // 5mb


    try {

        multipartRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8",
                new DefaultFileRenamePolicy());

        String user_id = multipartRequest.getParameter("user_id");
        String user_pw = multipartRequest.getParameter("user_pw");
        String profile_img = multipartRequest.getFilesystemName("profile");

        MemberDto dto = new MemberDto();
        MemberDao dao = new MemberDao();

        dto.setUser_id(user_id);
        dto.setUser_pw(user_pw);
        dto.setProfile_img_url(profile_img);

        dao.createMember(dto);

        response.setStatus(HttpServletResponse.SC_OK);

    }catch(Exception e){
        System.out.print("파일 업로드 오류 발생:"+e.getMessage());
        response.getWriter().write("error");
    }

%>
