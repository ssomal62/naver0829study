<%@ page import="com.example.kahki.dto.MemberDto" %>
<%@ page import="com.example.kahki.dao.MemberDao" %>
<%@ page import="com.example.kahki.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String user_id = request.getParameter("loginId");
    String user_pw = request.getParameter("loginpass");
    String saved_id = request.getParameter("saved_id");

    MemberDao memberDao = new MemberDao();
    MemberDto member = memberDao.getMemberById(user_id);


    if (member != null) {

        UserService userService = new UserService();
        boolean checkPW = userService.comparePassword(user_id, user_pw);

        if (checkPW) {

            //세션에 저장
            session.setAttribute("loginCheck", "yes");
            session.setAttribute("loginId", user_id);
            session.setAttribute("profile_img", member.getProfile_img_url());
            session.setAttribute("saveStatus", saved_id == null ? "no" : "yes");

            //유지 시간을 지정
            session.setMaxInactiveInterval(60 * 60); //1시간 유지l

            //메인 페이지로 이동
            response.sendRedirect("index.html");

        } else { %>
<script>
    alert("비밀번호가 맞지 않습니다.");
    history.back();
</script>
<%
    }
} else {
%>
<script>
    alert(<%=user_id%>)
    alert("가입하지 않은 회원입니다.");
    history.back();
</script>
<%
    }

%>










