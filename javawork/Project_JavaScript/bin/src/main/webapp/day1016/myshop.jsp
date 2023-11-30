<%@ page import="myshop.data.myshopDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="myshop.data.myShopDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Title</title>
    <style>
        body * {
            font-family: "Noto Sans KR";
            margin: auto;

        }

        .shopTB thead th {
            color: darkslategrey;
        }

        div.box {
            width: 30px;
            height: 30px;
            border: 1px solid #cccccc;
            border-radius: 5px;
        }

        img.small {
            width: 50px;
            height: 50px;
            cursor: pointer;
            border: 1px solid #cccccc;
            border-radius: 5px;
            margin-right: 5px;
        }
    </style>
    <script>
        $(function (){
           //작은 이미지 클릭 시 num얻어서 myshiodetail.jsp로 이동
           $("img.small").click(function (){
              let num = $(this).attr("num");

              //location.href = "myshopDetail.jsp?num=" + num;
               location.href = `myshopDetail.jsp?num=\${num} ` ;
           });
        });
    </script>
</head>
<body>
<%
    //DAO 선언
    myshopDAO dao = new myshopDAO();
    //List 가져오기
    List<myShopDTO> list = dao.getAllProduct();
    //날짜 출락하기 위한 형식
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh시");
%>
<div style="width: 60em; height:2em;">
    <h5 class="alert alert-success" style="float: left"> 총 <%=list.size()%>개의 상품이 있습니다.</h5>
    <button type="button" class="btn btn-outline-success" style="float: right;"
            onclick="location.href='myshopInform.jsp'">상품 등록
    </button>
</div>
<div style="clear: both"></div>
<table class="table table-bordered shopTB" style="width: 60em;">
    <thead>
    <tr style="text-align: center">
        <th width="40">번호</th>
        <th width="150">상품명</th>
        <th width="30">색상</th>
        <th width="40">가격</th>
        <th width="100">등록일</th>
        <th width="30">수정</th>
        <th width="30">삭제</th>
    </tr>
    </thead>
    <tbody>
    <% int n = 0;
        for (myShopDTO dto : list) {
    %>
    <tr align="center">
        <td><%=++n%></td>
        <td align="left"><img class=  "small" src = "../29cm/<%=dto.getPhoto()%>.jpg " num = "<%=dto.getNum()%>"><%=dto.getProductName()%></td>
        <td><div class = "box" style = "background-color:<%=dto.getColor()%>;"></div></td>

        <td align="right"><%=dto.getPrice()%>원</td>
        <td><%=sdf.format(dto.getWriteDay())%></td>
        <td>
            <button type="button" class= "btn btn-sm btn-success modify"
            num = "<%=dto.getNum()%>">수정</button>
        </td>
        <td>
            <button type="button" class= "btn btn-sm btn-danger del"
            num = "<%=dto.getNum()%>">삭제</button>
        </td>
    </tr>
    <%
        }
    %>

    <script type = "text/javascript">


        $(document).on('click','.del', function() {
            let num = $(this).attr("num");
            let checkDelete = confirm("삭제?");
            if(checkDelete){
                location.href = "myshopDelete.jsp?num=" + num;
            }
        });


        $(document).on('click', '.modify', function() {
            let num = $(this).attr('num');
            location.href = "myshopUpdateForm.jsp?num=" + num;
        });


    </script>
    </tbody>


</table>

</body>
</html>
