package dev.oberdan.todo.service;

import dev.oberdan.todo.domain.dto.TodoRequestDto;
import dev.oberdan.todo.domain.dto.TodoResponseDto;
import dev.oberdan.todo.domain.entity.Todo;
import dev.oberdan.todo.repository.TodoRepository;
import dev.oberdan.todo.service.builder.TodoBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoBuilder todoBuilder;

    public List<TodoResponseDto> findAll() {
        final List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todoBuilder::toTodoResponseDto).collect(Collectors.toList());
    }

    public TodoRequestDto create(TodoRequestDto todoRequestDto) {
        var todo = todoBuilder.toTodo(todoRequestDto);
        var createTodo = todoRepository.save(todo);
        return todoBuilder.toTodoRequestDto(createTodo);
    }

}
