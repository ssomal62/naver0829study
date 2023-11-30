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

<h3>POST 방식으로 각각 읽기</h3>
<form action="./process2" method = "post">
	메세지 : <input type = "text" name = "message"><br>
	아이콘 선택 : 
		<select name="product">
			<option>1.jpg</option>
			<option>3.jpg</option>
			<option>5.jpg</option>
			<option>7.jpg</option>
			<option>9.jpg</option>
		</select>
		<br>
		<button type ="submit">전송 #2</button>
</form>
</body>
</html>