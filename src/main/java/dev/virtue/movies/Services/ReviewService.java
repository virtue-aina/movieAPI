package dev.virtue.movies.Services;

import dev.virtue.movies.Models.Movie;
import dev.virtue.movies.Models.Review;
import dev.virtue.movies.Repos.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
/**
 * TODO-implement Validation and Authentication
 */
@Service
public class ReviewService {
   @Autowired
   private ReviewRepo reviewRepo;
   @Autowired
   private MongoTemplate mongoTemplate;
   public Review createReview(String reviewBody , String id) {
        Review review = reviewRepo.insert(new Review(reviewBody));
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
