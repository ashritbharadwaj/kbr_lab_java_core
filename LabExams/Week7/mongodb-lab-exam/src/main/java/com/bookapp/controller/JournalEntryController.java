package com.bookapp.controller;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.service.JournalEntryService;
import com.bookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journalEntry")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    private final UserService userService;

    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService, UserService userService) {
        this.journalEntryService = journalEntryService;
        this.userService = userService;
    }

    @PostMapping("/{id}")
    private void saveJournalEntry(@PathVariable String id,@RequestBody JournalEntry journalEntry) {
        User user = userService.getUser(id);
        journalEntry = journalEntryService.saveJournalEntry(journalEntry);
        user.getJournalEntries().add(journalEntry);
        userService.updateUser(user);
    }

    @GetMapping("/{id}")
    private JournalEntry getJournalEntry(@PathVariable String id) {
        return journalEntryService.getJournalEntry(id);
    }

    @PutMapping("/update/{id}")
    private JournalEntry updateJournalEntry(@RequestBody JournalEntry journalEntry) {
        return journalEntryService.updateJournalEntry(journalEntry);
    }

    @DeleteMapping("/{id}")
    private void deleteJournalEntry(@PathVariable String id) {
        journalEntryService.deleteJournalEntry(id);
    }

    @GetMapping("")
    private List<JournalEntry> getAllUsers() {
        return journalEntryService.getAllJournalEntries();
    }
}
