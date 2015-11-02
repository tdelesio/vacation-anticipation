package com.va.reservation.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.va.reservation.domain.Reservation;
import com.va.reservation.repository.ReservationRepository;

@Repository
public interface JpaReservationRepository extends JpaRepository<Reservation, String>, ReservationRepository{

}
