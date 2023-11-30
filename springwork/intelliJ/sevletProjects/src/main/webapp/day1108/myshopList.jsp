
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<html>
<head>
    <title>Title</title>
    <style>
        body * {
            font-family: 'Noto Sans KR';
        }
        .photo{
            width: 180px;
            padding: 10px;
            border: 1px solid #e7e7e7;
            border-radius: 10px;
            float: left;
            margin: 10px;
            align-items: center;
        }
        .photo img{
            width: 160px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<h3 class="alert alert-success">myshopList Success</h3>
<h5>총 ${total} 개의 상품이 있습니다.</h5>
<h6>방송 날짜 : <fmt:formatDate value="${today}" pattern="yyy-MM-dd HH:mm EEEE"/> </h6>
<hr>
<c:forEach var="dto" items="${list}" varStatus="n">
    <div class="photo">
        <figure>
            <img src = "../../image/29cm/${dto.photo}">
        </figure>

    <figcaption>
        <span>
            상품번호<br>
            ${dto.num}<br>
            상품명<br>
            ${dto.sangpum}<br>
            가격<br>
            <fmt:formatNumber value="${dto.price}" type="currency" currencySymbol= "￦" maxFractionDigits="0"/><br>
            색상<br>
            <b style ="background-color: ${dto.color}">${dto.color}</b><br>

        </span>
    </figcaption>
    </div>
</c:forEach>
</body>
</html>
