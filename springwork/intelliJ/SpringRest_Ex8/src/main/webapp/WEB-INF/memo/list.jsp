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

        .memoform{
            position: absolute;
            top: 150px;
            left: 50px;
        }

        .memolist{
            position: absolute;
            top: 150px;
            left: 400px;
        }

        .photo, .photo2{
            width: 120px;
            border: 1px solid gray;
            border-radius: 10px;
        }

        .camraupload{
            font-size: :30px;
            cursor: pointer;
        }

        .div box{
            width: 500px;
            height: 200px;
            padding: 10px;
            border: 2px solid gray;
            margin-bottom: 10px;
            border-radius: 20px;
        }
    </style>
    <script type="text/javascript">
        $(function (){

            list();

            $(".camraupload").click(function (){
                $("#upload").trigger("click");
            });

            $("#upload").change(function (){
               let form = new FormData();
               form.append("upload", $("#upload")[0].files[0]);

               /*
               processData : false : 서버에 전달하는 데이터는 query string 이라는 형태로 전달된다.
               파일전송의 경우 이를 하지 않아야하는데 그 설정이 false.
               contentType : false : enctype이 원래 기본값이 application/x-www.... 이거인데
               multipart/form-data로 변경해준다.
                */

               $.ajax({
                   type:"post",
                   dataType:"text",
                   url:"./upload",
                   processData : false,
                   contentType : false,
                   data: form,

                   success:function (res){
                       // alert(res);
                        $(".photo").attr("src",`../res/upload/\${res}`);
                   }
               }) ;

            });

            $("#btnmemoadd").click(function (){

                let nick = $("#nickname").val();
                let memo = $("#memo").val();

                if(nick.length == 0){
                    alert("닉네임을 꼭 입력해주세요.");
                    return;
                }
                if(memo.length == 0){
                    alert("메모를 꼭 입력해주세요.");
                    return;
                }

                $.ajax({
                    type:"get",
                    dataType:"text",
                    url:"./add",
                    data : {"nickname": nick, "memo":memo},
                    success:function (res){
                        //다시 메모 전체 출력
                        list();

                        //입력값들 지우기
                        $("#nickname").val("");
                        $("#memo").val("");
                        $(".photo").attr("src","../res/upload/noimg.png");

                    }
                }) ;
            });

            //메모삭제
            $(document).on("click",".memodel", function (){
               let num = $(this).attr("num");
               let a = confirm("삭제하려면 확인");

               if(a){
                   $.ajax({
                       type:"get",
                       dataType:"text",
                       url:"./delete",
                       data : {"num":num},
                       success:function (res){
                           list();
                       }
                   }) ;
               }
            });

            //좋아요 수 증가
            $(document).on("click",".increlikes",function (){
               let num = $(this).attr("num");
               let $prev = $(this).prev();
               $.ajax({
                   type:"get",
                   dataType:"json",
                   url:"./likes",
                   data : {"num": num},
                   success:function (res){
                       $prev.text(res.likes);
                   }

                   });

            });

        });

        function list(){
            //전체 메모 출력해주는 함수.
            $.ajax({
                type:"get",
                dataType:"json",
                url:"./view",
                success:function (res){
                    let s = "";
                    $.each(res, function (idx, item){
                        s+=
                            `
                            <div class = "box">
                                <img src="../res/upload/\${item.photo}" class="photo2" align="left"
							hspace="20">

                                닉네임 : \${item.nickname}<br>
                                메  모 : \${item.memo}<br>
                                작성일 : \${item.writeday}<br>
                                추천수 : <span>\${item.likes}</span><span class="increlikes" style = "cursor:pointer;" num = "\${item.num}">💙</span><br>
                                <a href="#" class = "memodel" num = "\${item.num}" style="cursor: pointer; color: red;">삭제</a>
                            </div>
                            `;
                    });

                    $(".memolist").html(s);
                }
            });
        }
    </script>
</head>
<body>
<h3 class="alert alert-success">간단한 메모를 남겨봅시다</h3>
<div class="memoform">
    <span class="camraupload">📷</span>
    <input type="file" name="upload" id ="upload" style="display: none;">
    <br>
    <img src = "../res/upload/noimg.png" class = "photo">
    <input type ="text" id = "nickname" class = "form-control" style="width: 200px;"
    placeholder="닉네임 입력">
    <input type ="text" id = "memo" class = "form-control" style="width: 200px;"
           placeholder="메모">
    <button type="button" class = "btn btn-sm btn-outline-danger" id = "btnmemoadd">Memo Add</button>

</div>
<div class = "memolist">
    memo list
</div>
</body>
</html>
