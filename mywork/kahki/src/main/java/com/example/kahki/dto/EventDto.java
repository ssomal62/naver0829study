package com.example.kahki.dto;

import java.sql.Timestamp;

public class EventDto {

    private String event_id;
    private String user_id;
    private Timestamp e_sta_date;
    private Timestamp e_end_date;
    private String title;
    private String content;

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public Timestamp getE_sta_date() {
        return e_sta_date;
    }

    public Timestamp getE_end_date() {
        return e_end_date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setE_sta_date(Timestamp e_sta_date) {
        this.e_sta_date = e_sta_date;
    }

    public void setE_end_date(Timestamp e_end_date) {
        this.e_end_date = e_end_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
