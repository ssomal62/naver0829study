<%@ page import="myshop.data.myshopDAO" %>
<%@ page import="myshop.data.myShopDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

    //한글 엔코딩
    request.setCharacterEncoding("utf-8");

    //dto,dao 선언
    String num = request.getParameter("num");

    myshopDAO dao= new myshopDAO();
    myShopDTO dto = dao.getProduct(num);

    //num포함 모든 데이터 읽기
    String productName = request.getParameter("productName");
    String color = request.getParameter("color");
    int price = Integer.parseInt(request.getParameter("price"));
    int photo = Integer.parseInt(request.getParameter("photo"));

    String name= dto.getProductName();

    //dto에 담기
//    dto.setProductName(productName);
//    dto.setColor(color);
//    dto.setPrice(price);
//    dto.setPhoto(photo);


    //updateShop 메서드 호출
    //dao.updateProduct(dto);

    //myshopdetail.jsp 이동하기(?로 num 넘겨야함)
    //response.sendRedirect("myshop.jsp?");

%>

<html>
<body>

<h5><%=name%></h5>
<h5>넘자리<%=num%></h5>
<h5><%=dto.getColor()%></h5>
<h5><%=dto.getPhoto()%></h5>


</body>
</html>
