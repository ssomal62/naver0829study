
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body * {
	    font-family: "Noto Sans KR";
            font-size: 20px;
        }


    </style>
</head>


<body>
<div class="input-group">
    <form action="loginaction.jsp" method="post">
        <div class="input-group">
        <b>암호 입력</b>
        <input type="password" class="form-control" style="width:200px; margin-left: 10px;" name="pass">
        <button type = "submit" class = "btn btn-sm btn-danger">로그인</button>
        </div>
    </form>
</div>
</body>
</html>
