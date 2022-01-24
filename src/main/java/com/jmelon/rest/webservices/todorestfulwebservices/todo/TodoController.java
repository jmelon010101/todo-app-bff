package com.jmelon.rest.webservices.todorestfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoController {
    @Autowired
    private TodoHardCodedService todoHardCodedService;


    @GetMapping(path="/users/{username}/todos")
    public List<Todo> getAllTodosByUser(@PathVariable String username) {
        return todoHardCodedService.findAll();
    }

    @DeleteMapping(path="/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodosById(@PathVariable String username, @PathVariable int id) {
        Todo todo = todoHardCodedService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="/users/{user_name}/todos/{todoId}")
    public void editTodoById(@PathVariable String username, @PathVariable String todoId) {

    }

    @PostMapping(path="/users/{username}/todos/")
    public void createTodo(@PathVariable String username) {

    }
}
