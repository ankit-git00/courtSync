# courtSync

## About

courtSync is a Spring Boot application designed to simplify decision-making and coordination by creating polls and sharing them through WhatsApp groups. The project combines a REST API with WhatsApp integration so users can quickly create polls, store them in a database, and broadcast them to participants in a group conversation.

The application is built with Java 21 and Spring Boot 4.1.1, using PostgreSQL for persistence and Flyway for database migrations.

## Features

- Create and manage polls through a REST API
- Store poll data and option metadata in PostgreSQL
- Support WhatsApp-based poll distribution to groups
- Built with Spring Boot and modern Java
- Validation and database migration support out of the box

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Flyway
- Lombok
- Maven

## Project Structure

```text
courtSync/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/ankit/courtSync/
│   │   │   ├── polls/
│   │   │   └── whatsapp/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Main Modules

- `polls` – Poll entity, repository, service, controller, and DTOs
- `whatsapp` – WhatsApp integration for sending poll requests to a configured WhatsApp endpoint

## Prerequisites

Before running the project, ensure you have:

- Java 21+
- Maven
- PostgreSQL installed and running
- A configured WhatsApp endpoint accessible at the URL defined in `application.properties`

## Configuration

The app uses `src/main/resources/application.properties` for configuration. Example values include:

```properties
spring.application.name=courtSync
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/courtsync
spring.datasource.username=courtsync_user
spring.datasource.password=password

whatsappmeow.base-url=${WHATSAPPMEOW_BASE_URL:http://localhost:9090}
```

Update your PostgreSQL credentials and WhatsApp base URL to match your local environment.

## Run the Application

From the project root:

```bash
./mvnw spring-boot:run
```

Or with Maven:

```bash
mvn spring-boot:run
```

## API Overview

The project exposes poll-related endpoints under:

```text
/api/polls
```

Example request:

```json
{
  "question": "Which option should we choose?",
  "options": ["Option A", "Option B", "Option C"],
  "maxSelected": 1
}
```

The controller creates a poll and returns the created poll object.

## Notes

This project is currently a backend service focused on poll creation and WhatsApp integration. It is a strong foundation for extending the application with admin screens, authentication, notifications, or more advanced courtroom/meeting coordination workflows.

## License

This project does not currently declare a license in the repository metadata. Add one if you plan to distribute or publish the application publicly.
