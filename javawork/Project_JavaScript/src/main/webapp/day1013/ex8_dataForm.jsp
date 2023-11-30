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
<form action="ex8_dataRead.jsp" method="post">

    <table class = "table table-bodered" style="width: 400px">
        <tr>
            <th style="width: 100px">이름</th>
            <td><input type="text" name ="name" class="form-control" required="required" autofocus="autofocus"></td>
        </tr>
        <tr>
            <th style="width: 100px">점수</th>
            <td class="input-group">
                <input type="number" name="java" value="0" step="10" class="form-control">
                <input type="number" name="jsp" value="0" step="10" class="form-control">
                <input type="number" name="spring" value="0" step="10" class="form-control">
            </td>
        </tr>
        <tr>
            <th style="width: 100px">핸드폰</th>
            <td class="input-group">
                <select class="form-select" name = "hp1" style="width: 30px">
                    <option>010</option>
                    <option>02</option>
                    <option>031</option>
                </select>
                <input type="text" class="form-control" name = "hp2" placeholder="나머지 번호 입력">
            </td>
        </tr>

        <tr>
            <th style="width: 100px">색상</th>
            <td class="input-group">
             <b>글자색</b><input type="color" name = "tcolor" value="#cccccc" class="form-control">&nbsp;&nbsp;
             <b>배경색</b><input type="color" name = "bcolor" value="#ffffff" class="form-control">&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" class="btn btn-outline-danger">서버에 전송</button>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
