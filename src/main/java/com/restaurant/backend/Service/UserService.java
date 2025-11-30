package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);

    List<User> getAll();

    User login(String email, String password);

    User findByUsername (String Username);
}
