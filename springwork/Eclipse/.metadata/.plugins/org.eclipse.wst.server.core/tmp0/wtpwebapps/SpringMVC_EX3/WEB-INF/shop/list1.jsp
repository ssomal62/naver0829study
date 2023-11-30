<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Noto+Sans+KR&family=Permanent+Marker&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Noto Sans KR';
}

.photo {
	width: 180px;
	padding: 10px;
	border: 1px solid #e7e7e7;
	border-radius: 10px;
	float: left;
	margin: 10px;
	align-items: center;
}

.photo img {
	width: 160px;
	border-radius: 10px;
}
</style>
</head>
<body>
	<h3 class="alert alert-info">${shopinfo}</h3>
	<h3>총 ${count}개의 상품이 있습니다.</h3>
	<hr>

	<c:forEach var="dto" items="${list}">
		<div class="photo">
			<figure>
				<img src="../res/shop/${dto.photo}">
				<figcaprion>
				<h5>${dto.sang}</h5>
				<h6>
					<fmt:formatNumber value="${dto.price}" type="number" />원
				</h6>
				</figcaprion>
			</figure>
		</div>
	</c:forEach>

</body>
</html>