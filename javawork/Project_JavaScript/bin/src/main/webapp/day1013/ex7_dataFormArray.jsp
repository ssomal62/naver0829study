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
<form action="ex7_dataRead.jsp" method="post">

    <h6>구현 가능한 언어를 모두 선택하세요</h6>
    <select name = "lang" style="width: 150px;" multiple size="10">
        <option>자바</option>
        <option>HTML5</option>
        <option>JSP</option>
        <option>JS</option>
        <option>jQuery</option>
        <option>React</option>
        <option>Vue</option>
        <option>Oracle</option>
        <option>TypeScript</option>
        <option>Mysql</option>
    </select>
    <br><br>
    <h6>취미를 모두 골라보세요</h6>

    <label><input type="checkbox" name="hobby" value="게임">게임</label>
    <label><input type="checkbox" name="hobby" value="낚시">낚시</label>
    <label><input type="checkbox" name="hobby" value="쇼핑">쇼핑</label>
    <label><input type="checkbox" name="hobby" value="음악">음악</label>
    <label><input type="checkbox" name="hobby" value="여행">여행</label>

    <br><br>
    <button type="submit">서버로 전송</button>
</form>
</body>
</html>
