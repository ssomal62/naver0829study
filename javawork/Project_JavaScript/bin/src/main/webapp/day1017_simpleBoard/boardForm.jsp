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
        .uploadcamera{
            font-size: 25px;
            cursor: pointer;
        }
    </style>
    <script type="text/javascript">
        $(function (){
           $(".uploadcamera").click(function (){
               $("#upload").trigger("click");
           }) ;
        });

        $("#upload").change(function () {
            console.log("1:" + $(this)[0].files.length);
            console.log("2:" + $(this)[0].files[0]);
            //정규표현식
            var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
            var f = $(this)[0].files[0];//현재 선택한 파일
            if (!f.type.match(reg)) {
                alert("확장자가 이미지파일이 아닙니다");
                return;
            }
            if ($(this)[0].files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#showimg").attr("src", e.target.result);
                }
                reader.readAsDataURL($(this)[0].files[0]);
            }
        });
    </script>
</head>
<body>
<!--이미지 출력할 곳-->
<h2>이미지를 선택하세요</h2>

<input type="file" id="myfile">
<input type="file" onchange="readUrl(this)" >

<img id="showimg"  style="position: absolute;left:600px;top:50px;max-width: 300px;">

<!--이미지 출력끝-->
<div style="margin: 30px 50px">
    <form action = "./boardForm.jsp" method="post" enctype="multipart/form-data">
        <table class = "table table-bordered" style="width: 500px">
            <caption align="top">글쓰기</caption>
            <tr>
                <th width="100">작성자</th>
                <td>
                    <input type="text" name ="writer" class = "form-control" style="width: 150px;" autofocus="autofocus" required="required">
                </td>
            </tr>
            <tr>
                <th width="100">작성자</th>
                <td class="input-group">
                    <input type="text" name ="subject" class = "form-control" required="required">
                    <input type="file" name ="upload" id = "upload" style="display: none">
                    &nbsp;&nbsp;
                    <i class="bi bi-camera-fill uploadcamera"></i>
                </td>
            </tr>
            <tr>
                <th width="100">내용</th>
                <td>
                    <textarea style="width: 100%; height: 150px;" name = "content" required="required" class = "form-control"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type = "submit" class="btn btn-outline-success" style="width : 100px;">등록</button>
                    <button type = "button" class="btn btn-outline-success" style="width : 100px;" onclick="history.back()">등록</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
