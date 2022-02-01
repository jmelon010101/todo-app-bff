package com.jmelon.rest.webservices.todorestfulwebservices.helloworld;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class HelloWorld {
    @Getter
    @Setter
    String message;

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }
}
