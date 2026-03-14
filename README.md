# Java Code Repository

A comprehensive collection of Java projects, design patterns, and development tools designed for learning, reference, and practical application in enterprise software development.

## Description

This repository serves as a personal knowledge base and reference collection for Java development. It contains production-ready code examples, implementation patterns, and containerized development environments that demonstrate modern Java enterprise practices. The repository is organized into three main components: a demonstration Spring Boot application, Gang of Four design patterns with practical examples, and Docker-based local development infrastructure.

## Repository Contents

### [Demo Project](./demo/README.md)

A production-ready Spring Boot application demonstrating enterprise Java development patterns and best practices.

**Technology Stack:**
- Spring Boot 3.5.0
- Java 17
- PostgreSQL Database
- Spring Data JPA / Hibernate
- MapStruct for DTO mapping
- Lombok for boilerplate reduction

**Key Features:**
- RESTful API design with full CRUD operations
- Layered architecture (Controller → Service → Repository)
- Transaction management
- Structured logging
- UUID-based entity identification

**Use Cases:** Interview preparation, live coding sessions, learning reference, project template

---

### [Design Patterns](./patterns/README.md)

A comprehensive collection of Gang of Four (GoF) design patterns implemented in Java with detailed documentation and practical examples.

**Pattern Categories:**

#### Creational Patterns
- **Singleton** — Ensures a class has only one instance
- **Factory** — Creates objects through a superclass with subclasses
- **Abstract Factory** — Creates families of related objects
- **Builder** — Step-by-step construction of complex objects
- **Prototype** — Cloning existing objects

#### Structural Patterns
- **Adapter** — Interface adapter for incompatible interfaces
- **Bridge** — Separates abstraction from implementation
- **Composite** — Tree structures for part-whole hierarchies
- **Decorator** — Dynamic behavior addition
- **Facade** — Simplified interface to complex systems
- **Flyweight** — Efficient object sharing
- **Proxy** — Access control surrogate

#### Behavioral Patterns
- **Observer** — Notification system for state changes
- **Strategy** — Algorithm selection at runtime
- **Command** — Request encapsulation
- **Template Method** — Algorithm skeleton definition
- **State** — Behavior based on internal state
- **Visitor** — Operations on object structures
- **Mediator** — Object communication coordination
- **Iterator** — Sequential element access
- **Memento** — Object state capture
- **Chain of Responsibility** — Request handler chain

---

### [Docker Dev Environment](./docker/README.md)

A containerized local development infrastructure with pre-configured services for rapid prototyping and development.

**Available Services:**

| Service | Port | Description |
|---------|------|-------------|
| PostgreSQL | 15432 | Relational database |
| MongoDB | 27017 | Document database |
| Redis | 16379 | In-memory key-value store |
| Keycloak | 18080/18443 | Identity & Access Management |
| Kafka | 19092 | Stream processing platform |
| Kafka UI | 18083 | Kafka monitoring interface |
| Node.js | 3000 | JavaScript runtime |
| Ollama | 11434 | Local LLM execution |
| Jupyter | 18888 | Data science notebook |
| pgAdmin | 18082 | PostgreSQL administration |
| Wiremock | 18081 | API mocking service |
| Qdrant | 6333 | Vector database for AI applications |

**Pre-configured Users:**
- PostgreSQL: demo/demo, keycloak/keycloak
- Keycloak: admin/admin
- pgAdmin: user@local.email/local

## Target Audience

- Java developers of all skill levels
- Software architects seeking reference implementations
- Technical interviewers and candidates
- Development teams building microservices
- Students learning enterprise Java patterns

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6+
- Docker Desktop
- Git

### Running the Demo Project

```bash
cd demo
./mvnw spring-boot:run
```

### Starting Development Environment

```bash
cd docker
docker-compose up -d
```

### Exploring Design Patterns

Navigate to `patterns/` directory and explore categorized implementations:

```bash
cd patterns
# List all pattern categories
ls -la
```

## Project Structure

```
.
├── demo/                          # Spring Boot demonstration project
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/              # Application source code
│   │   │   └── resources/        # Configuration files
│   │   └── test/                 # Unit tests
│   ├── pom.xml                    # Maven dependencies
│   └── README.md                  # Project documentation
│
├── patterns/                      # Design patterns collection
│   ├── creational/               # Creational patterns
│   │   ├── singleton/
│   │   ├── factory/
│   │   ├── abstractFactory/
│   │   ├── builder/
│   │   └── prototype/
│   ├── structural/               # Structural patterns
│   │   ├── adapter/
│   │   ├── bridge/
│   │   ├── composite/
│   │   ├── decorator/
│   │   ├── facade/
│   │   ├── flyweight/
│   │   └── proxy/
│   ├── behavioral/               # Behavioral patterns
│   │   ├── observer/
│   │   ├── strategy/
│   │   ├── command/
│   │   ├── template/
│   │   ├── state/
│   │   ├── visitor/
│   │   ├── mediator/
│   │   ├── iterator/
│   │   ├── memento/
│   │   └── chain/
│   └── README.md                  # Patterns overview
│
├── docker/                        # Development environment
│   ├── docker-compose.yml        # Container orchestration
│   ├── postgres/                # PostgreSQL configuration
│   ├── mongodb/                 # MongoDB configuration
│   ├── redis/                   # Redis configuration
│   ├── keycloak/                # Keycloak configuration
│   ├── kafka/                   # Kafka configuration
│   ├── qdrant/                  # Qdrant vector database
│   ├── ollama/                  # Ollama LLM execution
│   ├── nodejs/                  # Node.js samples
│   ├── jupyter/                 # Jupyter notebooks
│   ├── wiremock/                # API mocks
│   └── README.md                # Environment documentation
│
└── README.md                      # This file
```

## Learning Path

### For Beginners

1. Start with the [demo project](./demo/README.md) to understand Spring Boot basics
2. Explore [creational patterns](./patterns/creational/) for object creation concepts
3. Review [structural patterns](./patterns/structural/) for class composition
4. Study [behavioral patterns](./patterns/behavioral/) for object interaction

### For Intermediates

1. Review the demo project architecture and best practices
2. Implement design patterns in your own projects
3. Set up the Docker development environment
4. Experiment with Kafka, Keycloak, and other services

### For Advanced Developers

1. Use patterns as reference for complex implementations
2. Extend the demo project with new features
3. Customize Docker environment for specific needs
4. Contribute improvements to existing examples

## Technologies Covered

- **Frameworks**: Spring Boot 3.5.0
- **Languages**: Java 17, JavaScript (Node.js)
- **Databases**: PostgreSQL, MongoDB, Redis, Qdrant
- **Messaging**: Apache Kafka
- **Security**: Keycloak (OAuth2/OIDC)
- **ML/AI**: Ollama (Local LLM), Qdrant (Vector Database)
- **Data Science**: Jupyter
- **Testing**: WireMock
- **Build Tools**: Apache Maven

## License

This repository is for educational and reference purposes. Feel free to use the code and patterns in your own projects.

## Contributing

Contributions are welcome! Please ensure code follows existing patterns and include appropriate documentation when adding new examples or features.
