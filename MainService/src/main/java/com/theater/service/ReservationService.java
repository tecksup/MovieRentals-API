package com.theater.service;

import com.theater.exception.MovieAlreadyReservedException;
import com.theater.exception.NoDataFoundException;
import com.theater.exception.ReservationNotFoundException;
import com.theater.model.Reservation;
import com.theater.repository.MovieRepository;
import com.theater.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService implements IReservationService{

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @Override
    public Reservation makeReservation(Reservation reservation) {
        //Check if the movie we want to reserve is already reserved
        if (!movieRepository.findById((long) reservation.getReservedMovieId()).get().isReserved()) {
            //Sets the movie reservation flag to true
            movieRepository.findById((long) reservation.getReservedMovieId()).get().setReserved(true);

            //Adds the reservation to the repository and returns that object
            return reservationRepository.save(reservation);

        } else {
            throw new MovieAlreadyReservedException((long) reservation.getReservedMovieId());
        }
    }

    @Override
    public ResponseEntity<Object> returnReservation(Long id) {

        //Check if the movie we want to turn in is already returned
        if (movieRepository.findById((long) reservationRepository.findById(id).get().getReservedMovieId()).get().isReserved()) {
            //Set movie as not reserved
            movieRepository.findById((long) reservationRepository.findById(id).get().getReservedMovieId()).get().setReserved(false);

            reservationRepository.deleteById(id);

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", "Reservation removed successfully");

            return new ResponseEntity<>(body, HttpStatus.ACCEPTED);

        } else {
            throw new ReservationNotFoundException(id);
        }
    }

    @Override
    public List<Reservation> findAll() {
        List movies = (List<Reservation>) reservationRepository.findAll();

        if (movies.isEmpty()) {

            throw new NoDataFoundException();
        }

        return movies;
    }

}
