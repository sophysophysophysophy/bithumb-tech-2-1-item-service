package net.sophy.api.user.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.sophy.api.user.domain.User;
import net.sophy.api.user.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public class UserController{
    private final UserService userService;

    public List<User> findAll() {
        return userService.findAll();
    }

    public Optional<User> findById(long id) {
        return userService.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }

    public boolean existById(long id) {
        return userService.existById(id);
    }

    public int count() {
        return (int) userService.count();
    }

    public void save(User entity) {
        userService.save(entity);
    }

    public void deleteById(long id) {
        userService.deleteById(id);
    }

    public void deleteAll() {
        userService.deleteAll();
    }

    public User getById(long id) {
        return userService.getById(id);
    }

    public boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }

    public User signin(String username, String password) {
        return userService.signin(username, password);
    }

}
