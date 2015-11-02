package com.va.hotel.domain;

import java.util.Map;
import java.util.Set;

public class RoomSearchResponse {

	private String checkInDate;
	private String checkOutDate;
	private String hotelId;
	
	private Map<String, Double> roomRates;
	private Set<RoomType> roomTypes;
	
	private long rateTimeStamp = System.currentTimeMillis();

	
	
	public RoomSearchResponse() {
		super();
	}



	


	public RoomSearchResponse(String checkInDate, String checkOutDate,
			String hotelId, Map<String, Double> roomRates,
			Set<RoomType> roomTypes) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.hotelId = hotelId;
		this.roomRates = roomRates;
		this.roomTypes = roomTypes;
	}






	public String getCheckInDate() {
		return checkInDate;
	}



	public String getCheckOutDate() {
		return checkOutDate;
	}



	public String getHotelId() {
		return hotelId;
	}



	


	public long getRateTimeStamp() {
		return rateTimeStamp;
	}






	public Map<String, Double> getRoomRates() {
		return roomRates;
	}






	public Set<RoomType> getRoomTypes() {
		return roomTypes;
	}


	
	
}
