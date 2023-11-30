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
        .boardform_main{
            margin-left: 12%;
            margin-right: 12%;
        }
    </style>
</head>
<body>
<div class="boardform_main">
<c:if test="${sessionScope.loginok == null}">
    <h3>먼저 로그인인 한 후 글을 써주세요</h3>
</c:if>
<c:if test="${sessionScope.loginok != null}">

    <form action="./addboard" method="post" enctype="multipart/form-data">
        <!--hidden start-->
        <input type="hidden" name = "currentPage" value = "${currentPage}">
        <input type="hidden" name = "num" value = "${num}">
        <input type="hidden" name = "regroup" value = "${regroup}">
        <input type="hidden" name = "restep" value = "${restep}">
        <input type="hidden" name = "relevel" value = "${relevel}">
        <!--hidden end-->
        <table class="table table-bordered" style="width: 100%">
            <caption align="top">
                <b>${num == 0 ? "새글쓰기" : "답글쓰기"}</b>
            </caption>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name = "subject" class = "form-control" required autofocus value="${subject}">
                </td>
            </tr>
            <tr>
                <th>사진</th>
                <td><input type = "file" name = "upload" multiple class="form-control"> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="content" class = "form-control" required style="width: 100%;height: 300px"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class = "btn btn-outline-success">글저장</button>
                    <button type="button" class = "btn btn-outline-success" onclick="history.back()">이전으로</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</c:if>
</body>
</html>
