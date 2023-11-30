package com.example.kahki.dto;

import java.sql.Timestamp;

public class CommentDto {

    private String comment_id;
    private String user_id;
    private String event_id;
    private Timestamp comment_date;
    private String content;

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public Timestamp getComment_date() {
        return comment_date;
    }

    public String getContent() {
        return content;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public void setComment_date(Timestamp comment_date) {
        this.comment_date = comment_date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
