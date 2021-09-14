package com.theater;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.theater.service.IMovieService;
import com.theater.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

	@Autowired
	IMovieService movieService;

	@GetMapping(value = "/movies/{id}")
	public Movie getMovie(@PathVariable Long id) {

		return movieService.findById(id);
	}

	@GetMapping(value = "/movies")
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	@PostMapping(value = "/cities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie createCity(@RequestBody @Validated Movie movie) {
		return movieService.save(movie);
	}
}
