# Game_store

## Project Description

The project is a Java-based web application developed using the Spring Boot framework. This application provides the capability to manage information about video games, including their title, release year, developer, and price. Additionally, it ensures secure user authentication and authorization.

## Dependencies

The project depends on the following libraries and frameworks:

- [Spring Boot](https://spring.io/projects/spring-boot) - a framework for Java web application development.
- [Thymeleaf](https://www.thymeleaf.org/) - a templating engine for creating web pages.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - a library for working with databases using Java Persistence API (JPA).
- [Spring Security](https://spring.io/projects/spring-security) - a library for application security, including authentication and authorization.
- [H2 Database](https://www.h2database.com/html/main.html) - an embedded database for development and testing.
- [Lombok](https://projectlombok.org/) - a library for simplifying Java application development.
- [Swagger](https://swagger.io/) - a tool for creating API documentation.

## Building the Project

The project uses the Apache Maven build system. You can build the application by following these steps:

1. Ensure you have Maven installed.
2. Open the command line and navigate to the project's root directory.
3. Execute the command `mvn clean install` to build the project and create an executable JAR file.

## Main Components

The project includes several main components:

- `com.mycompany.Application` - the main application class that launches Spring Boot.
- `com.mycompany.config` - a package containing application configurations, including security settings and Swagger.
- `com.mycompany.controller` - a package with web page controllers and REST services.
- `com.mycompany.db` - a package with classes for interacting with the database.
- `com.mycompany.model` - a package with data model classes.
- `com.mycompany.service` - a package with services for handling business logic.

## Swagger API

The project includes API documentation created using Swagger. You can access the Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to explore the available REST services.

## Authentication and Authorization

The application provides user authentication and authorization. By default, access is granted to a user with the username "guest" and the password "1234." You can configure new users and their permissions in the `com.mycompany.config.WebSecurityConfig` class.

## Database

The project uses an H2 database to store information about video games. The database is automatically created when the application is launched. You can configure database parameters in the `application.properties` file.
