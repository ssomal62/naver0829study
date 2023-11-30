<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String loginid = request.getParameter("loginid");
    String loginpass = request.getParameter("loginpass");
    String saveid = request.getParameter("saveid");


    if(loginpass.equals("1234")) {

        //세션에 저장
        session.setAttribute("loginok","yes");
        session.setAttribute("loginid",loginid);
        session.setAttribute("savestatus", saveid == null? "no" : "yes");

        //유지 시간을 지정
        session.setMaxInactiveInterval(60*60); //1시간 유지

        //메인 페이지로 이동
        response.sendRedirect("loginmain.jsp");

    } else{ %>
<script>
    alert("비밀번호가 맞지 않습니다.");
    history.back();
</script>

<%}%>

