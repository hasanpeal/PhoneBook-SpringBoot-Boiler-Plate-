// This is Data Access Layer
package com.example.demo.phonebook;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Think of this as the filing cabinet where all the contact cards are stored:
 * - Each Phonebook object is like a single contact card
 * - The repository is like the filing cabinet that knows how to store and retrieve these cards
 * 
 * TECHNICAL EXPLANATION:
 * This is a Repository interface that:
 * 1. Extends JpaRepository to inherit common database operations
 * 2. Is marked with @Repository to be automatically detected by Spring
 * 3. Provides a contract for database operations on the Phonebook entity
 * 4. Allows for custom query methods to be defined
 */

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {
    /**
     * This method is used to find a Phonebook by its email address.
     * It returns an Optional<Phonebook> because the email might not exist in the database.
     * If the email exists, the Optional will contain the Phonebook object.
     * If the email does not exist, the Optional will be empty.
     */
    Optional<Phonebook> findPhonebookByPhoneNumber(String phoneNumber);
}
