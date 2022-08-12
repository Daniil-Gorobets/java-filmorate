package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll() {
        log.info("Request endpoint: 'GET /users'");
        return userService.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        log.info("Request endpoint: 'POST /users'");
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        log.info("Request endpoint: 'PUT /users'");
        return userService.update(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        log.info("Request endpoint: 'GET /users/{}'", id);
        return userService.getById(id);
    }

    @PutMapping("/{id}/friends/{friendId}")
    public void addFriend(@PathVariable int id, @PathVariable int friendId) {
        log.info("Request endpoint: 'PUT /users/{}/friends/{}'", id, friendId);
        userService.addFriend(id, friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public void deleteFriend(@PathVariable int id, @PathVariable int friendId) {
        log.info("Request endpoint: 'DELETE /users/{}/friends/{}'", id, friendId);
        userService.deleteFriend(id, friendId);
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable int id) {
        log.info("Request endpoint: 'GET /users/{}/friends'", id);
        return userService.getFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> getCommonFriends(@PathVariable int id, @PathVariable int otherId) {
        log.info("Request endpoint: 'GET /users/{}/friends/common/{}'", id, otherId);
        return userService.getCommonFriends(id, otherId);
    }
}
