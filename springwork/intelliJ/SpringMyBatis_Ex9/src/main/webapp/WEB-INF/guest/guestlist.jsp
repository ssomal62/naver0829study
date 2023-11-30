<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Title</title>
    <style>
        .guestlist_main {
            margin-left: 12%;
            margin-right: 12%;
        }
    </style>
    <script>
        $(function (){
            let country = localStorage.country;

            if (country == null){
                country ="en";
                $(".selcountry").val(country);
            }

            $(".voicekr").click(function (){

                let m = $("#lang").text();

                $.ajax({
                    type:"get",
                    dataType:"text",
                    url:"./voice",
                    data:{"message":m, "lang":"ko"},
                    success:function (res){
                        let audio = new Audio("../res/voice/"+res);
                        audio.play();
                    }
                }) ;

            })
        })
    </script>
</head>
<body>
<div class="guestlist_main">
    <br>
    <form action="./insert" method="post" enctype="multipart/form-data">
        <input type="hidden" name = "country" value="">
        <b>사진 1장 필수:</b>
        <input type="file" name="upload" required><br>
        <b>닉네임 : </b>
        <input type="text" name="guest_nickname" required><br>
        <textarea style="width: 300px;height: 100px;" name="guest_content" required></textarea>
        <br>
        <button type="submit">방명록 저장</button>
    </form>
    <hr>
    <h5>총 ${totalCount}개의 방명록 글이 있습니다.</h5>
    <br>

    <div class = "input-group" style="width: 300px">
        <h5><b>번역 언어 선택</b></h5>
        <select style="margin-left: 20px" class="form-select selcountry">
            <option hidden="hidden">옵션 선택</option>
            <option value="ko" >한국어</option>
            <option value="en" >영어</option>
            <option value="ja" >일어</option>
            <option value="es" >스페인어</option>
            <option value="zh-CN">중국어</option>
        </select>
        <script>
            $(".selcountry").change(function (){
                let country = $(this).val();
                localStorage.country = country;
                location.href="./list?country="+country;
            })
        </script>

    </div>
    <br>
    <br>
    <c:forEach var="dto" items="${glist}">
        <div class="guest_box">
            <div style="margin-right:20px;float: left">
                <img src="https://51dxrqsv1719.edge.naverncp.com/WncKyJbT9O/guest/${dto.guest_photo}?type=f&w=100&h=100&faceopt=true&ttype=jpg"
                     class="img-thumbnail smallphoto" onerror="this.src = '../res/photo/noimage.png'" data-toggle="modal" data-target="#exampleModal" style="cursor:pointer;" photoname = "${dto.guest_photo}">
            </div>
            <div>
                <div>
                    <span style="font-size: 18px;font-weight: bold">${dto.guest_nickname}</span>
                    <span style="color: silver"> &nbsp;|&nbsp; <fmt:formatDate  value = "${dto.guest_writeday}" pattern="yyyy.MM.dd HH:mm"/></span>
                </div>
                <div style="margin-top: 8px">
                    <span> ${dto.guest_content}</span>

                </div>
                <div style="margin-top: 8px">
                    <span style="color:darkcyan;font-weight: bold" >🆎&nbsp;번역 </span>
                    <span style="cursor: pointer" class="voicekr">🔊&nbsp;</span><span id="lang" style="color:darkcyan">${dto.trans_lang}</span></div>
            </div>
            <div style="clear: both"></div>
        </div>

        <script type="text/javascript">

        </script>

        <hr>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">원본 사진 확인</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <img src = "" class="largephoto" style="width: 100%">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<script type="text/javascript">
    $("img.smallphoto").click(function (){
        let photoname = $(this).attr("photoname");

        $("img.largephoto").attr("src",`https://kr.object.ncloudstorage.com/guest-aiur/guest/\${photoname}`);
    })
</script>
</body>
</html>
