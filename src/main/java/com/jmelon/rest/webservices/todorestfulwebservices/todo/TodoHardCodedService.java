package com.jmelon.rest.webservices.todorestfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int idCount = 1000;

    static {
        todos.add(new Todo(++idCount, "jmelon", "Learn how to dance", false, new Date()));
        todos.add(new Todo(++idCount, "jmelon", "Learn how to run faster", false, new Date()));
        todos.add(new Todo(++idCount, "jmelon", "Learn how to code in React", false, new Date()));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(int id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(int id) {
        for(Todo todo : todos) {
            if (todo.getId() == id) return todo;
        }
        return null;
    }

}
