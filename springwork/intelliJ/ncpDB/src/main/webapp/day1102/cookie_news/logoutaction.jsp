<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    Cookie[] cookies=request.getCookies();
    if(cookies != null){
        for(Cookie ck:cookies){
            if(ck.getName().equals("loginok")){
                //ck의 유지 시간과 pass 다시 지정
                ck.setMaxAge(0);
                ck.setPath("/");

                //브라우저에 다시 저장
                response.addCookie(ck);
                break;
            }
        }
    }
    response.sendRedirect("loginmain.jsp");
%>