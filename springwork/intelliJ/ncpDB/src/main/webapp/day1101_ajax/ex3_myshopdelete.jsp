<%@ page import="myshop.data.MyShopDao" %><%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-01
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //num
    String num = request.getParameter("num");
    //dao

    MyShopDao dao = new MyShopDao();


    //delete
    dao.deleteShop(num);

%>