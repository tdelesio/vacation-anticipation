package com.va.reservation.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delesio.exception.ValidationException;
import com.va.reservation.domain.Reservation;
import com.va.reservation.exception.ReservationErrors;
import com.va.reservation.repository.ReservationByMonthRespository;
import com.va.reservation.repository.ReservationRepository;

@Service
public class BookARoomService implements IBookARoomService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationByMonthRespository reservationByMonthRespository;

	@Transactional
	public Reservation bookARoom(Reservation reservation) throws ValidationException
	{
		//validate the reservation
		validateReservation(reservation);
		
		//store the reservation record
		reservation = reservationRepository.save(reservation);
		
		//update the calendar map
		reservationByMonthRespository.updateBookingCalendar(reservation);
		
		//send confirmation email
		
		return reservation;
	}
	
	protected void validateReservation(Reservation reservation) throws ValidationException
	{
		if (reservation.getCheckinDT().isAfter(reservation.getCheckoutDT()))
			throw new ValidationException(ReservationErrors.CHECKIN_IS_AFTER_CHECKOUT);
		
		if (reservation.getHotelId() == null)
			throw new ValidationException(ReservationErrors.HOTEL_ID_IS_NULL);
		
		if (reservation.getRoomTypeId() == null)
			throw new ValidationException(ReservationErrors.ROOMTYPE_ID_IS_NULL);
	}

}
