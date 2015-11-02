package com.va.reservation.repository;

import org.springframework.data.repository.CrudRepository;

import com.va.reservation.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, String>{

}
