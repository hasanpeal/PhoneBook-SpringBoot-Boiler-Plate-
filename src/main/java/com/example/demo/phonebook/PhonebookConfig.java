package com.example.demo.phonebook;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class for the Phonebook application.
 * It is used to configure the application context and beans.
 * 
 * TECHNICAL EXPLANATION:
 * This class is marked with @Configuration to indicate it's a configuration class
 * It is used to configure the application context and beans.
 * It is also used to configure the database connection.
 * It is also used to configure the JPA properties.
 * It is also used to configure the Hibernate properties.
 * It is also used to configure the Spring Security properties.
 * It is also used to configure the Spring Boot properties.
 */
@Configuration
public class PhonebookConfig {

    /**
     * This method is marked with @Bean to tell Spring to create and manage this object.
     * 
     * TECHNICAL EXPLANATION:
     * Think of @Bean like a recipe in a cookbook. When you mark a method with @Bean,
     * you're telling Spring: "Here's how to make this object. Please make it and keep it
     * ready for me when I need it." 
     * 
     * In this case, we're telling Spring to create a special object (CommandLineRunner)
     * that will run some code when the application starts. This code will add two sample
     * contacts (John and Jane) to our phonebook database.
     */
    @Bean
    CommandLineRunner commandLineRunner(PhonebookRepository repository) {
        return _ -> {
            Phonebook john = new Phonebook(
                "John Doe",
                "1234567890",
                LocalDate.of(1990, 1, 1)
            );
            
            Phonebook jane = new Phonebook(
                "Jane Doe",
                "0987654321",
                LocalDate.of(1995, 2, 15)
            );
            
            repository.saveAll(List.of(john, jane));
        };
    }
}
