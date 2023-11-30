<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Title</title>
    <style>

        .header_title {
            position: absolute;
            font-size: 30px;
            border: 0px solid black;
            margin-top: 30px;
            margin-left: 35%;
        }

        .login_area {
            position: relative;
            float: right;
            font-size: 14px;
            padding-top: 10px;
            margin-right: 20%;
            height: 50px;
            border: 0px solid black;
        }

        #btnlogin {
            width: 130px;
            height: 40px;
            border-radius: 30px;
            background-color: sienna;
            color: white;
            line-height: 40px;
            font-weight: 400;
        }
    </style>

    <c:set var = "root" value = "<%=request.getContextPath()%>"/>

    <script type="text/javascript">
        $(function (){
            $("#btnlogin").click(function (){
                let saveid = $("#saveid").is(":checked");
                let login_myid = $("#login_myid").val();
                let login_pass = $("#login_pass").val();
                //alert(saveid + ","+myid);

                $.ajax({
                    type:"get",
                    dataType:"json",
                    url:"${root}/login/process",
                    data : {"saveid": saveid, "myid": login_myid, "pass": login_pass},
                    success:function (res){
                        //성공여부 res.success
                        if(res.success) {
                            $("#btnclose").trigger("click"); //강제로 닫기 버튼 클릭하기
                            location.reload();
                        } else {
                            alert("아이디나 비밀번호가 맞지 않습니다.")
                        }
                    }
                })
            });

            $("#btnlogout").click(function (){
                $.ajax({
                    type:"get",
                    dataType:"text",
                    url:"${root}/login/logout", //현재폴더이므로 별고 설정없이.
                    success:function (res){
                        location.reload();
                    }
                }) ;
            });
        })
    </script>
</head>
<body>


<%--<img src = "${root}/res/photo/1.jpg" width="50" hspace="20">--%>


<div class="login_area" >
<c:if test = "${sessionScope.loginok == null}">
    <span style="width: 100px; cursor: pointer" data-bs-toggle="modal" data-bs-target="#myLoginModal" >로그인</span>
</c:if>

<c:if test = "${sessionScope.loginok != null}">
    <img class="profile_photo" src = "${root}/res/upload/${sessionScope.myphoto}" style="width: 40px;border-radius: 100px; border: 1px solid gray; margin-right: 10px">
    <span style="font-size: 16px;margin-right: 10px"> <b>${sessionScope.myname}</b><span style="font-weight: 400">님</span></span>
    <span style="font-size: 16px;font-weight: 400;cursor: pointer" class="photochange">⚙️</span>
    <input type="file" id = "profile_upload" style="display: none;">
    <button style="font-size: 12px;" type="button" class="btn-close" id="btnlogout"></button>
</c:if>
</div>
<div style="clear: both"></div>
<div class="header_title">
<a href="/${root}">
    Spring5 <span style="font-weight: 200">/</span> Tiles3  <span style="font-weight: 200">/</span> Mybatis Mini Project
</a>
</div>

<!-- The Modal -->
<div class="modal" id="myLoginModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">LOGIN</h4>
                <button type="button" class="btn-close" id = "btnclose" data-bs-dismiss="modal"></button>
            </div>
            <!-- Modal body -->
            <div class="modal-body" >


                <table style="margin-left: 10px">
                    <tr>
                        <td>
                            <label for ="saveid" style="float: left">
                                <input type="checkbox" id="saveid" style="margin-right: 5px; margin-bottom: 10px"
                                <c:if test = "${sessionScope.saveid != 'yes'}">
                                    >
                                </c:if>
                                <c:if test = "${sessionScope.saveid == 'yes'}">
                                    checked>
                                </c:if>
                                아이디 저장
                            </label>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td>

                            <label for ="login_myid" ><b>아이디</b><br>
                                <input type="text" id="login_myid" class = "form-control" style="margin-bottom: 10px"
                                <c:if test = "${sessionScope.saveid != 'yes'}">
                                    >
                                </c:if>
                                <c:if test = "${sessionScope.saveid == 'yes'}">
                                   value="${sessionScope.myid}">
                                </c:if>
                            </label><br>
                        </td>


                    </tr>
                    <tr>
                        <td>
                            <label for ="login_pass"><b>비밀번호</b><br>
                           <input type="text" id="login_pass" class = "form-control"></label><br>
                        </td>

                    </tr>
                </table>
                <div id = "btnlogin" style="margin-top: 20px; margin-left: 65px; cursor: pointer">로그인</div>
            </div>

<%--            <!-- Modal footer -->--%>
<%--            <div class="modal-footer">--%>

<%--            </div>--%>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(".photochange").click(function (){
        $("#profile_upload").trigger("click");
    })

    $("#profile_upload").change(function (){
        let form = new FormData();

        form.append("upload", $("#profile_upload")[0].files[0]);

        $.ajax({
            type:"post",
            dataType:"json",
            url:"${root}/login/photochange",
            processData : false,
            contentType : false,
            data:form,
            success:function (res){
                $(".profile_photo").attr("src", `${root}/res/upload/\${res.fileName}`);
                location.reload();
            }
        });
    })
</script>
</body>
</html>
