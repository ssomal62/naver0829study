<%@ page import="myshop.data.myshopDAO" %>
<%@ page import="myshop.data.myShopDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
    <style>
        body * {
            font-family: "Noto Sans KR";
        }
        #photo{
            width: 25em;
            border: 1px solid #cccccc;
            border-radius: 2em;
        }
        button{
            outline: none;
        }
    </style>
</head>
<body>

<%
    String num = request.getParameter("num");
    myshopDAO dao = new myshopDAO();
    myShopDTO dto = dao.getProduct(num);
%>


<form action = "./myshopUpdate.jsp" method="post">

    <table class = "table table-bordered" style="width: 25em; margin: auto;">


        <caption align="top"><b>상품 수정</b></caption>
        <tr>
            <td align="center" width = "100">상품명</td>
            <td>
                <input type="text" name = "productName" class = "form-control"
                      value = "<%=dto.getProductName()%>" num = "<%=dto.getNum()%>" required="required" autofocus="autofocus" id = "productName" >
            </td>
        </tr>

        <tr>
            <td align="center" width = "100">색상</td>
            <td>
                <input type="color" name = "color" class = "form-control"
                       value = "<%=dto.getColor()%>" id = "color" >
            </td>
        </tr>
        <tr>
            <td align="center" width = "100">가격</td>
            <td>
                <input type="number" name = "price" class = "form-control"
                       value = "<%=dto.getPrice()%>"  id = "price"  required="required" step="500" min="1000" max="1000000">
            </td>
        </tr>
        <tr>
            <td align="center" width = "100">사진선택</td>
            <td>
                <select class = "form-select" name="photo" id="photoOption">
                    <%
                        for(int i = 1; i <= 30; i++){

                    if(dto.getPhoto() == i) { %>
                        <option value="<%=i%>" selected>상품<%=i%></option>
                    <%
                    }else{ %>
                        <option value="<%=i%>">상품<%=i%></option>
                    <% }


                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <img src = "../29cm/<%=dto.getPhoto()%>.jpg" class="photo" id = "photo">

                <script>
                    let photoOption = document.getElementById("photoOption");
                    let changeImg = document.getElementById("photo");
                    photoOption.addEventListener('change', () => {
                        changeImg.src = "../29cm/"+ photoOption.value + ".jpg";
                        changeImg.num = photoOption.value;
                    });

                </script>

            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" class="modify">DB수정</button>
                <button type="button" onclick="location.href = 'myshop.jsp'">목록 보기</button>
                <script >
                    let num1 = <%=num%>;
                    let poroductName = document.getElementById('productName').value;
                    let color = document.getElementById('color').value;
                    let price = document.getElementById('price').value;
                    let photo = document.getElementById('photo').num.value;
                    alert(num1 + poroductName + color + price +"," + photo);

                    $(document).on('click','.modify', function (){

                        let url = "myshopUpdate.jsp?num=" + num1 + "&productName=" + poroductName+ "&color=" + color+ "&price=" + price+ "&photo=" + photo;
                        alert(url);
                        location.href = url;
                    });

                </script>


            </td>
        </tr>

    </table>


</form>

</body>
</html>
