package com.bookapp.service;

import com.bookapp.entities.JournalEntry;

import java.util.List;

public interface JournalEntryService {
    JournalEntry saveJournalEntry(JournalEntry journalEntry);

    JournalEntry getJournalEntry(String id);

    JournalEntry updateJournalEntry(JournalEntry journalEntry);

    void deleteJournalEntry(String id);

    List<JournalEntry> getAllJournalEntries();
}
