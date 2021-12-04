package com.theater.service;

import com.theater.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReservationService {

    Reservation findById(Long id);
    Reservation save(Reservation reservation);
    List<Reservation> findAll();

}
