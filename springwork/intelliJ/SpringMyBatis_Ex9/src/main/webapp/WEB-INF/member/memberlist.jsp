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
    .memberlist_main{
        margin-left: 12%;
        margin-right: 12%;
    }
</style>
    <script type="text/javascript">

        let field = "", word = "";

        $(function () {
            list();
            $("#btnsearch").click(function () {
                field = $("#field").val();
                word = $("#word").val();

                list();
            });

            //탈퇴이벤트
            $(document).on("click",".memberdel", function (){

                let a = confirm("해당 회원을 삭제하시겠습니까?");

                if(a){
                    let num = $(this).attr("num");

                    $.ajax({
                        type:"get",
                        dataType:"text",
                        url:"./delete",
                        data : {"num":num},
                        success:function (res){
                            word = "";
                            list();
                        }
                    }) ;
                }
            });
        });

        function list() {

            //처음 로딩 시 전체 멤버를 출력
            $.ajax({
                type    : "get",
                dataType: "json",
                url     : "./search",
                data    : {"field": field, "word": word},
                success : function (res) {
                    let s = "";

                    s += `
                    <table class = "table table-boarded">
                        <thead>
                        <tr>
                        <th> -</th>
                        <th> 이름</th>
                        <th> 아이디</th>
                        <th> 핸드폰</th>
                        <th> 이메일</th>
                        <th> 가입일</th>
                        <th> 탈퇴처리</th>
                        </tr>
                        </thead>
                        <tbody>
                    `;

                    $.each(res, function (idx, item) {
                        s += `<tr>
                            <td><img src = "../res/upload/\${item.photo}" width= "30px"></td>
                            <td>\${item.name}</td>
                            <td>\${item.myid}</td>
                            <td>\${item.hp}</td>
                            <td>\${item.email}</td>
                            <td>\${item.gaipday}</td>
                        <td>
                            <span class="memberdel" num = "\${item.num}" style="cursor: pointer; color: red;">탈퇴<span>

                        </td>
                        </tr>
                        `;

                    });

                    s += "</tbody><table>";

                    $("div.searchlist").html(s);
                }
            });
        }
    </script>
</head>
<body>
<div class="memberlist_main">


<br><br>

<c:if test = "${sessionScope.loginok == null}">
    로그인을 해주세요.
</c:if>

<c:if test = "${sessionScope.loginok != null}">
<div style="float: left">현재 총 <b>${totalCount}명</b>의 회원이 있습니다.</div>
<div class="clear:both"> </div>

<div class="input-group" style="width: 300px; float: right">

    <select id="field" class="form-select">
        <option hidden="disabled" selected>검색할 필드</option>
        <option value="name">이름</option>
        <option value="myid">아이디</option>
        <option value="hp">휴대폰</option>
        <option value="email">이메일</option>
    </select>
    <input type="text" class="form-control" id="word">
    <button type="button" class="btn btn-success btn-sm" id="btnsearch">검색</button>
</div>

    <br><br>
    <div class="searchlist" style="margin-top: 20px;"></div>
</c:if>

</div>
</body>
</html>
