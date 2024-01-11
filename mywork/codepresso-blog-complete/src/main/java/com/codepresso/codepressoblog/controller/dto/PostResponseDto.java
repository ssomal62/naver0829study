package com.codepresso.codepressoblog.controller.dto;

import com.codepresso.codepressoblog.vo.Post;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
public class PostResponseDto {

    Integer id;
    String title;
    String content;
    String username;
    Date createdAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUsername();
        this.createdAt = post.getCreatedAt();
    }
}
