package com.example.restapi.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

//    private Long projectId;
//    private Long createdBy;
//    private Collection<Long> users;
//    private State state;
}
