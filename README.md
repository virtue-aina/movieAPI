### README

# Movies Application

## Description
The Movies Application is a Spring Boot-based project designed to manage a collection of movies and their associated reviews. It leverages MongoDB for data storage and provides RESTful APIs for interacting with the movie and review data.

## Features
- **Movie Management**: Add, update, and retrieve movie details.
- **Review Management**: Add and retrieve reviews for movies.
- **MongoDB Integration**: Uses MongoDB for storing movie and review data.
- **Spring Boot**: Utilizes Spring Boot for rapid application development and deployment.

## Technologies Used
- **Java**
- **Spring Boot**
- **MongoDB**
- **Maven**
- **Lombok**
- **Jackson**

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- MongoDB

### Installation
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

### Configuration
Configure the MongoDB connection in the `application.properties` file:
```ini
spring.data.mongodb.database=<your-database-name>
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>
```

### Running the Application
To run the application, use the following command:
```sh
mvn spring-boot:run
```

### Running Tests
To run the tests, use the following command:
```sh
mvn test
```

## Project Structure
- `src/main/java/dev/virtue/movies/Models`: Contains the model classes for Movie and Review.
- `src/main/java/dev/virtue/movies/Repos`: Contains the repository interfaces for MongoDB.
- `src/main/java/dev/virtue/movies/Services`: Contains the service classes for business logic.
- `src/test/java/dev/virtue/movies`: Contains the test classes.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
