 <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Noto+Sans+KR&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Noto Sans KR';
   }
  
</style>
</head>
<body>
<h2>파일 한개 업로드하기</h2>

<form action = "./upload1" method = "post" enctype="multipart/form-data">
	제목 : <input type ="text" name = "title"><br>
	제목 : <input type ="file" name = "upload"><br>
	<button type = "submit">파일전송 #1</button>
	<
</form>

</body>
</html>