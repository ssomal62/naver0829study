<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
    <style>
        .updateform_main{
            margin-left: 12%;
            margin-right: 12%;
        }

        div.photos{
            float: left;
            margin-left: 10px;
            width: 80px;
            text-align: center;
        }
        .photodel{
            margin-left: 10px;
        }

    </style>
</head>
<body>
<div class = "updateform_main">

<c:if test="${sessionScope.loginok == null}">
    <h3>먼저 로그인을 한 후 글을 수정해주세요</h3>
</c:if>
<c:if test="${sessionScope.loginok != null}">
    <form action="./updateboard" method="post" enctype="multipart/form-data">
        <!--hidden start-->
        <input type="hidden" name = "currentPage" value = "${currentPage}">
        <input type="hidden" name = "num" value = "${dto.num}">

        <!--hidden end-->
        <table class="table table-bordered" style="width: 100%">
            <caption align="top">
                <b>${dto.num == 0 ? "새글쓰기" : "답글쓰기"}</b>
            </caption>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name = "subject" class = "form-control" required autofocus value="${dto.subject}">
                </td>
            </tr>
            <tr>
                <th>사진</th>
                <td><input type = "file" name = "upload" multiple class="form-control"> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="content" class = "form-control" required style="width: 100%;height: 300px">${dto.content}</textarea>

                <br>

                 <c:forEach var="fdto" items="${flist}">

                     <div class = "photos">

                     <img src="../res/upload/${fdto.photoname}" width="80"><br>

                     <span class="photodel" idx = "${fdto.idx}" style="cursor: pointer"> x </span>

                     <script>
                         $(document).on("click",".photodel",function (){
                            let idx = $(this).attr("idx");
                            let $photodel = $(this);

                             $.ajax({
                                 type:"get",
                                 dataType:"text",
                                 url:"./delphoto",
                                 data : {"idx":idx},
                                 success:function (res){
                                     //사진 삭제 - 삭제 아이콘의 부모태그 제거
                                     $photodel.parent().remove();

                                 }
                             }) ;

                         });
                     </script>

                     </div>
                 </c:forEach>


                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class = "btn btn-outline-success">수정</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</c:if>
</body>
</html>
