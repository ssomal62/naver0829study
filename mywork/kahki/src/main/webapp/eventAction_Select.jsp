<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.kahki.dao.EventDao" %>
<%@ page import="com.example.kahki.dto.EventDto" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>


<%
    EventDao eventDao = new EventDao();
    String currentDate = request.getParameter("currentDate");
    List<EventDto> events = eventDao.getEventsForCurrentDate(currentDate);

    JSONArray jsonArray = new JSONArray();

    for (EventDto event : events) {
        JSONObject eventJson = new JSONObject();
        eventJson.put("event_id", event.getEvent_id());
        eventJson.put("user_id", event.getUser_id());
        eventJson.put("e_sta_date", event.getE_sta_date().getTime());
        eventJson.put("e_end_date", event.getE_end_date().getTime());
        eventJson.put("title", event.getTitle());
        eventJson.put("content", event.getContent());

        jsonArray.add(eventJson);

    }
%>

<%=jsonArray.toString()%>





