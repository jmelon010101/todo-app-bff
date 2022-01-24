package com.jmelon.rest.webservices.todorestfulwebservices.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Todo {
    private int id;
    private String username;
    private String description;
    private boolean isCompleted;
    private Date targetDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
