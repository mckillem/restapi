package com.example.restapi.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoRequest {
    private String title;
    private String content;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
