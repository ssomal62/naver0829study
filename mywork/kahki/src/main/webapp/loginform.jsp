<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gasoek+One&family=Gugi&family=Nanum+Gothic+Coding:wght@400;700&family=Noto+Sans+KR:wght@200;400;800;900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="style.css">
    <style>
        #login_btn{
            height: 40px;
            margin-top: 5px;
            border-radius: 5px;
            background-color: #6ed302;
            color: white;
            border: 0;

        }

        a:link {
            color : #118e6b;
            text-decoration: none;
        }
        a:visited {
            color : #118e6b;
            text-decoration: none;
        }
        a:hover {
            color : #118e6b;
            text-decoration: underline;
        }
        a:active {
            color : #118e6b;
            text-decoration: none;
        }
    </style>

    <script>
        document.addEventListener("DOMContentLoaded", () => {

            const login_btn = document.getElementById("login_btn");

            login_btn.addEventListener("click", () => {
                loginAccess();
            })

            const loginAccess = () => {
                fetch("loginaction.jsp")
                    .then(response => {
                        if (response.ok) {
                            alert("어서오세요!");
                        }
                    })
                    .catch(error => {
                        console.error("데이터 불러오기 실패:", error);
                    });
            };

            login_btn.addEventListener("click", () => {

            });

        });


    </script>
</head>

<%
    //세션으로부터 아이디와 체크 저장값을 얻는다.
    String loginId = (String) session.getAttribute("loginId");
    String saveStatus = (String) session.getAttribute("saveStatus");

    boolean bCheck;

    // 널 조건을 반드시 먼저 써야함.
    // 체크를 했을 경우
    bCheck = saveStatus != null && !saveStatus.equals("no"); //체크를 안했을 경우

    // 체크를 안했을 경우는 아이디를 없앤다.
    if (!bCheck) loginId = "";
%>
<body>


<main>
    <form action="loginaction.jsp" method="post">

        <br>   <br>
        <center><img src = ./ss.png width="200px">
        <div><h1 style=" color : #6ed302 ;font-family: 'Black Han Sans';font-size: 70px">kiky</h1></div>
            <br>   <br>
        </center>
        <caption align="top">
            <label><input type="checkbox" name="saved_id" <%=bCheck? "checked": ""%>>아이디 저장</label>
        </caption>

        <input type="text" class="form-control" autofocus required
               placeholder="아이디" name="loginId" value="<%=loginId%>">


        <input type="password" class="form-control" required
               placeholder="비밀번호" name="loginpass">

        <button type="submit" style="width:100%;" id="login_btn">로그인</button>
        <p>
        <center><div style="align-content: center; "class="hyper"><a href="./register.html"><u>회원가입</u></a> </div></center>
    </form>
</main>
<footer></footer>
</body>
</html>
