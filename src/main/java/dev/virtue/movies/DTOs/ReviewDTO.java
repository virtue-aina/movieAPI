package dev.virtue.movies.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    
    @NotBlank(message = "Review body cannot be blank")
    @Size(min = 5, max = 500, message = "Review body must be between 5 and 500 characters")
    private String reviewBody;
    
    @NotBlank(message = "Movie ID cannot be blank")
    private String movieId;
}