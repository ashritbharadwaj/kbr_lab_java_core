package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {

    private JournalEntryRepo journalEntryRepo;

    @Autowired
    public JournalEntryServiceImpl(JournalEntryRepo journalEntryRepo) {
        this.journalEntryRepo = journalEntryRepo;
    }

    @Override
    public JournalEntry saveJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepo.save(journalEntry);
    }

    @Override
    public JournalEntry getJournalEntry(String id) {
        return journalEntryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("JournalEntry not found"));
    }

    @Override
    public JournalEntry updateJournalEntry(JournalEntry journalEntry) {
        journalEntryRepo.save(journalEntry);
        return journalEntry;
    }

    @Override
    public void deleteJournalEntry(String id) {
        journalEntryRepo.deleteById(id);
    }

    @Override
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepo.findAll();
    }
}
