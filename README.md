# Movies Application

## Description
The Movies Application is a Spring Boot-based project designed to manage a collection of movies and their associated reviews. It leverages MongoDB for data storage and provides RESTful APIs for interacting with the movie and review data. The application includes enterprise-grade features such as security, caching, rate limiting, monitoring, and containerization.

## Features
- **Movie Management**: Add, update, and retrieve movie details.
- **Review Management**: Add and retrieve reviews for movies.
- **User Authentication**: Secure JWT-based authentication and authorization.
- **API Documentation**: Interactive API documentation with Swagger/OpenAPI.
- **Caching**: Performance optimization with Caffeine caching.
- **Rate Limiting**: Protection against abuse with IP-based rate limiting.
- **Monitoring**: Health checks and metrics with Spring Boot Actuator and Prometheus.
- **Containerization**: Docker and Docker Compose support for easy deployment.

## Technologies Used
- **Java 17**
- **Spring Boot 3.3**
- **Spring Security**
- **JWT Authentication**
- **MongoDB**
- **Swagger/OpenAPI**
- **Caffeine Cache**
- **Bucket4j Rate Limiting**
- **Spring Boot Actuator**
- **Prometheus & Grafana**
- **Docker & Docker Compose**
- **Maven**
- **Lombok**

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- Docker and Docker Compose (for containerized deployment)
- MongoDB (if running without Docker)

### Installation

#### Running with Docker (Recommended)
1. Clone the repository:
    ```sh
    git clone https://github.com/virtue-aina/movies-application.git
    ```
2. Navigate to the project directory:
    ```sh
    cd movies-application
    ```
3. Create a `.env` file with the following variables:
    ```
    MONGO_USERNAME=your_username
    MONGO_PASSWORD=your_password
    MONGO_DATABASE=movies
    JWT_SECRET=your_jwt_secret_key
    JWT_EXPIRATION=86400000
    ```
4. Start the application with Docker Compose:
    ```sh
    docker-compose up -d
    ```

#### Running Locally
1. Clone the repository:
    ```sh
    git clone https://github.com/virtue-aina/movies-application.git
    ```
2. Navigate to the project directory:
    ```sh
    cd movies-application
    ```
3. Install the dependencies:
    ```sh
    mvn install
    ```
4. Configure the MongoDB connection and JWT settings in the `application.properties` file.
5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### API Documentation
Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

### Monitoring
- **Actuator Endpoints**: http://localhost:8080/actuator
- **Prometheus**: http://localhost:9090
- **Grafana**: http://localhost:3000 (default credentials: admin/admin)

## Security
The application uses JWT-based authentication. To access protected endpoints:

1. Register a new user:
   ```
   POST /api/v1/auth/register
   ```

2. Login to get a JWT token:
   ```
   POST /api/v1/auth/login
   ```

3. Use the token in the Authorization header for subsequent requests:
   ```
   Authorization: Bearer <your_jwt_token>
   ```

## Project Structure
- `src/main/java/dev/virtue/movies/Models`: Contains the model classes.
- `src/main/java/dev/virtue/movies/Repos`: Contains the repository interfaces.
- `src/main/java/dev/virtue/movies/Services`: Contains the service classes.
- `src/main/java/dev/virtue/movies/Controllers`: Contains the REST controllers.
- `src/main/java/dev/virtue/movies/DTOs`: Contains the Data Transfer Objects.
- `src/main/java/dev/virtue/movies/Security`: Contains security-related classes.
- `src/main/java/dev/virtue/movies/Config`: Contains configuration classes.
- `src/main/java/dev/virtue/movies/Exceptions`: Contains exception handling classes.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
