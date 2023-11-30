<%@ page import="myshop.data.myshopDAO" %>
<%@ page import="myshop.data.myShopDTO" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-10-16
  Time: 오후 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String num = request.getParameter("num");

    //dao 선언
    myshopDAO dao = new myshopDAO();
    //dto 얻기
    myShopDTO dto = dao.getProduct(num);
    //날짜 출력 양식
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm");
%>

<body>
<div style="margin : 30px 50px">
    <h4><b>
        <%=dto.getProductName()%></b></h4>
    <br>
    <img src = "../29cm/<%=dto.getPhoto()%>.jpg" style="width: 300px; border: 5px inset gray;" align = left hspace="20">
    <br><br><br><br>
    색상 : <b style = "color: <%=dto.getColor()%>;"><%=dto.getColor()%></b>
    <br><br>
    가격 : <%=dto.getPrice()%>원
    <br><br>
    등록일 : <%=sdf.format(dto.getWriteDay())%>

</div>

<div class = "buttons">
<button type = "button" class = "btn btn-outline-secondary" onclick="location.href='myshopUpdateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
<button type = "button" class = "btn btn-outline-secondary" onclick="location.href='myshopDelete.jsp?num=<%=dto.getNum()%>'">삭제</button>
<button type = "button" class = "btn btn-outline-secondary" onclick="location.href='myshop.jsp?num=<%=dto.getNum()%>'">목록</button>
</div>
</body>
</html>
