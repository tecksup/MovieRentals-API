package com.theater.service;

import com.theater.model.Movie;
import com.theater.exception.MovieNotFoundException;
import com.theater.exception.NoDataFoundException;
import com.theater.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        List movies = (List<Movie>) movieRepository.findAll();

        if (movies.isEmpty()) {

            throw new NoDataFoundException();
        }

        return movies;
    }
}
