<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Title</title>
    <style>
        body * {
            font-family: "Noto Sans KR";
        }

        div.list .box {
            width: 400px;
            height: 100px;
            margin-bottom: 10px;
            border: 2px solid gray;
            border-radius: 30px;
            box-shadow: 3px 3 xp 3 xp gray;
            padding: 10px;
        }



    </style>
</head>

<script type="text/javascript">
    $(function () {



        list();


        $("#upload").change(function () {
            let form = new FormData();
            form.append("upload", $("#upload")[0].files[0]);//선택한 1개의 파일만 추가


            $.ajax({
                type       : "post",
                dataType   : "text",
                url        : "./addphoto",
                processData: false,
                contentType: false,
                data       : form,
                success    : function (res) {
                    //alert(res);//랜덤 파일명 확인후 이미지 출력
                    $(".photo80").attr("src", res);
                }
            });
        });

        $("#btnsend").click(function () {

            let title = $("#title").val();

            if (title.length == 0) {
                alert("제목을 입력해주세요");
                return;
            }

            $.ajax({
                type    : "post",
                dataType: "text",
                url     : "./adddb",
                data    : {"title": title},
                success : function (res) {
                    list();
                    $("#title").val("");
                }
            });
        });

        $(document).on("mouseover",".photo150", function (){
            $(this).next().css("display","block");
        });
        $(document).on("mouseout",".photo150", function (){
            $(this).next().css("display","none");
        });
        $(document).on("mouseover",".photo_or", function (){
            $(this).next().css("display","block");
        });
        $(document).on("mouseout",".photo_or", function (){
            $(this).next().css("display","none");
        });

        //삭제
        $(document).on("click",".photodel", function () {
            let num = $(this).attr("num");

            $.ajax({
                type    : "get",
                dataType: "text", //delete에서 반환이 없으므로 텍스트로 보내도 무관
                url     : "./delete",
                data : {"num": num},
                success : function (res) {
                    list();
                }

            });
        });
    });

    function list() {
        $.ajax({
            type    : "get",
            dataType: "json",
            url     : "./list",
            success : function (res) {

                let s = "";

                $.each(res, function (idx, item) {
                    s +=
                        `
                             <div class = "box">
                               <img height="80" onerror="this.src = '../res/upload/noimg.png'" src = "\${item.photo80}" width="80" align="left" hspace="10">
                                <span>\${item.title}</span>
                                <span style="margin-left:20px;cursor:pointer;color:red;" class="photodel" num="\${item.num}">삭제</span>
                                <br>
                                <div class = "photo150" style="cursor: pointer"> 150 사진확인 </div>
                                <div class = "photo1" style="display: none">
                                    <img src = "\${item.photo150}">
                                </div>
                                <div class = "photo_or" style="cursor: pointer"> 원본사진 확인 </div>
                                <div class = "photo2" style="display: none">
                                    <img src = "\${item.photo}">
                                </div>
                            </div>
                             `;
                });

                $("div.list").html(s);
            }
        });
    }
</script>
<body>
<h4>스토리지에 사진 올리기</h4>
<div class="input-group" style="width:600px;">
    <input type="text" id="title" style="width: 200px;" class="form-control" placeholder="제목넣기">
    <input type="file" id="upload" style="width: 200px;" class="form-control">
    <button type="button" id="btnsend">서버전송</button>
</div>
80X80 사진만 확인 : <img src="" class="photo80">
<div class="list" style="margin:20px;">목록</div>
</body>
</html>
