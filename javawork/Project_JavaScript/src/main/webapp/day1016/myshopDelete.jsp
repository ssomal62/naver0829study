<%@ page import="myshop.data.myshopDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    //num 읽기
    String num=request.getParameter("num");
    //dao 선언
    myshopDAO dao=new myshopDAO();
    //delete 메서드 호출
    dao.deleteShop(num);
    //myshop.jsp 로 리다이렉트로 이동
    response.sendRedirect("myshop.jsp");
%>