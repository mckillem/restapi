package com.example.restapi.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    private Long id;
    private String title;
}
