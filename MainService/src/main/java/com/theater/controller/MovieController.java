package com.theater.controller;

import java.util.List;

import com.theater.model.Movie;
import com.theater.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	IMovieService movieService;

	@GetMapping(value = "/{id}")
	public Movie getMovie(@PathVariable Long id) {

		return movieService.findById(id);
	}

	@GetMapping()
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie createCity(@RequestBody @Validated Movie movie) {
		return movieService.save(movie);
	}
}
