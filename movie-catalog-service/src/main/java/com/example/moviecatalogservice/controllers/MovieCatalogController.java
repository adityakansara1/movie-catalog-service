package com.example.moviecatalogservice.controllers;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.UserRating;
import com.example.moviecatalogservice.services.GetCatalogService;
import com.example.moviecatalogservice.services.GetRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private GetCatalogService getCatalogService;

    @Autowired
    private GetRatingService getRatingService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating ratings = getRatingService.getUserRating(userId);

        assert ratings != null;
        return ratings.getRating().stream().map(rating -> getCatalogService.getCatalogItem(rating))
                .collect(Collectors.toList());
    }

}

//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://movie-info-service/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block(); // "block()" method is for making this call synchronous.
