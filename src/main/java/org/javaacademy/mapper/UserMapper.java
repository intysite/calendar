package org.javaacademy.mapper;

import org.javaacademy.dto.SignUpRq;
import org.javaacademy.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User castToEntity(SignUpRq signUpRq) {
        return new User(signUpRq.getEmail(),
                signUpRq.getPassword(),
                signUpRq.getName());
    }
}
