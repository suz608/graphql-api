package com.example.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.repository.TodoRepository;
import com.example.entity.Status;
import com.example.entity.Todo;
import com.example.exception.TodoNotFoundException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Query to get all Todos
    public List<Todo> todos() {
        return todoRepository.findAll();
    }
    
    // Mutation to create a Todo
    public Todo createTodo(String taskText, Status status) {
        Todo todo = new Todo();
        todo.setTaskText(taskText);
        todo.setStatus(status);
        todo.setCreatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    // Mutation to update a Todo
    public Todo updateTodo(Integer todoID, String taskText, Status status) {
        Todo todo = todoRepository.findById(todoID)
                                   .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        if (taskText != null && !taskText.trim().isEmpty()) {
            todo.setTaskText(taskText);
        }
        if (status != null) {
            todo.setStatus(status);
        }

        return todoRepository.save(todo);
    }

    // Mutation to delete a Todo
    public boolean deleteTodo(Integer todoID) {
        if (!todoRepository.existsById(todoID)) {
            throw new TodoNotFoundException("Todo not found");
        }

        todoRepository.deleteById(todoID);
        return true;
    }
}
