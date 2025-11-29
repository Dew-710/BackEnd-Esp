package com.restaurant.backend.Service;

import com.restaurant.backend.Entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);

    User createCustomer(User user);
    <List> User GetAllCustomers();
    User GetCustomerById(long id);

}
