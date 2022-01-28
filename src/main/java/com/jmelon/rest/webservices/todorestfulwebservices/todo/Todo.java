package com.jmelon.rest.webservices.todorestfulwebservices.todo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class Todo {
    private int id;
    private String username;
    private String description;
    private boolean isCompleted;
    private Date targetDate;

    public Todo(int id, String username, String description, boolean isCompleted, Date targetDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.isCompleted = isCompleted;
        this.targetDate = targetDate;
    }

    public Todo() {}

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
