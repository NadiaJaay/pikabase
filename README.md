# PikaBase

## Project Overview
PikaBase is a full-stack Spring Boot discussion forum for Pokémon games from Generation I–IV. The application allows users to browse games, create discussions, view discussion threads, and post replies.

## Features
- Browse Pokémon games by generations
- View the five most recent discussions on the homepage
- Create new discussions
- View discussion threads
- Reply to dexisting iscussions
- Seeded database with sample Pokémon games- Frontend 
- integrated with Spring Boot REST API

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Frontend
- HTML
- CSS
- JavaScript

## Architecture
The application follows a layered architecture:

Controller
↓
Service
↓
Repository
↓
MySQL Database

The frontend communicates with the backend through REST API endpoints using the Fetch API.

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/games` | Get all games |
| GET | `/games/{gameId}` | Get a game by ID |
| GET | `/discussions` | Get all discussions |
| GET | `/games/{gameId}/discussions` | Get discussions for a game |
| GET | `/discussions/{discussionId}` | Get a discussion |
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

### Database
The application uses a local MySQL database named `pikabase`. Hibernate automatically creates the required tables on application startup.

## Future Improvements
- Edit and delete discussions
- User authentication and authorization

## What I Learned
This project strengthened my understanding of:
- Building layered Spring Boot applications
- Designing RESTful APIs
- Entity relationships using Spring Data JPA
- Validation and global exception handling
- Organizing a multi-page web application

## Author
**Nadia Jujooste**
Built as a personal portfolio project to demonstrate Spring Boot, REST API development, and layered application architecture.