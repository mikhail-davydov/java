# Spring Boot Demo Project

A comprehensive demonstration project showcasing modern Java enterprise application development with Spring Boot. This project serves as a practical reference for interview preparation, live coding sessions, and learning enterprise-grade application patterns.

## Overview

This demo application implements a RESTful API for user management, demonstrating core concepts of Spring Boot development including layered architecture, data persistence, DTO mapping, and transaction management. The project is designed to be a production-ready starting point that can be extended with additional features.

## Technology Stack

| Category | Technology | Version |
|----------|------------|---------|
| Framework | Spring Boot | 3.5.0 |
| Language | Java | 17 |
| Database | PostgreSQL | 42.7.7 |
| ORM | Spring Data JPA / Hibernate | - |
| DTO Mapping | MapStruct | 1.6.3 |
| Build Tool | Apache Maven | - |
| Logging | Lombok @Slf4j | - |

## Architecture

The project follows a layered architecture pattern commonly used in enterprise Java applications:

```
src/main/java/sample/mkhldvdv/demo/
├── DemoApp.java                    # Application entry point
├── controller/                     # REST API controllers
│   ├── DemoAppHelloController.java
│   └── DemoAppUsersController.java
├── service/                        # Business logic layer
│   └── DemoAppService.java
├── repository/                     # Data access layer
│   └── DemoAppRepository.java
├── model/                          # Entity classes
│   └── DemoAppUser.java
├── dto/                            # Data Transfer Objects
│   ├── DemoAppDto.java
│   └── DemoAppUserDto.java
└── mapper/                         # MapStruct mappers
    └── DemoAppUsersMapper.java
```

## Key Features

### REST API Endpoints

The application provides the following REST endpoints for user management:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Retrieve all users |
| GET | `/api/users/{userId}` | Get user by UUID |
| POST | `/api/users` | Create or update a user |
| DELETE | `/api/users/{userId}` | Delete user by UUID |

### Data Model

The `DemoAppUser` entity contains the following fields:
- `userId` (UUID) - Primary key
- `username` (String) - Unique username
- `firstname` (String) - User's first name
- `lastname` (String) - User's last name

### Technical Highlights

- **MapStruct Integration**: Type-safe DTO to entity mapping with compile-time code generation
- **Lombok**: Reduced boilerplate code using annotations (@Slf4j, @RequiredArgsConstructor)
- **Transactional Support**: Proper transaction management with @Transactional annotations
- **Logging**: Structured logging throughout all layers
- **Exception Handling**: Runtime exception handling for not found scenarios
- **Pagination Support**: Ready for Pageable integration (imports present)

## Database Configuration

The application is configured to connect to PostgreSQL with the following default settings:

- **Host**: localhost:5432
- **Database**: local
- **Schema**: demo
- **Username**: demo
- **Password**: demo

The JPA configuration uses `create-drop` for development, automatically creating tables on startup.

## Build and Run

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6+
- PostgreSQL 14+ (or use Docker compose from parent directory)

### Build

```bash
cd demo
./mvnw clean package
```

### Run

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Run Tests

```bash
./mvnw test
```

## Use Cases

This demo project is ideal for:

1. **Interview Preparation**: Demonstrates understanding of Spring Boot fundamentals, REST API design, and clean code principles
2. **Live Coding**: Quick prototype foundation for live coding exercises
3. **Learning Reference**: Study material for understanding Spring Boot best practices
4. **Template Starting Point**: Base project for new Spring Boot applications

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── java/           # Java source code
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/           # Unit tests
├── mvnw                     # Maven wrapper
├── pom.xml                  # Project dependencies
└── README.md               # This file
```

## Dependencies Overview

- **spring-boot-starter-web**: REST API development with Spring MVC
- **spring-boot-starter-data-jpa**: Database access with JPA and Hibernate
- **postgresql**: PostgreSQL JDBC driver
- **mapstruct**: Type-safe bean mapping
- **lombok**: Annotation processor for reducing boilerplate
- **spring-boot-starter-test**: Testing framework

## Configuration

Application configuration is managed through `application.yml`:

```yaml
api:
    version: 0.0.1
server:
    port: 8080
spring:
    jpa:
        hibernate:
            ddl-auto: create-drop
        show-sql: true
    datasource:
        url: jdbc:postgresql://localhost:5432/local?currentSchema=demo
        username: demo
        password: demo
```

## Target Audience

- Java developers learning Spring Boot
- Technical interviewers and interviewees
- Software architects reviewing implementation patterns
- Development teams seeking reference implementations
