package com.bookapp.service;

import com.bookapp.entities.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUser(String id);

    User updateUser(User user);

    void deleteUser(String id);

    List<User> getAllUsers();

    User getUserByJournalEntryId(String journalEntryId);
}
