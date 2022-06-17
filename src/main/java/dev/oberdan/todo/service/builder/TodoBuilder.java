package dev.oberdan.todo.service.builder;

import dev.oberdan.todo.domain.dto.TodoRequestDto;
import dev.oberdan.todo.domain.dto.TodoResponseDto;
import dev.oberdan.todo.domain.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoBuilder {

    public TodoResponseDto toTodoResponseDto(final Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .todo(todo.getTodo())
                .build();
    }

    public Todo toTodo(TodoRequestDto todoRequestDto) {
        return Todo.builder()
                .todo(todoRequestDto.getTodo())
                .build();
    }

    public TodoRequestDto toTodoRequestDto(final Todo todo) {
        return TodoRequestDto.builder()
                .todo(todo.getTodo())
                .build();
    }
}
