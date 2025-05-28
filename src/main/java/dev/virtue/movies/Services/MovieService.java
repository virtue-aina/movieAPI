package dev.virtue.movies.Services;

import dev.virtue.movies.Exceptions.ResourceNotFoundException;
import dev.virtue.movies.Models.Movie;
import dev.virtue.movies.Repos.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Cacheable(value = "allMovies")
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    @Cacheable(value = "movieById", key = "#id.toString()")
    public Movie oneMovie(ObjectId id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
    }

    @Cacheable(value = "movieByImdbId", key = "#imdbId")
    public Movie getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbID(imdbId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "imdbID", imdbId));
    }

    @Cacheable(value = "moviesByTitle", key = "#title")
    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    @Cacheable(value = "moviesByGenre", key = "#genre")
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenresContaining(genre);
    }
}
