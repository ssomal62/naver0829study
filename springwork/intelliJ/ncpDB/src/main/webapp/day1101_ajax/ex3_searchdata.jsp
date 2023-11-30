<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="myshop.data.MyShopDao" %>
<%@ page import="myshop.data.MyShopDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    // search 읽기
    String search = request.getParameter("search");

    // dao 선언
    MyShopDao dao = new MyShopDao();

    // search 단어가 포함된 목록 얻기
    List<MyShopDto> list = dao.getSearchSangpum(search);

    // 날짜 포맷 지정
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    // 위의 리스트 목록을 JSONArray로 배열 형태의 json으로 구현
    JSONArray arr = new JSONArray();

    for (MyShopDto dto : list){
        JSONObject ob = new JSONObject();

        ob.put("num",dto.getNum());
        ob.put("sangpum",dto.getSangpum());
        ob.put("price",dto.getPrice());
        ob.put("photo",dto.getPhoto());
        ob.put("color",dto.getColor());
        ob.put("writeday",sdf.format(dto.getWriteday()));

        arr.add(ob);
    }
%>

<%=arr.toString()%>