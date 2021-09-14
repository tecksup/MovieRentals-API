package com.theater.service;

import com.theater.Movie;

import java.util.List;

public interface IMovieService {

    Movie findById(Long id);
    Movie save(Movie city);
    List<Movie> findAll();

}
