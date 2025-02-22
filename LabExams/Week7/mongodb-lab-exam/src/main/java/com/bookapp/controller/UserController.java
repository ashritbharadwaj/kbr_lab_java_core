package com.bookapp.controller;

import com.bookapp.entities.User;
import com.bookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    private void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/{id}")
    private User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    private User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/journalEntry/{journalEntryId}")
    public User getUserByJournalEntryId(@PathVariable String journalEntryId) {
        return userService.getUserByJournalEntryId(journalEntryId);
    }
}
