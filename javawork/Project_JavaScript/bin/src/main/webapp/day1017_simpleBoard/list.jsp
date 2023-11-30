<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="simpleBoard.SimpleBoardDao" %>
<%@ page import="simpleBoard.SimpleBoardDto" %>
<%@ page import="java.util.List" %>
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
    </style>
</head>
<body>
    <%
    SimpleBoardDao dao = new SimpleBoardDao();
    List<SimpleBoardDto> list = dao.getAllList();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
%>

<div style="margin: 30px 50px">

    <button type="button" class="btn btn-success btn-sm" onclick="location.href = 'boardForm.jsp'">글쓰기</button>
    <br>
    <h5><b> 총 <%=list.size()%>개의 게시글이 있습니다. </b></h5>
    <br>
    <table class="table table-striped" style="width: 600px">
        <thead>
        <tr>
            <th width="50">번호</th>
            <th width="200">제목</th>
            <th width="80">작성자</th>
            <th width="100">작성일</th>
            <th width="50">조회</th>
        </tr>
        </thead>
    </table>
    <tbody>
    <%
        if (list.size() == 0) {
    %>
    <tr height="50">
        <td colspan="5" align="center">
            <h5> 등록된 글이 없습니다.</h5>
        </td>
    </tr>
    <%
        } else {

        }
    %>

    </tbody>
</div>
</body>
</html>

