package com.aditya.ratingsdataservice.controllers;

import com.aditya.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingDataController {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable String movieId) {
        return new Rating(movieId, "4");
    }

    @RequestMapping("/{userId}")
    public List<Rating> getRating(@PathVariable String userId) {

        // Fetch rated movies by {userId} and return a list of Ratings.

        List<Rating> ratings = Arrays.asList(
                new Rating("1", "4"),
                new Rating("2", "4")
        );
        return ratings;
    }
}
