package com.example.restapi.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Collection<Todo> findTodoByTitleContains(String title);

    Collection<Todo> findTodoByContentContains(String title);

    Collection<Todo> findTodoByDescriptionContains(String title);
}
