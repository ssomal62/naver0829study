package com.cherry.board.practice.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Board {
    Long id;
    String title;
    String content;
    String writer;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
}