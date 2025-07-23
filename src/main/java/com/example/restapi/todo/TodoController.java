package com.example.restapi.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/")
	public Collection<Todo> getTodos() {
		return todoService.getTodos();
	}

	@PostMapping("/add")
	public void addTodo(Todo todo) {
		todoService.addTodo(todo);
	}
}
