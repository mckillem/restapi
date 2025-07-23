package com.example.restapi.todo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    public Collection<Todo> getTodos() {

        return todoRepository.findAll();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
