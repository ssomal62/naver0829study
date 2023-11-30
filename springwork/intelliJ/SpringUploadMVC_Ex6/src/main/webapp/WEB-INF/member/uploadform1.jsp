<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action = "./upload1" method="post" enctype="multipart/form-data">
    이름 : <input type="text" name = "name"><br>
    사진 : <input type="file" name = "upload"><br>
    핸드폰 : <input type="text" name = "hp"><br>
    주소 : <input type="text" name = "addr"><br>
    <button type="submit">서버전송 #1</button>
</form>
</body>
</html>
