// This is Entity Layer
package com.example.demo.phonebook;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Think of this as a contact card in a physical phonebook:
 * - Each Phonebook object is like a single contact card
 * - The fields (id, name, phoneNumber, dob) are like the information written on the card
 * 
 * TECHNICAL EXPLANATION:
 * This is an Entity class that:
 * 1. Represents a single phonebook entry in the database
 * 2. Uses Java's encapsulation principle (private fields with public getters/setters)
 * 3. Follows Java Bean conventions for serialization
 * 4. Can be mapped to a database table using JPA annotations
 */
@Entity // Like marking this as a special card that can be stored in a database
@Table // Like specifying this card belongs in the main phonebook table
public class Phonebook {
    @Id // Like marking this as the unique identifier field on the card
    @SequenceGenerator(
        name = "phonebook_sequence",
        sequenceName = "phonebook_sequence",
        allocationSize = 1
    ) // Like setting up a system to automatically generate unique ID numbers for new cards
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "phonebook_sequence"
    ) // Like telling the system to automatically fill in the ID number when creating new cards
    // Like a unique ID number on each contact card
    private Long id;
    // The person's name written on the card
    private String name;
    // Their phone number
    private String phoneNumber;
    // Their date of birth
    private LocalDate dob;
    // Their age
    // @Transient is used to indicate that this field is not a persistent field
    // and should not be included in the database table
    @Transient
    private Integer age;

    /**
     * No-argument constructor required by Hibernate
     * 
     * TECHNICAL EXPLANATION:
     * Hibernate needs this constructor to create new instances of this class
     * when reading data from the database. It's like a blank contact card
     * that Hibernate can fill in with data from the database.
     */
    public Phonebook() {
    }

    /**
     * Constructor with all fields - like filling out a complete contact card
     * TECHNICAL: This is a parameterized constructor that initializes all fields
     */
    public Phonebook(Long id, String name, String phoneNumber, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    /**
     * Constructor without ID - like creating a new contact card
     * TECHNICAL: Used when creating new entries before they're saved to the database
     */
    public Phonebook(String name, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    /**
     * Minimal constructor - like a quick note with just essential info
     * TECHNICAL: Provides flexibility in creating objects with only required fields
     */
    public Phonebook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters - like being able to read and update information on the card
    // TECHNICAL: These methods provide controlled access to private fields
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Phonebook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
    