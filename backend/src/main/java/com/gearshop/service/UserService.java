package com.gearshop.service;

import com.gearshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> get(String email);

    Optional<User> get(Long id);

    List<User> getAll();

    void remove(Long id);

    User create(User user);

    User update(User user);
}
