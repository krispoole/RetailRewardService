# RetailRewardService

RetailRewardService is a Java-based web service for calculating customer reward points based on transaction records. The application uses the Spring Boot framework and Maven for dependency management.

## Description

This service calculates rewards for each customer based on their transactions. The main feature of the service is to provide the total rewards for a given customer. The project is developed using Java with Spring Boot and managed with Maven.

## Technology Stack

- Java 17
- Spring Boot 3.1.0
- Maven
- H2 database
- Lombok

## Getting Started

### Dependencies

This project uses the following dependencies:

- Spring Boot Starter Parent 3.1.0
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database
- Lombok
- Spring Boot Starter Test

You need to have a suitable Java Development Kit (JDK) installed on your system, version 17 or later. You also need Maven to manage and download the dependencies.

### Building the project

To build the project, run the following command in the root directory of the project:

```
mvn clean package
mvn spring-boot:run
```

## API

The service exposes the following REST API endpoint:


- GET /api/customer/{customerId}/rewards/total - Returns the total rewards of a given customer.
- GET /api/customer/{customerId}/rewards/{month} - Returns the total rewards of a given customer for a given month in Integer form.

## Database

The application uses an in-memory H2 database with appropriate data for testing purposes.

## Testing

The application uses JUnit 5 for unit testing and Mockito for mocking dependencies. The tests are located in the src/test/java directory.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
