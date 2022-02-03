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
public class TodoJpaController {
    @Autowired
    private TodoHardCodedService todoHardCodedService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;


    @GetMapping(path="/jpa/users/{username}/todos")
    public List<Todo> getAllTodosByUser(@PathVariable String username) {
        return todoJpaRepository.findByUsername(username);
    }

    @GetMapping(path="/jpa/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable Long id) {
        return todoJpaRepository.findById(id).get();
    }

    @DeleteMapping(path="/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodosById(@PathVariable String username, @PathVariable Long id) {
        todoJpaRepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="/jpa/users/{username}/todos/{todoId}")
    public ResponseEntity<Todo> editTodoById(@PathVariable String username, @PathVariable String todoId, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo updatedTodo = todoJpaRepository.save(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping(path="/jpa/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo updatedTodo = todoJpaRepository.save(todo);
        //Location
        // get current resource url
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
