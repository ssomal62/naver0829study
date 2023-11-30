<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .content_main {
            margin-left: 15%;
            margin-right: 15%;
        }
        span.day {
            font-size: 16px;
            color: gray;
        }
    </style>
    <script type="text/javascript">
        $(function (){

            list();

            $("#uploadcamera").click(function (){
                $("#upload").trigger("click");
            })

            $("#upload").change(function (){

                let formData=new FormData();
                formData.append("upload",$("#upload")[0].files[0]);

                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"../answer/upload",
                    data:formData,
                    processData:false,
                    contentType:false,
                    success:function(res){
                        //업로드후에 반환받은 파일명을 댓글의 이미지에 넣어준다
                        $("img.answerphoto").attr("src","../res/upload/" + res.photoname);
                    }
                });
            })

            $("#btnansweradd").click(function (){
                let msg = $("#answermsg").val();
                let num = ${dto.num};

                if(msg.length == 0){
                    alert("댓글 내용을 입력해주세요.");
                    return;
                }
                $.ajax({
                    type:"POST",
                    dataType:"text",
                    url:"../answer/insert",
                    data : {"num":num, "msg":msg},
                    success:function (res){
                        list();
                        $("#answermsg").val("");
                        $("img.answerphoto").attr("src","../res/photo/noimage.png");
                    }
                }) ;
            });

            $(document).on('click', '#ansdel',function (){

                let ansidx = $(this).attr("num");

                $.ajax({
                    type:"POST",
                    dataType:"text",
                    url:"../answer/delete",
                    data : {"ansidx": ansidx},
                    success:function (res){
                        list();
                    }
                }) ;
            })
        });

        function list(){

            let loginok = '${sessionScope.loginok}';
            let loginid = '${sessionScope.myid}';

            let num = ${dto.num};

                $.ajax({
                    type:"GET",
                    dataType:"json",
                    url:"../answer/list",
                    data : {"num" : num},
                    success:function (res){
                        let s = "";
                        s+="<div id ='answerstart'></div>";
                        $.each(res, function (idx, item){
                            s += `
                            <div class ="input-group" style="height: 40px; ">
                                <img src = "../res/upload/\${item.ansphoto}" style="width: 30px; height: 30px; border: 1px solid darkgrey; border-radius:3px; margin-right: 10px"  onerror="this.src = '../res/photo/noimage.png'" >
                                <span style="width: 100px"><b>\${item.ansname}</b></span>
                                <span style="width: 450px">\${item.ansmsg}</span>
                                <div class = "ansday" style="margin-left: 30px; color: silver">\${item.writeday}</div>`;

                            if(loginok != "" && loginid == item.ansid && loginid != "관리자") {
                                s +=  ` <span id="ansdel" num = "\${item.ansidx}"style="margin-left: 20px; color: coral; cursor: pointer"> × </span>`;
                            }

                            if(loginid == "관리자") {
                                s +=  ` <span id="ansdel" num = "\${item.ansidx}"style="margin-left: 20px; color: coral; cursor: pointer"> × </span>`;
                            }
                            s +=  `</div>`;
                        });

                        $("#answercount").html("댓글 <b>" + res.length + "</b>개");
                        $(".answerlist").html(s);
                    }

                }) ;
        }


    </script>
</head>
<body>
<br><br>
<div class="content_main">
<h3><b>${dto.subject}</b></h3>
    <br>
    <img src = "../res/upload/${profile_photo}" class="rounded-circle" style="border: 1px solid silver" hspace="10" align="left" width="50" height="50" onerror="this.src='../res/photo/noimage.png'">
    <b>${dto.writer}</b><br>
    <span class = "day">
        <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm:ss"/>
         <span style="color: sienna;font-weight: bold"> | </span>  조회 ${dto.readcount}
    </span>
    <br><br><hr><br>
    <pre>${dto.content}</pre>
    <c:if test = "${dto.photoCount > 0}">
        <c:forEach var = "photo" items = "${dto.photoNames}">
            <img src = "../res/upload/${photo}" style="width: 400px; margin-bottom: 5px"><br>
        </c:forEach>
    </c:if>
    <br>
    <hr>
    <div>
        <div id = "answercount">댓글 0</div><br>
        <div class = "answerlist" id="answerlist">
            댓글 목록 나올 곳
        </div><br>
        <c:if test = "${sessionScope.loginok != null}">
            <div class="answerform input-group">
                <input type="file" id="upload" style="display: none">
                <span id="uploadcamera" style="cursor: pointer; font-size: 23px">📷</span>
                <img src ="" class="answerphoto" width="50" height="50" border="1" onerror="this.src='../res/photo/noimage.png'" hspace="10">
                <input type="text" width="300" id="answermsg" class="form-control" style="width: 300px;" placeholder="댓글 내용">
                <button type="button" class = "btn btn-outline-success" id ="btnansweradd">저장</button>

            </div>
        </c:if>
    </div>


    <br><hr>
    <div>
        <button type="button" class = "btn btn-outline-secondary btn-sm" onclick="location.href='./form'">글쓰기</button>
        <button type="button" class = "btn btn-outline-secondary btn-sm" onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
        <button type="button" class = "btn btn-outline-secondary btn-sm" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
        <c:if test = "${sessionScope.loginok !=null and sessionScope.myid.equals(dto.myid)}">
            <button type="button" class = "btn btn-outline-secondary btn-sm" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
            <button type="button" class = "btn btn-outline-secondary btn-sm" onclick="location.href='./delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
        </c:if>
    </div>
    <br>
    <br>
</div>
</body>
</html>
