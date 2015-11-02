package com.va.reservation.exception;

import com.delesio.exception.ValidationError;

public enum ReservationErrors implements ValidationError {

	CHECKIN_IS_AFTER_CHECKOUT, HOTEL_ID_IS_NULL, ROOMTYPE_ID_IS_NULL
	
}
