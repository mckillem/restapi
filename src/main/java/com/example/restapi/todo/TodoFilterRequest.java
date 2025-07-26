package com.example.restapi.todo;

import lombok.Getter;

@Getter
public class TodoFilterRequest {
    private String title;
    private String content;
    private String description;
}
