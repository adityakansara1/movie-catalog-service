package com.aditya.movieinfoservice.controllers;

import com.aditya.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    public Movie getmovieInfo(@PathVariable String movieId) {
        return new Movie(movieId, movieId);
    }


}