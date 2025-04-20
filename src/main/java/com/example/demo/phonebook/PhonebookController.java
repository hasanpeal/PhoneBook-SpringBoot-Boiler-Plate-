// This is API Layer
package com.example.demo.phonebook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Think of this as the hotel's reception desk:
 * - @RestController is like the front desk that handles all guest requests
 * - It's the first point of contact for all incoming requests
 * - Like a receptionist, it:
 *   * Receives requests from guests (HTTP clients)
 *   * Delegates work to the back office (Service)
 *   * Returns responses directly to guests
 * 
 * TECHNICAL EXPLANATION:
 * This is a Controller class that:
 * 1. Handles HTTP requests and responses
 * 2. Uses @RestController to indicate it returns data, not views
 * 3. Maps URLs to specific methods using annotations
 * 4. Implements the API endpoints for the phonebook application
 */
@RestController
/**
 * This is like the hotel's address and floor number:
 * - All requests must start with "api/phonebook"
 * - Like saying "To reach the phonebook department, go to the 3rd floor"
 * 
 * TECHNICAL:
 * @RequestMapping defines the base URL path for all endpoints in this controller
 * All method URLs will be prefixed with this path
 */
@RequestMapping("api/phonebook")
public class PhonebookController {

    // This is like the receptionist's assistant who does the actual work
    // TECHNICAL: This is a dependency that will be automatically injected by Spring
    private final PhonebookService phonebookService;

    /**
     * This is like automatic staffing:
     * - @Autowired is like a manager automatically assigning an assistant
     * - Spring automatically provides the PhonebookService when needed
     * - No need to manually create the service
     * 
     * TECHNICAL EXPLANATION:
     * Constructor injection with @Autowired:
     * 1. Spring's dependency injection system automatically provides the service
     * 2. Makes the code more testable and maintainable
     * 3. Follows the Dependency Inversion Principle
     * 4. The service is marked as final to ensure it's not changed after construction
     */
    @Autowired
    public PhonebookController(PhonebookService phonebookService) {
        this.phonebookService = phonebookService;
    }

    /**
     * This is like a specific request type at the reception desk:
     * - @GetMapping means this handles requests for information
     * - When someone visits "api/phonebook", this method is called
     * - Like a receptionist's specific task of looking up phone numbers
     * 
     * TECHNICAL EXPLANATION:
     * This endpoint:
     * 1. Handles HTTP GET requests to the base URL
     * 2. Returns a list of phonebook entries
     * 3. Delegates the actual work to the service layer
     * 4. Automatically converts the response to JSON
     */
    @GetMapping
    public List<Phonebook> getPhonebookList() {
        return phonebookService.getPhonebookList();
    }

    /**
     * This is like a specific request type at the `reception desk:
     * - @PostMapping means this handles requests for information
     * - When someone visits "api/phonebook", this method is called
     * - Like a receptionist's specific task of looking up phone numbers
     * 
     * TECHNICAL EXPLANATION:
     * This endpoint:
     * 1. Handles HTTP GET requests to the base URL
     */
    @PostMapping
    public void addNewPhonebook(@RequestBody Phonebook phonebook) {
        phonebookService.addNewPhonebook(phonebook);
    }

    /**
     * This is like a specific request type at the `reception desk:
     * - @PutMapping means this handles requests for information
     * - When someone visits "api/phonebook", this method is called
     * - Like a receptionist's specific task of looking up phone numbers
     * 
     */
    @PutMapping(path = "{phonebookId}")
    public void updatePhonebook(@PathVariable("phonebookId") Long phonebookId, 
                                @RequestBody(required = false) String phoneNumber,
                                @RequestBody(required = false) String name) {
        phonebookService.updatePhonebook(phonebookId, phoneNumber, name);
    }
    
    /**
     * This is like a specific request type at the `reception desk:
     * - @DeleteMapping means this handles requests for information
     * - When someone visits "api/phonebook", this method is called
     * - Like a receptionist's specific task of looking up phone numbers
     * 
     */
    @DeleteMapping(path = "{phonebookId}")
    public void deletePhonebook(@PathVariable("phonebookId") Long phonebookId) {
        phonebookService.deletePhonebook(phonebookId);
    }
}
