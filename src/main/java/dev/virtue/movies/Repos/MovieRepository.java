package dev.virtue.movies.Repos;

import dev.virtue.movies.Models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
    // Find a movie by its imdbID
    Optional<Movie> findByImdbID(String imdbID);

    // Find movies by title containing the given string (case-insensitive)
    List<Movie> findByTitleContainingIgnoreCase(String title);

    // Find movies by genre
    List<Movie> findByGenresContaining(String genre);
}
