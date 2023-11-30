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
(서울=연합뉴스) 임성호 기자 = 아시아나항공 이사회는 2일 대한항공과의 기업결합을 심사하는 유럽연합(EU) 집행위원회에 대한항공이 제출할 시정조치안에 동의한 것으로 알려졌다.

시정조치안의 골자는 '기업결합 후 아시아나항공 화물사업 매각'이다.

연합뉴스 취재에 따르면 이날 아시아나항공 이사회에 참석한 5명의 이사(사내이사 1명, 사외이사 4명) 가운데 찬성 3명, 반대 1명, 기권 1명으로 해당 안건은 가결 처리됐다.

대한항공은 이르면 이날 EU 집행위에 시정조치안을 제출할 예정이다.

EU 집행위는 시정조치안을 검토해 올 연말께 승인 여부를 발표할 것으로 알려졌다.

앞서 대한항공은 지난달 30일 이사회를 열고 아시아나항공 화물사업 매각과 EU 4개 도시의 슬롯(공항 이착륙 횟수) 이관 방안을 포함한 시정조치안 제출을 결의했다.

대한항공과 아시아나항공 이사회에서 아시아나항공 화물사업 매각 방안이 결정된 만큼 두 항공사의 기업결합 절차는 속도를 낼 전망이다.
    </pre>
<br><br>
<a href="loginmain.jsp"> 메인페이지로 이동</a>
<% }
%>
</body>
</html>
