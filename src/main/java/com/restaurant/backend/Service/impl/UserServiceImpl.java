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
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
    @Override
    public User update(Long id, User user) {
        User existing = findById(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setFullName(user.getFullName());
        existing.setPhone(user.getPhone());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        existing.setCreatedAt(user.getCreatedAt());
        return userRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createCustomer(User user) {
        return null;
    }

    @Override
    public <List> User GetAllCustomers() {
        return null;
    }

    @Override
    public User GetCustomerById(long id) {
        return null;
    }
}
