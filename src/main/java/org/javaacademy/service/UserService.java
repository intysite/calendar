package org.javaacademy.service;

import lombok.AllArgsConstructor;
import org.javaacademy.dto.SignUpRq;
import org.javaacademy.entity.User;
import org.javaacademy.mapper.UserMapper;
import org.javaacademy.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private UserDao userDao;
    private UserMapper userMapper;

    public Long createUser( SignUpRq signUpRq) {
        User user = userMapper.castToEntity(signUpRq);
        userDao.save(user);
        return user.getId();
    }
}
