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
(서울=연합뉴스) 고상민 정수연 기자 = 더불어민주당 이재명 대표는 2일 "민생경제 회복을 위한 '경제성장률 3% 달성'을 확실히 추진하겠다"고 말했다.

이 대표는 오전 국회에서 열린 기자회견에서 이같이 밝힌 뒤 "정책 우선순위를 조정하고 위기 극복방안을 총동원한다면 3% 성장률 회복도 얼마든지 가능하다"고 주장했다.

그는 "이를 위해서는 경제를 회복시킬 '쌍끌이 엔진'이 필요하다"면서 "한 축은 연구기술 개발(R&D)·신성장 동력 발굴·미래형 SOC(사회간접자본시설) 투자, 다른 한 축은 총수요 부족을 개선하기 위한 소비 진작"이라고 강조했다.

야당 대표인 그가 별도 기자회견을 통해 '성장률 3% 달성'을 들고나온 것은 내년 총선을 앞두고 '민생 대안 정당' 이미지를 부각하려는 의도로 보인다.

아울러 예산 정국 개막에 맞춰 정부·여당에 예산안 심사 주도권을 빼앗기지 않겠다는 의지를 천명하는 차원으로도 풀이된다.

이 대표의 기자회견은 국회 복귀 이후 열흘만으로, 회견문만 6천자에 달했다.

    </pre>
<br><br>
<a href="loginmain.jsp"> 메인페이지로 이동</a>
<% }
%>
</body>
</html>
