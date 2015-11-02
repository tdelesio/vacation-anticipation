package com.va.reservation.repository;

import java.util.Map;

import com.va.reservation.domain.Reservation;

public interface ReservationByMonthRespository {

	public void updateBookingCalendar(Reservation reservation);
	public Map<String, String> getReservationOnDay(String hotelId, int month, int day);
}
