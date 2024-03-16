package org.javaacademy.service;

import lombok.AllArgsConstructor;
import org.javaacademy.dto.LoginRq;
import org.javaacademy.dto.SignUpRq;
import org.javaacademy.entity.User;
import org.javaacademy.exception.PasswordIncorrectException;
import org.javaacademy.exception.UserNotFoundException;
import org.javaacademy.mapper.UserMapper;
import org.javaacademy.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private UserDao userDao;
    private UserMapper userMapper;

    public Long createUser(SignUpRq signUpRq) {
        User user = userMapper.castToEntity(signUpRq);
        userDao.save(user);
        return user.getId();
    }

    public String loginUser(LoginRq loginRq) {
        User user = userDao.findByEmail(loginRq.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Не найден пользователь с почтой " + loginRq.getEmail()));

        if (!user.getPassword().equals(loginRq.getPassword())) {
            throw new PasswordIncorrectException("Неверный пароль для почты " + loginRq.getEmail());
        }

        return String.format("1234%s73aa", user.getName());
    }

    public User getUserByToken(String token) {
        String name = token.substring(4, token.length() - 4);
        return userDao.findByName(name)
                    .orElseThrow(() -> new UserNotFoundException("Не найден пользователь с токеном " + token));
    }
}
