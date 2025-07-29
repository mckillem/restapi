package com.example.restapi.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Collection<Todo> findTodoByTitle(String title);

    Optional<Todo> findTodoByTitleContains(String title);
}
