package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;



    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo createOrUpdateTodo(@RequestBody Todo todo) {
        return todoService.saveOrUpdate(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable int id) {
        boolean deleted = todoService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Todo item deleted successfully"); // Return 200 OK with a message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo item not found"); // Return 404 Not Found with a message
        }
    }
}
