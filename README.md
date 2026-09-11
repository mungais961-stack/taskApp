# SimonTaskApp

A task tracking application built with **Spring Boot** and **Java**, designed to help users manage and organize their tasks efficiently.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database](#database)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [License](#license)

## Features

- Task creation and management
- Real-time task tracking
- Data validation
- RESTful API endpoints
- In-memory database for development and testing

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- **Java 25** or higher
- **Maven 3.6+** (or use the included Maven wrapper)
- **Git** (for cloning the repository)

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/mungais961-stack/taskApp.git
cd taskApp
```

### 2. Install Dependencies

Using Maven wrapper (recommended):

```bash
./mvnw clean install
```

Or with Maven directly:

```bash
mvn clean install
```

### 3. Build the Project

```bash
./mvnw clean package
```

The compiled application will be located in the `target/` directory.

## Database

### Overview

This application uses **H2 Database**, an in-memory relational database, for development and testing purposes.

### Database Configuration

H2 is configured as the default database and is embedded in the application. No external database setup is required for development.

#### Key Details:

- **Database Type**: H2 In-Memory Database
- **Driver**: `com.h2database`
- **Scope**: Runtime and Development
- **Console Access**: Available at `http://localhost:8080/h2-console`

### Database Setup

The database is automatically initialized when the application starts. Tables and schemas are created using JPA configuration.

#### H2 Console Access

To access the H2 web console:

1. Start the application
2. Navigate to `http://localhost:8080/h2-console`
3. Default connection settings:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: (leave empty)

### Application Properties

Configure database settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### Database Entity Mapping

This application uses **Spring Data JPA** for object-relational mapping. Entity classes automatically map to database tables.

## Running the Application

### Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Using Maven

```bash
mvn spring-boot:run
```

### Using JAR File

```bash
java -jar target/taskApp-0.0.1-SNAPSHOT.jar
```

### Default Configuration

The application will start on:

- **Base URL**: `http://localhost:8080`
- **H2 Console**: `http://localhost:8080/h2-console`

## Testing

This project includes comprehensive test dependencies for unit and integration testing.

### Available Test Frameworks

- **Spring Data JPA Test** - For repository and database layer testing
- **Spring Web MVC Test** - For REST controller testing
- **Spring Validation Test** - For input validation testing

### Running Tests

Run all tests:

```bash
./mvnw test
```

Or with Maven:

```bash
mvn test
```

### Running Specific Test Classes

```bash
./mvnw test -Dtest=YourTestClassName
```

### Test Coverage

Generate test coverage reports:

```bash
./mvnw test jacoco:report
```

### Test Configuration

Tests use an embedded H2 database and do not require external setup. Test database configuration can be customized in:

- `src/test/resources/application-test.properties`

## Project Structure

```
taskApp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/simon/
│   │   │       ├── controller/     # REST API controllers
│   │   │       ├── service/        # Business logic layer
│   │   │       ├── repository/     # Data access layer
│   │   │       ├── entity/         # Database entities
│   │   │       ├── dto/            # Data transfer objects
│   │   │       └── exception/      # Custom exceptions
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/
│       ├── java/
│       │   └── com/simon/
│       │       ├── controller/
│       │       ├── service/
│       │       └── repository/
│       └── resources/
│           └── application-test.properties
├── .mvn/                   # Maven wrapper files
├── mvnw                    # Maven wrapper script (Linux/Mac)
├── mvnw.cmd               # Maven wrapper script (Windows)
├── pom.xml                # Maven configuration
└── README.md              # This file
```

## Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Spring Boot** | 4.0.3 | Web framework & application runtime |
| **Java** | 25 | Programming language |
| **Spring Data JPA** | - | Object-relational mapping |
| **H2 Database** | Latest | In-memory database |
| **Lombok** | Latest | Boilerplate reduction (getters, setters) |
| **Maven** | 3.6+ | Build and dependency management |
| **Spring Validation** | - | Input validation framework |

## Key Dependencies

- `spring-boot-starter-webmvc` - Web MVC support
- `spring-boot-starter-data-jpa` - JPA and Hibernate support
- `spring-boot-starter-validation` - Bean validation
- `spring-boot-h2console` - H2 database console
- `h2` - H2 database driver
- `lombok` - Code generation library

## Getting Help

If you encounter issues:

1. Check the logs in the console output
2. Verify H2 console connectivity at `http://localhost:8080/h2-console`
3. Ensure all dependencies are installed with `./mvnw clean install`
4. Review the `application.properties` configuration

## Contributing

To contribute to this project:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Version

**Current Version**: 0.0.1-SNAPSHOT

## License

This project is currently unlicensed. Please add a license file for production use.

---

**Last Updated**: September 2026  
**Author**: mungais961-stack
