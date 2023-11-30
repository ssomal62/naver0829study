<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String pass = request.getParameter("pass");

    if(pass.equals("1234")){
        Cookie cookie = new Cookie("loginok","yes");

        cookie.setMaxAge(60*60);

        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect("loginmain.jsp");
    } else { %>
    <script>
        alert("비밀번호가 맞지 않습니다.");
        history.back();
    </script>
    <% }

%>
