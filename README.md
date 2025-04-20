# Learning Spring Boot - Phonebook Application

This is a simple Spring Boot application that demonstrates the basic concepts of Spring Boot and its layered architecture. The application is a phonebook that allows you to store and retrieve contact information.

## Project Structure

The project follows a layered architecture pattern:

![Layered Architecture](layer.png)

### Layers Explained

1. **Entity Layer** (`Phonebook.java`)

   - Represents the data model
   - Maps to database tables using JPA annotations
   - Contains the business data and rules

2. **Data Access Layer** (`PhonebookRepository.java`)

   - Handles database operations
   - Extends JpaRepository for CRUD operations
   - Manages data persistence

3. **Service Layer** (`PhonebookService.java`)

   - Contains business logic
   - Acts as a middle layer between Controller and Repository
   - Handles data processing and business rules

4. **API Layer** (`PhonebookController.java`)

   - Handles HTTP requests and responses
   - Exposes REST endpoints
   - Maps URLs to specific methods

5. **Configuration Layer** (`PhonebookConfig.java`)
   - Sets up application configuration
   - Defines beans and their dependencies
   - Configures database and other settings

## Features

- RESTful API endpoints
- PostgreSQL database integration
- JPA/Hibernate for ORM
- Layered architecture
- Sample data initialization

## Getting Started

1. Make sure you have Java 22 and Maven installed
2. Clone the repository
3. Configure your PostgreSQL database in `application.properties`
4. Run the application using:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints

- `GET /api/phonebook` - Get all phonebook entries

## Learning Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)

## Project Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- PostgreSQL Driver
- Spring Boot Starter Test

## Configuration

The application uses the following configuration (in `application.properties`):

- Server port: 8081
- Database: PostgreSQL
- JPA/Hibernate settings for development
# PhoneBook-SpringBoot-Boiler-Plate-
