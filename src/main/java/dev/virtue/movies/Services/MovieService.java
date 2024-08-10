package dev.virtue.movies.Services;

import dev.virtue.movies.Models.Movie;
import dev.virtue.movies.Repos.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }
    public Optional<Movie> oneMovie(ObjectId id) {
        return movieRepository.findById(id);
    }
}
