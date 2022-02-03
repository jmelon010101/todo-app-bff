package com.jmelon.rest.webservices.todorestfulwebservices.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public  class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String description;
    private boolean isCompleted;
    private Date targetDate;

    public Todo(Long id, String username, String description, boolean isCompleted, Date targetDate) {
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
