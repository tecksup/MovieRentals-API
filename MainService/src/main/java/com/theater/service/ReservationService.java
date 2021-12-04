package com.theater.service;

import com.theater.exception.NoDataFoundException;
import com.theater.exception.ReservationNotFoundException;
import com.theater.model.Reservation;
import com.theater.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @Override
    public Reservation save(Reservation movie) {
        return reservationRepository.save(movie);
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
