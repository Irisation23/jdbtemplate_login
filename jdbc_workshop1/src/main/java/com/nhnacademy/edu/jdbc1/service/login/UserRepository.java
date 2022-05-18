package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User findByUserName(String name);
    List<User> findByAll();
}
