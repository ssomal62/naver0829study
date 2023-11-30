<%@ page import="java.time.LocalDate" %>
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
    </style>
</head>
<body>

<form action="ex9_dataRead.jsp" method="post">
    <h5>폼데이터를 읽어서 출력</h5>
    <h6>테두리선 종류를 선택</h6>
    <label><input type="radio" name="line" value="3px solid black" checked="checked">실선</label>
    <label><input type="radio" name="line" value="3px dotted skyblue">점선</label>
    <label><input type="radio" name="line" value="3px double tomato">겹선</label>
    <label><input type="radio" name="line" value="3px groove brick">그루브선</label>

    <h5>사진을 선택해 주세요</h5>
    <select class="form-select" style="width: 120px" name = "photo">
        <option value="../29cm/10.jpg">상품1</option>
        <option value="../29cm/11.jpg">상품2</option>
        <option value="../29cm/12.jpg">상품3</option>
        <option value="../29cm/13.jpg">상품4</option>
        <option value="../29cm/14.jpg">상품5</option>
    </select>
    <br>

    <button type="submit" class="btn btn-outline-danger">서버에 전송</button>

    <h5>날짜를 선택해주세요.</h5>







</form>
</body>
</html>
