package com.restaurant.backend.Service.impl;

import com.restaurant.backend.Entity.User;
import com.restaurant.backend.Repository.UserRepository;
import com.restaurant.backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public List<User> getAll() {
        return List.of();
    }
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Mật khẩu không đúng");
        }

        return user;
    }

    @Override
    public User findByUsername(String Username) {
        return null;
    }
}
