package com.gearshop.service;

import com.gearshop.entity.Role;
import com.gearshop.entity.User;
import com.gearshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BasePasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BasePasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    protected void createAdmin() {
        String email = "admin@gmail.com";
        String password = "admin";
        String firstName = "Владимир";
        String lastName = "Morozov";
        Role role = Role.ADMIN;
        User user = new User(
                email,
                passwordEncoder.encodePassword(password, email),
                firstName,
                lastName,
                role);
        userRepository.save(user);
    }

    @Override
    public Optional<User> get(String email) {
        return userRepository.getOneByEmail(email);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.getOneById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }

    // TODO: 03.01.2017 encrypt user pass there or before?
    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getEmail()));
        return userRepository.save(user);
    }

    // TODO: 04.01.2017 don't update user with Id != null
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
