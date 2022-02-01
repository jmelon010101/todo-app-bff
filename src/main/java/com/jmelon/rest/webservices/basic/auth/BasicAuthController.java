package com.jmelon.rest.webservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthController {
    
    @GetMapping(path="/basic-auth")
    public AuthenticationBean authenticate() {

        return new AuthenticationBean("Access Granted to user");
    }
}
