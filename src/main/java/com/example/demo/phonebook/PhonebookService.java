// This is Service Layer
package com.example.demo.phonebook;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * Think of this as the phonebook's manager:
 * - Like a librarian who knows how to find and organize contact information
 * - Handles all the business logic for managing phonebook entries
 * - Works between the receptionist (Controller) and the storage room (Database)
 * 
 * TECHNICAL EXPLANATION:
 * This is a Service class that:
 * 1. Contains business logic and data processing
 * 2. Is marked with @Service to be automatically detected by Spring
 * 3. Acts as a middle layer between Controller and Repository
 * 4. Implements transaction management and business rules
 */
@Service
public class PhonebookService {

    private final PhonebookRepository phonebookRepository;

    @Autowired
    public PhonebookService(PhonebookRepository phonebookRepository) {
        this.phonebookRepository = phonebookRepository;
    }

    /**
     * Like a librarian retrieving all contact cards from the filing cabinet
     * 
     * TECHNICAL EXPLANATION:
     * This method:
     * 1. Returns a list of all phonebook entries
     * 2. Currently returns hardcoded data, but would typically:
     *    - Call a repository to get data from the database
     *    - Apply business logic and transformations
     *    - Handle exceptions and edge cases
     */
    public List<Phonebook> getPhonebookList() {
        return phonebookRepository.findAll();
    }

    public void addNewPhonebook(Phonebook phonebook) {
        Optional<Phonebook> phonebookOptional = 
            phonebookRepository.findPhonebookByPhoneNumber(phonebook.getPhoneNumber());
        if (phonebookOptional.isPresent()) {
            throw new IllegalStateException("phone number taken");
        }
        System.out.println("Saving new phonebook: \n" + phonebook + "\n");
        phonebookRepository.save(phonebook);
    }

    public void deletePhonebook(Long phonebookId) {
        boolean exists = phonebookRepository.existsById(phonebookId);
        if (!exists) {
            throw new IllegalStateException("phonebook with id " + phonebookId + " does not exist");
        }
        phonebookRepository.deleteById(phonebookId);
    }

    /**
     * This is like a librarian updating a contact card in the filing cabinet:
     * - @Transactional ensures all changes are saved to the database
     * - Handles validation and persistence of changes
     * - Works between the receptionist (Controller) and the storage room (Database)
     */
    @Transactional
    public void updatePhonebook(Long phonebookId, String phoneNumber, String name) {
        Phonebook phonebook = phonebookRepository.findById(phonebookId)
            .orElseThrow(() -> new IllegalStateException("phonebook with id " + phonebookId + " does not exist"));
        if (phoneNumber != null && !phoneNumber.isEmpty() && !Objects.equals(phonebook.getPhoneNumber(), phoneNumber)) {
            phonebook.setPhoneNumber(phoneNumber);
        }
        if (name != null && !name.isEmpty() && !Objects.equals(phonebook.getName(), name)) {
            phonebook.setName(name);
        }
    }
}