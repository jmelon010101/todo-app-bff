package com.jmelon.rest.webservices.todorestfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(path="/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable int id) {
        return todoHardCodedService.findById(id);
    }

    @DeleteMapping(path="/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodosById(@PathVariable String username, @PathVariable int id) {
        Todo todo = todoHardCodedService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="/users/{username}/todos/{todoId}")
    public ResponseEntity<Todo> editTodoById(@PathVariable String username, @PathVariable String todoId, @RequestBody Todo todo) {
        Todo updatedTodo = todoHardCodedService.save(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping(path="/users/{username}/todos/")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo updatedTodo = todoHardCodedService.save(todo);
        //Location
        // get current resource url
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }
}
