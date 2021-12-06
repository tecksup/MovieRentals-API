package com.theater.service;

import com.theater.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReservationService {

    Reservation findById(Long id);
    Reservation makeReservation(Reservation reservation);
    ResponseEntity<Object> returnReservation(Long id);
    List<Reservation> findAll();

}
