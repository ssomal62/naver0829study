package com.codepresso.codepressoblog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    Integer id;
    String title;
    String content;
    String username;
    Date createdAt;

    public Post(Integer id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
    }



}
