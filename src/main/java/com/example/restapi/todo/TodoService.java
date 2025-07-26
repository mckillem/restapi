package com.example.restapi.todo;

import com.example.restapi.todo.exception.TodoNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    public Collection<Todo> getTodos() {

        return todoRepository.findAll();
    }

    public Collection<Todo> getTodoByPhrase(String phrase) {
        Todo todo = Todo.builder()
                .title(todoRequest.getTitle())
                .content(todoRequest.getContent())
                .description(todoRequest.getDescription())
                .createdAt(LocalDateTime.now())
//                .modifiedAt(todoRequest.getModifiedAt())
//                .createdBy(todoRequest.getCreatedBy())
//                .state(todoRequest.getState())
//                .projectId(todoRequest.getProjectId())
                .build();

        return todoRepository.findTodoByTitleContains(phrase);
    }

    public Collection<Todo> getTodoByTitle(String title) {

        return todoRepository.findTodoByTitleContains(title);
    }

    public Collection<Todo> getTodoByContent(String content) {

        return todoRepository.findTodoByContentContains(content);
    }

    public Collection<Todo> getTodoByDescription(String description) {

        return todoRepository.findTodoByDescriptionContains(description);
    }

    public void addTodo(TodoRequest todoRequest) {
        Todo todo = Todo.builder()
                .title(todoRequest.getTitle())
                .content(todoRequest.getContent())
                .description(todoRequest.getDescription())
                .createdAt(LocalDateTime.now())
//                .modifiedAt(todoRequest.getModifiedAt())
//                .createdBy(todoRequest.getCreatedBy())
//                .state(todoRequest.getState())
//                .projectId(todoRequest.getProjectId())
                .build();

        Todo newTodo = todoRepository.saveAndFlush(todo);
    }

    public void deleteTodo(Long id) {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(
                    "Todo with id " + id + " does not exist");
        }

        todoRepository.deleteById(id);
        todoRepository.flush();
    }

    public void updateTodo(Long id, TodoRequest todoRequest) {
        Optional<Todo> byId = todoRepository.findById(id);

        if (byId.isEmpty()) {
            throw new TodoNotFoundException(
                    "Todo with id " + id + " does not exist");
        }

        Todo todoById = byId.get();

        Todo todo = Todo.builder()
                .id(todoById.getId())
                .title(todoRequest.getTitle())
                .content(todoRequest.getContent())
                .description(todoRequest.getDescription())
                .createdAt(todoById.getCreatedAt())
                .modifiedAt(LocalDateTime.now())
//                    .createdBy(todoRequest.getCreatedBy())
//                    .state(todoRequest.getState())
//                    .projectId(todoRequest.getProjectId())
                .build();

            Todo newTodo = todoRepository.saveAndFlush(todo);
    }
}
