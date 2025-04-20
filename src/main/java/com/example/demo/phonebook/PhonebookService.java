// This is Service Layer
package com.example.demo.phonebook;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println("Saving new phonebook: \n" + phonebook + "\n");
        phonebookRepository.save(phonebook);
    }
}