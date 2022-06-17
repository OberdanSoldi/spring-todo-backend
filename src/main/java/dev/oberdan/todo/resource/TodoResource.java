package dev.oberdan.todo.resource;

import dev.oberdan.todo.domain.dto.TodoRequestDto;
import dev.oberdan.todo.domain.dto.TodoResponseDto;
import dev.oberdan.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoResource {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findAll());
    }

    @PostMapping
    public ResponseEntity<TodoRequestDto> create(@RequestBody final TodoRequestDto todoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todoRequestDto));
    }
}
