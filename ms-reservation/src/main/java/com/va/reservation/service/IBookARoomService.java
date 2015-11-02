package com.va.reservation.service;

import com.delesio.exception.ValidationException;
import com.va.reservation.domain.Reservation;

public interface IBookARoomService {

	public Reservation bookARoom(Reservation reservation) throws ValidationException;
}
