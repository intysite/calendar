package org.javaacademy.controller;

import lombok.AllArgsConstructor;
import org.javaacademy.dto.SignUpRq;
import org.javaacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;

    @PostMapping("/signup")
    public Long createUser(@RequestBody SignUpRq signUpRq) {
        return userService.createUser(signUpRq);
    }
}
