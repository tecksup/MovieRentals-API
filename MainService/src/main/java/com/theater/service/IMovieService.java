package com.theater.service;

import com.theater.model.Movie;

import java.util.List;

public interface IMovieService {

    Movie findById(Long id);
    Movie save(Movie movie);
    List<Movie> findAll();

}
