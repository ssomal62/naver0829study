package com.cherry.board.practice.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Comment {
    Long id;
    Long boardId;
    String content;
    String writer;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
}