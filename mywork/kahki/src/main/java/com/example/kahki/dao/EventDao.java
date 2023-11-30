package com.example.kahki.dao;

import com.example.kahki.dto.EventDto;
import com.example.kahki.mysqlDB.DbConnect_Local;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
    private final DbConnect_Local db = new DbConnect_Local();


    // 이벤트 생성 (Insert)
    public void createEvent(EventDto event) {
        String sql = "INSERT INTO events (event_id,user_id, e_sta_date, e_end_date, title, content) VALUES (null, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, event.getUser_id());
            statement.setTimestamp(2, event.getE_sta_date());
            statement.setTimestamp(3, event.getE_end_date());
            statement.setString(4, event.getTitle());
            statement.setString(5, event.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // 이벤트 조회 (Select) - 특정 사용자의 모든 이벤트 가져오기
    public List<EventDto> getEventsByUser(String userId) {
        List<EventDto> events = new ArrayList<>();
        String sql = "SELECT * FROM events WHERE user_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EventDto event = new EventDto();
                event.setUser_id(resultSet.getString("user_id"));
                event.setE_sta_date(resultSet.getTimestamp("e_sta_date"));
                event.setE_end_date(resultSet.getTimestamp("e_end_date"));
                event.setTitle(resultSet.getString("title"));
                event.setContent(resultSet.getString("content"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // 이벤트 조회 (Select) - 특정 사용자의 모든 이벤트 가져오기
    public List<EventDto> getEventsByEvent(String event_id) {
        List<EventDto> events = new ArrayList<>();
        String sql = "SELECT * FROM events WHERE event_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, event_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EventDto event = new EventDto();
                event.setEvent_id(resultSet.getString("event_id"));
                event.setUser_id(resultSet.getString("user_id"));
                event.setE_sta_date(resultSet.getTimestamp("e_sta_date"));
                event.setE_end_date(resultSet.getTimestamp("e_end_date"));
                event.setTitle(resultSet.getString("title"));
                event.setContent(resultSet.getString("content"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // 이벤트 업데이트 (Update)
    public void updateEvent(EventDto event) {
        String sql = "UPDATE events SET e_sta_date = ?, e_end_date = ?, title = ?, content = ? WHERE user_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setTimestamp(1, event.getE_sta_date());
            statement.setTimestamp(2, event.getE_end_date());
            statement.setString(3, event.getTitle());
            statement.setString(4, event.getContent());
            statement.setString(5, event.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<EventDto> getEventsForCurrentDate(String currentDate) {
        List<EventDto> events = new ArrayList<>();
        String sql = "SELECT * FROM events WHERE ? BETWEEN e_sta_date AND e_end_date";

        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, currentDate);


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EventDto event = new EventDto();
                event.setEvent_id(resultSet.getString("event_id"));
                event.setUser_id(resultSet.getString("user_id"));
                event.setE_sta_date(resultSet.getTimestamp("e_sta_date"));
                event.setE_end_date(resultSet.getTimestamp("e_end_date"));
                event.setTitle(resultSet.getString("title"));
                event.setContent(resultSet.getString("content"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }


    // 이벤트 삭제 (Delete)
    public void deleteEvent(String event_id) {
        String sql = "DELETE FROM events WHERE event_id = ? ";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, event_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 모든 이벤트 가져오기
    public List<EventDto> getAllEvents() {
        List<EventDto> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EventDto event = new EventDto();
                event.setEvent_id(resultSet.getString("event_id"));
                event.setUser_id(resultSet.getString("user_id"));
                event.setE_sta_date(resultSet.getTimestamp("e_sta_date"));
                event.setE_end_date(resultSet.getTimestamp("e_end_date"));
                event.setTitle(resultSet.getString("title"));
                event.setContent(resultSet.getString("content"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}