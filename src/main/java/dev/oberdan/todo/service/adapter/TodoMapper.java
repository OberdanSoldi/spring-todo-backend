package dev.oberdan.todo.service.adapter;

import dev.oberdan.todo.domain.dto.TodoRequestDto;
import dev.oberdan.todo.domain.dto.TodoResponseDto;
import dev.oberdan.todo.domain.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoResponseDto toTodoResponseDto(final Todo todo) {
        var todoDto = new TodoResponseDto();
        todoDto.setId(todo.getId());
        todoDto.setTodo(todo.getTodo());
        return todoDto;
    }

    public Todo toTodo(TodoRequestDto todoRequestDto) {
        var todo = new Todo();
        todo.setTodo(todoRequestDto.getTodo());
        return todo;
    }

    public TodoRequestDto toTodoRequestDto(final Todo todo) {
        var todoDto = new TodoRequestDto();
        todoDto.setTodo(todo.getTodo());
        return todoDto;
    }
}
