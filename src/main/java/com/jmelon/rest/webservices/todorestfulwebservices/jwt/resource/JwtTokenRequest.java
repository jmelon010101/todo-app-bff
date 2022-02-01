package com.jmelon.rest.webservices.todorestfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {
//    {"token":"
//    eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTY0NDIwMzU2OCwiaWF0IjoxNjQzNTk4NzY4fQ.y8HHj2VCTODaUawey2pXa57dnFcqaMyxbHNhIfydjpFwUQcYMnBYNHATDPvjrpfM7pNuedGOUXrQB4VBbWfbew"}

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
