<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <title>Title</title>
    <style>
        body * {
            font-family: "Noto Sans KR";
        }
    </style>
    <script type = "text/javascript">
        $(function() {
            $(".answerdel").click(function (){
                let idx = $(this).attr("idx");
                let num = $(this).attr("num");

                let a = confirm("해당 댓글을 삭제하시겠습니까?");

                if(a){
                    location.href=`./answerdel?num=\${num}&idx=\${idx}`;
                }
            })
        })
    </script>
</head>
<body>

<div style="margin: 30px; width:500px;">
    <h3><b>${dto.subject}</b></h3>
    <div style="width: 500px">
        <span>${dto.writer}</span>
        <span class = "day" style="margin-right: 20px">
            조회 ${dto.readcount}
            <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
        </span>
        <hr>
        <pre>${dto.content}</pre>

        <c:if test="${dto.photo!='no'}">
            <br><br>
            <img src="../upload/${dto.photo}" style="max-width: 400px;">
        </c:if>
        <br><br>
        <div style="margin : 20px;">
            <i class = "bi bi-chat-dots"></i> ➡️ ${acount}<br><br>
            <!--댓글 출력-->
            <c:forEach var="adto" items="${alist}">
                <span>${adto.nickname} : ${adto.content}</span>
                <span style="margin-left: 20px; color:gray; font-size: 0.9em">
                        <fmt:formatDate value="${adto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
                </span>
                <span class = "answerdel" style="cursor: pointer" idx = "${adto.idx}" num = "${dto.num}">❌</span>
                <br>
            </c:forEach>
        </div>
        <div style="margin-bottom: 10px;">
            <form action="./addanswer" method="post">
                <input type="hidden" name="num" value="${dto.num}">
                <div class="input-group" style="width:500px;">
                    <input type="text" name="nickname" class="form-control"
                           style="margin-left:5px;width:100px;" placeholder="닉네임">
                    <input type="text" name="content" class="form-control"
                           style="margin-left:5px;width:300px;" placeholder="댓글">

                    <button type="submit" class="btn btn-sm btn-outline-success">저장</button>
                </div>
            </form>
        </div>
        <br><br>

        <button type="button" class="btn btn-outline-info btn-sm" style="width: 80px" onclick="location.href='./writeform'">글쓰기</button>
        <button type="button" class="btn btn-outline-info btn-sm" style="width: 80px" onclick="location.href='./list'">목록</button>
        <button type="button" class="btn btn-outline-info btn-sm" style="width: 80px" onclick="location.href='./updateform?num=${dto.num}'">수정</button>
        <button type="button" class="btn btn-outline-info btn-sm" style="width: 80px" onclick="location.href='./delete?num=${dto.num}'">삭제</button>
    </div>
</div>
</body>
</html>
