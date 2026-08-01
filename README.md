# PikaBase

## Project Overview
PikaBase is a Spring Boot REST API for a Pokémon discussion forum focused on Generation I–IV games. Users can browse games, create discussions, and reply to existing discussions. The project demonstrates layered application architecture, RESTful API design, Spring Data JPA, and database integration using Hibernate and h2.

## Features
- Browse Pokémon games
- View discussions for a game
- Create discussions
- View replies
- Reply to discussions
- Seeded H2 database on application startup

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/games` | Get all games |
| GET | `/games/{gameId}` | Get a game by ID |
| GET | `/discussions` | Get all discussions |
| POST | `/games/{gameId}/discussions` | Create a discussion |
| GET | `/discussions/{discussionId}/replies` | Get replies for a discussion |
| POST | `/discussions/{discussionId}/replies` | Create a reply |

### Prerequisites

- Java 21
- Maven
- Git

### Running the Application

1. Clone the repository.

```bash
git clone https://github.com/NadiaJaay/pikabase
```

2. Navigate to the project directory.

```bash
cd pika-base
```

3. Run the Spring Boot application.

```bash
./mvnw spring-boot:run
```

or run `PikaBaseApplication` from your IDE.

### Accessing the Application

Once the application is running:

- **REST API:** http://localhost:8080
- **H2 Console:** http://localhost:8080/h2-console

Use the following H2 connection settings:

| Property | Value |
|----------|-------|
| JDBC URL | `jdbc:h2:mem:pikabasedb` |
| Username | `nj` |
| Password | *(leave blank)* |

## Future Improvements
- Input validation
- Global exception handling
- DTOs
- PostgreSQL integration
- Frontend
- User authentication and authorization

## Author
**Nadia Jujooste**
Built as a personal portfolio project to demonstrate Spring Boot, REST API development, and layered application architecture.