package dev.virtue.movies.Services;

import dev.virtue.movies.Exceptions.ResourceNotFoundException;
import dev.virtue.movies.Models.Movie;
import dev.virtue.movies.Models.Review;
import dev.virtue.movies.Repos.MovieRepository;
import dev.virtue.movies.Repos.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
/**
 * TODO-implement Validation and Authentication
 */
@Service
public class ReviewService {
   private final ReviewRepository reviewRepository;
   private final MovieRepository movieRepository;
   private final MongoTemplate mongoTemplate;

   public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository, MongoTemplate mongoTemplate) {
       this.reviewRepository = reviewRepository;
       this.movieRepository = movieRepository;
       this.mongoTemplate = mongoTemplate;
   }
   /**
    * Creates a new review for a movie
    * @param reviewBody The content of the review
    * @param movieId The ID of the movie being reviewed
    * @return The created review
    * @throws ResourceNotFoundException if the movie with the given ID does not exist
    */
   public Review createReview(String reviewBody, String movieId) {
        // Validate that the movie exists
        ObjectId objectId;
        try {
            objectId = new ObjectId(movieId);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("Movie", "id", movieId);
        }

        // Check if movie exists
        Movie movie = movieRepository.findById(objectId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        // Create and save the review
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Update the movie with the new review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("id").is(objectId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
