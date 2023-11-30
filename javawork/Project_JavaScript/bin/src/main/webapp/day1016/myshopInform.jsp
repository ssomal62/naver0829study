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
<form action = "./myshopInsert.jsp" method="post">

    <table class = "table table-bordered" style="width: 25em; margin: auto;">
        <caption align="top"><b>상품 등록</b></caption>
        <tr>
            <td align="center" width = "100">상품명</td>
            <td>
                <input type="text" name = "productName" class = "form-control"
                       required="required" autofocus="autofocus">
            </td>
        </tr>

        <tr>
            <td align="center" width = "100">색상</td>
            <td>
                <input type="color" name = "color" class = "form-control"
                       value = "#cccccc">
            </td>
        </tr>
        <tr>
            <td align="center" width = "100">가격</td>
            <td>
                <input type="number" name = "price" class = "form-control"
                       required="required" step="500" min="1000" max="1000000">
            </td>
        </tr>
        <tr>
            <td align="center" width = "100">사진선택</td>
            <td>
                <select class = "form-select" name="photo" id="photoOption">
                    <%
                        for(int i = 1; i <= 30; i++){
                    %>
                    <option value="<%=i%>">상품<%=i%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <img src = "../29cm/1.jpg" class="photo" id = "photo">

                <script>
                    let photoOption = document.getElementById("photoOption");
                    let changeImg = document.getElementById("photo");
                    photoOption.addEventListener('change', () => {
                        changeImg.src = "../29cm/"+ photoOption.value + ".jpg";
                    });
                </script>

            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">저장</button>
                <button type="button" onclick="location.href = 'myshop.jsp'">목록 보기</button>
            </td>
        </tr>

    </table>


</form>

</body>
</html>
