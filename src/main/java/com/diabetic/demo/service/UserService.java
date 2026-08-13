package com.diabetic.demo.service;

import java.util.List;

import com.diabetic.demo.entity.User;

public interface UserService {

    User saveUser(Long roleId, User user);

    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    User updateUser(User user, Long id, Long roleId);

    void deleteUser(Long id);
}