<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="simpleBoard.SimpleBoardDto" %>
<%@ page import="simpleBoard.SimpleBoardDao" %>
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
        span.day{
            font-size: 14px;
            color:#cccccc;

        }
    </style>
</head>
<%
    //num읽기
    String num = request.getParameter("num");
    //dao 선언
    SimpleBoardDao dao = new SimpleBoardDao();
    //조회수 증가
    dao.updateReadcount(num);
    //num에 해당하는 dto 얻기
    SimpleBoardDto dto = dao.getData(num);
    //날짜출력 양식
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: :30px 50px">
    <table class = "table table-bordered" style="width: 500px">
        <tr>
            <h2><b><%=dto.getSubject()%>=</b></h2>
            <span><b><%=dto.getWriter()%></b></span>
            <span class = "day">
            &nbsp;&nbsp;
            조회&nbsp;<%=dto.getReadcount()%>

        </span>
        </tr>
        <tr height = "300" valign="top">
            <td>
                <!--여러줄일 경우 replace로 \n을 <br>로 변경하거나 아니면 <pre> 태그로 출력으로 해야만 줄넘김이 된다. -->
                <%=dto.getContent().replace("\n","<br>")%>
                <br><br>
                <%
                    if(!dto.getPhoto().equals("no")){
                %>
                    <img src = "../save/<%=dto.getPhoto()%>" style="max-width: 300px">
                <%}
                %>
            </td>
        </tr>
        <tr>
            <td align="center">
                <button type = "button" class = "btn btn-outline-success" style = "width: 100px;" onclick="location.href='boardForm.jsp'">새글</button>
                <button type = "button" class = "btn btn-outline-success" style = "width: 100px;" onclick="location.href='list.jsp'">목록</button>
                <button type = "button" class = "btn btn-outline-success" style = "width: 100px;" onclick="location.href='updateForm.jsp'">수정</button>
                <button type = "button" class = "btn btn-outline-success" style = "width: 100px;" onclick="location.href='boardDelete.jsp'">삭제</button>
            </td>
        </tr>

    </table>
</div>


</body>
</html>
