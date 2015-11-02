package com.va.hotel.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class FindARoomRepository {

	@Autowired 
	private HotelRepository hotelRepository;
	
	@Autowired 
	private RoomTypeRepository roomTypeRepository;
	
	public void findAvailableRooms(String checkInDate, String checkOutDate, String hotelId)
	{
		//get a list of the room types by hotel
//		rooms = Map<HotelId, Map<RoomTypeId, Quantity>>
		
		//get reservations by moneht
//		reservations  = Map<Month, <Day, Map<ReservationId, RoomTypeId>>>>
		
//		get all reservations 
	}
	
}
