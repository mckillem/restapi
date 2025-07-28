package com.example.restapi.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoServiceTest {
    @Autowired
    private TodoRepository underTest;

    @Test
    void itShouldAddTodo() {
        // given
        Long id = 1L;
        String title = "title";
        String content = "content";
        String description = "description";
        LocalDateTime createdAt = LocalDateTime.now();

        Todo todo = new Todo(id, title, content, description, createdAt, createdAt);

        // when
        underTest.save(todo);

        // then
        Optional<Todo> optionalTodo = underTest.findById(id);
        assertThat(optionalTodo)
                .isPresent()
                .hasValueSatisfying(t -> {
                    assertThat(t.getId()).isEqualTo(id);
                    assertThat(t.getTitle()).isEqualTo(title);
                    assertThat(t.getContent()).isEqualTo(content);
                    assertThat(t.getCreatedAt()).isEqualTo(createdAt);
                });
    }

    @Test
    void itShouldGetTodos() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldGetTodoByTitle() {
        // Given
        Long id = 1L;
        String title = "title";
        String content = "content";
        String description = "description";
        LocalDateTime createdAt = LocalDateTime.now();

        Todo todo = new Todo(id, title, content, description, createdAt, createdAt);

        // When
        underTest.save(todo);

        // Then
        Optional<Todo> optionalTodo = underTest.findTodoByTitleContains(title);
        assertThat(optionalTodo)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).isEqualToComparingFieldByField(todo);
                });
    }

    @Test
    void itShouldDeleteTodo() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldUpdateTodo() {
        // Given
        // When
        // Then
    }
}
