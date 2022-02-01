package com.jmelon.rest.webservices.basic.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationBean {
    @Getter
    @Setter
    String message;

    @Override
    public String toString() {
        return String.format("Authorization: [message=%s]", message);
    }
}
