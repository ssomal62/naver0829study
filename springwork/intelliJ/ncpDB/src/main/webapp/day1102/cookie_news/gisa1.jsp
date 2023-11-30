<%--
  Created by IntelliJ IDEA.
  User: wxy89
  Date: 2023-11-02
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    Cookie[] cookies = request.getCookies(); // 배열로 반환됨.
    boolean find = false;
    if(cookies != null){
        for(Cookie ck : cookies){
            String name = ck.getName();
            if(name.equals("loginok")){
                find = true; //해당 쿠키가 존재하현 treu
            }
        }
    }
%>
<body>
<%
    if(!find){%>
        <script type="text/javascript">
        alert("먼저 로그인을 해주세요");
        history.back();
        </script>
    <%} else { %>
    <pre style="width:500px">
마약 투약 혐의 등으로 재판에 넘겨진 유아인 등의 공소장에 유아인이 유명 유튜버를 공범으로 만들기 위해 대마 흡연을 권유한 내용이 포함됐다. 유아인은 직접 대마 흡연 방법을 알려주기도 한 것으로 기재됐다.

2일 <더팩트>가 국회 법제사법위원회 박용진 더불어민주당 의원실을 통해 입수한 공소장에 따르면 유아인은 지난 1월 미국 캘리포니아주 로스앤젤레스에 위치한 숙소에서 유튜버 A씨, 일행 B씨, C씨와 대마를 흡연했다.

검찰은 지난 1월 21일 유아인이 일행들과 야외 테이블에 둘러앉아 궐련 형태의 종이에 싸인 대마초를 흡연했다고 공소장에 적었다.

이튿날도 야외 수영장에서 B씨, C씨 등과 대마를 흡연하던 유아인은 유튜브 브이로그를 촬영하기 위해 수영장을 찾아온 또 다른 일행 유튜버 A씨가 이 장면을 목격하자 "내가 왜 유튜버 때문에 자유시간을 방해받아야 되냐"며 신경질을 냈다고 한다.

공소장에 따르면 유아인은 A씨가 자신의 대마 흡연 사실을 자칫 외부에 발설하면 수사를 받을 수 있을 뿐만 아니라 유명 연예인으로서 이미지나 평판 등에 악영향이 있을 것으로 우려했다.

검찰은 이에 따라 유아인이 A씨를 끌어들여 공범으로 만들어 입을 막기로 결심했다고 봤다.
    </pre>
    <br><br>
<a href="loginmain.jsp"> 메인페이지로 이동</a>
    <% }
%>
</body>
</html>
