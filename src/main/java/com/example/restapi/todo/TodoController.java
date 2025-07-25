package com.example.restapi.todo;

import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/{title}")
	public Collection<Todo> getTodoByTitle(@PathVariable String title) {
		return todoService.getTodoByTitle(title);
	}

	@PostMapping("/")
	public void addTodo(@RequestBody TodoRequest todoRequest) {
		todoService.addTodo(todoRequest);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteTodo(@PathVariable("id") Long id) {
		todoService.deleteTodo(id);
	}

	@PatchMapping(path = "/{id}")
	public void updateTodo(@PathVariable("id") Long id,
						   @RequestBody TodoRequest todoRequest) {
		todoService.updateTodo(id, todoRequest);
	}
}
