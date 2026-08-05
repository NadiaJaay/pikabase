# PikaBase

## Project Overview
PikaBase is a full-stack Spring Boot discussion forum for Pokémon games from Generation I–IV. The application allows users to browse games, create discussions, view discussion threads, and post replies.

## Features
- Browse Pokémon games by generations
- View the five most recent discussions on the homepage
- Create new discussions
- View discussion threads
- Reply to existing iscussions
- Role-based authentication using Spring Security
- Guest users can browse discussions
- Authenticated users can create discussions and replies
- Admin users can delete discussions
- Seeded database with sample Pokémon games- Frontend 
- integrated with Spring Boot REST API

## Tech Stack
### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Frontend
- Thymeleaf
- HTML
- CSS
- JavaScript (Fetch API)

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
| DELETE | `/discussions/{discussionId}` | Delete a discussion (Admin only) |

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
The application uses a local MySQL database named `pikabase`. Hibernate automatically creates the required tables on application startup. Sample Pokémon game data is seeded automatically when the application starts.

## What I Learned
This project strengthened my understanding of:
- Building layered Spring Boot applications
- Designing RESTful APIs
- Entity relationships with Spring Data JPA
- Spring Security authentication and authorization
- Thymeleaf template rendering
- Working with MySQL and Hibernate
- Transaction management using `@Transactional`
- Organizing a multi-page web application

## Demo Accounts
| Role | Username | Password |
|------|----------|----------|
| User | demo | pikabase |
| User | demoTwo | pikabaseTwo |
| Admin | admin | pikabaseadmin |

## Author
**Nadia Jujooste**
Built as a personal portfolio project to demonstrate Spring Boot, REST API development, and layered application architecture.