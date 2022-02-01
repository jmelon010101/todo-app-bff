package com.jmelon.rest.webservices.todorestfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class HelloWorldController {
    @GetMapping(path="/hello-world")
    public String helloWorld() {
        throw new RuntimeException("Something went wrong");
//        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello World Bean");
    }

    @GetMapping(path="/hello-world/{name}")
    public HelloWorld helloWorldPath(@PathVariable String name) {
        return new HelloWorld(String.format("Hello %s", name));
    }
}
