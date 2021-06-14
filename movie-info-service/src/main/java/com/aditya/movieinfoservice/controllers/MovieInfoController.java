package com.aditya.movieinfoservice.controllers;

import com.aditya.movieinfoservice.models.Movie;
import com.aditya.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

//    @Value("${api.key}")
//    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getmovieInfo(@PathVariable String movieId) {
        final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=cea3b7a0b210db1ea9f3707365849dd8";
        MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
        assert movieSummary != null;
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}