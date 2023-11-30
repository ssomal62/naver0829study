<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>Title</title>
    <style>
        body * {
            font-family: "Noto Sans KR";
        }
        .boardlist_main {
            margin-left: 12%;
            margin-right: 12%;
        }
        .newWrite {
            width: 80px;
            height: 30px;
            border-radius: 50px;
            background-color: sienna;
            border: 0;
            color: white;
        }
    </style>
</head>
<body>
<div class="boardlist_main">

    <br>
    <div style="font-size: 16px">
    총 <b>${totalCount}</b>개의 글이 있습니다.

    <div style="float: right">
    <c:if test ="${sessionScope.loginok != null}">
    <button type="button" class="newWrite" onclick="location.href = './form'">글쓰기</button>
    </c:if>
    </div></div>
    <br>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var = "dto" items="${list}">
        <tr>
            <td>
                ${no}
                <c:set var = "no" value="${no-1}"/>
            </td>
            <td>
                <!--제목 : 답글 레벨 1당 두칸 띄우기 -->
                <c:forEach begin="1" end = "${dto.relevel}">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </c:forEach>
                <!--답글일 경우에만 아이콘 출력 (relevel이 0  보다 큰 경우)-->
                <c:if test = "${dto.relevel > 0}">
                    <img src = "../res/photo/re.png">
                </c:if>
                <!--제목 표시-->
                <a href="./content?num=${dto.num}&currentPage=${currentPage}">
                    ${dto.subject}
                    <c:if test ="${dto.photoCount == 1}">
                        <span>🏜️</span>
                    </c:if>
                    <c:if test ="${dto.photoCount > 1}">
                        <span>🏞️</span>
                    </c:if>
                </a>
                <c:if test = "${dto.acount != 0}">
                <a href="./content?num=${dto.num}&currentPage=${currentPage}#answerlist"><span style="margin-left: 10px;"><b style="color: darkturquoise">[${dto.acount}]</b></span></a>
                </c:if>
            </td>
            <td>${dto.writer}</td>
            <td><fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd."/> </td>
            <td>${dto.readcount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="text-align: center; font-size: 16px">


    <c:if test = "${startPage > 3 }">
        <a href="./list?currentPage=${startPage - 1}">이전 | </a>
    </c:if>
    <span style="margin-left: 10px"></span>

    <c:forEach var = "pno" begin="${startPage}" end="${endPage}">
        <span style="margin-left: 10px"></span>
        <a href="./list?currentPage=${pno}">
        <c:if test = "${pno == currentPage}">
            <span style="color:sienna;font-weight: bold">${pno}</span>
        </c:if>

        <c:if test = "${pno != currentPage}">
            <span style="color:gray;">${pno}</span>
        </c:if>
        </a>
        <!--다음-->
    </c:forEach>
    <c:if test = "${endPage < totalPage}">
        <span style="margin-left: 10px"></span>
        <a href="./list?currentPage=${endPage + 1}">| 다음</a>
    </c:if>
</div>
</div>
</body>
</html>
