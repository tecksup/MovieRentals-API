package com.theater.controller;

import com.theater.model.Movie;
import com.theater.model.Reservation;
import com.theater.service.IMovieService;
import com.theater.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    IMovieService movieService;
    @Autowired
    IReservationService reservationService;

    @GetMapping(value = "/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @GetMapping()
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation makeReservation(@RequestBody Reservation reservation) {
        return reservationService.makeReservation(reservation);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> returnReservation(@PathVariable Long id) {
        return reservationService.returnReservation(id);
    }

}

