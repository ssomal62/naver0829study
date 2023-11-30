<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    </style>
</head>
<body>
<div style="margin: 30px">
    <h3 class = "alert alert-danger">총 ${totalCount}개의 글이 있습니다.
    <button type="button" class = "btn btn-outline-sucess" onclick="location.href='./writeform'" style="float: right"> 글쓰기</button>
    </h3>
    <table class = table table-striped style="margin: 30px; width: 600px;">
        <thead>
        <tr>
            <th width = "50">번호</th>
            <th width = "300">제목</th>
            <th width = "80">작성자</th>
            <th width = "100">작성일</th>
            <th width = "50">조회</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}" varStatus="n">
            <tr>
                <td>${totalCount - n.index}</td>
                <td> <a href ="./content?num=${dto.num}" style="color:black; text-decoration: none;">
                    ${dto.subject}
                    <c:if test = "${dto.photo != 'no'}">
                        <!--photo값이 no가 아니면 아이콘 출력-->
                        🎊
                    </c:if>
                    <c:if test = "${dto.acount>0}">
                        <span style="color:red;">(${dto.acount})</span>
                    </c:if>
                </a>
                </td>

                <td>${dto.writer}</td>
                <td>
                    <fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
                </td>
                <td>
                    ${dto.readcount}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

