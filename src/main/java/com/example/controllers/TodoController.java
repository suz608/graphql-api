package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.entity.Todo;
import com.example.entity.Status;
import com.example.exception.TodoNotFoundException;
import com.example.service.TodoService;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    // Query to get all Todos
    @QueryMapping
    public List<Todo> getTodos() {
        return service.todos();
    }

    // Mutation to create a Todo
    @MutationMapping
    public Todo createTodo(String taskText, Status status) {
        return service.createTodo(taskText, status);
    }

    // Mutation to update a Todo
    @MutationMapping
    public Todo updateTodo(Integer todoID, String taskText, Status status) {
        return service.updateTodo(todoID, taskText, status);
    }

    // Mutation to delete a Todo
    @MutationMapping
    public boolean deleteTodo(Integer todoID) {
        return service.deleteTodo(todoID);
    }

    // Global exception handler for TodoNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTodoNotFoundException(TodoNotFoundException ex) {
        return ex.getMessage();
    }
}
