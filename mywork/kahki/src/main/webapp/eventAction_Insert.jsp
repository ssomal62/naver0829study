        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.example.kahki.dao.EventDao" %>
<%@ page import="com.example.kahki.dto.EventDto" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.ParseException" %>


<%

    String user_id = request.getParameter("user_id");
    String add_event_title = request.getParameter("add_event_title");
    String add_event_content = request.getParameter("add_event_content");

    EventDao eventDao = new EventDao();
    EventDto event = new EventDto();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Timestamp e_sta_date = null;
    Timestamp e_end_date = null;

    try {
        String add_event_datdS = request.getParameter("add_event_datdS");
        String add_event_datdE = request.getParameter("add_event_datdE");

        // 문자열을 Timestamp로 변환
        e_sta_date = new Timestamp(dateFormat.parse(add_event_datdS).getTime());
        e_end_date = new Timestamp(dateFormat.parse(add_event_datdE).getTime());

        event.setUser_id(user_id);
        event.setTitle(add_event_title);
        event.setContent(add_event_content);
        event.setE_sta_date(e_sta_date);
        event.setE_end_date(e_end_date);

        eventDao.createEvent(event);
        // 이제 e_sta_date 및 e_end_date는 Timestamp로 변환된 값입니다.
    } catch (ParseException e) {
        // 날짜 형식이 잘못된 경우 처리
        e.printStackTrace();
    }




%>






