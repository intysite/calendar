package org.javaacademy.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.javaacademy.dto.LoginRq;
import org.javaacademy.dto.SignUpRq;
import org.javaacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public Long createUser(@RequestBody SignUpRq signUpRq) {
        return userService.createUser(signUpRq);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRq loginRq) {
        return userService.loginUser(loginRq);
    }
}
