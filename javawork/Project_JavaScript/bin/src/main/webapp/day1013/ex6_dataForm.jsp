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
<h5> 폼태그 post 방식으로 읽기 </h5>
<form action = "./ex6_dataRead.jsp" method="post">
    이름 : <input type ="text" name = "myName"><br>
    운전면허 : <label><input type="checkbox" name = "license">운전면허</label><br>
    성별 :
    <label><input type="radio" name = "gender" value="남자" checked="checked">남자</label>
    <label><input type="radio" name = "gender" value="여자">여자</label>
    주거지 :
    <select name = "home">
        <option>서울</option>
        <option>부산</option>
        <option>제주</option>
        <option>대구</option>
    </select>
    <br><br>
    <input type="submit" value="서버로 전송">
</form>
</body>
</html>
