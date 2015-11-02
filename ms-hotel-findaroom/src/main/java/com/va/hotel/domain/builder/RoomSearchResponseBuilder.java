package com.va.hotel.domain.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.va.hotel.domain.RoomSearchResponse;
import com.va.hotel.domain.RoomType;

public class RoomSearchResponseBuilder {

	private Map<RoomType, Double> rooms = new HashMap<RoomType, Double>();
	private String hotelId;
	private String checkInDate;
	private String checkOutDate;
	
	public RoomSearchResponse build()
	{
		Set<RoomType> roomTypes = rooms.keySet();
		Map<String, Double> prices = new HashMap<String, Double>();
		for (RoomType roomType: roomTypes)
		{
			prices.put(roomType.getId(), rooms.get(roomType));
		}
		return new RoomSearchResponse(checkInDate, checkOutDate, hotelId, prices, roomTypes);
	}
	
	public RoomSearchResponseBuilder withRoomTypeAdded(RoomType roomType, Double price)
	{
		rooms.put(roomType, price);
		return this;
	}
	
	public RoomSearchResponseBuilder withHoteId(String hotelId)
	{
		this.hotelId = hotelId;
		return this;
	}
	
	public RoomSearchResponseBuilder withCheckInDate(String date)
	{
		this.checkInDate = date;
		return this;
	}
	
	public RoomSearchResponseBuilder withCheckOutDate(String date)
	{
		this.checkOutDate = date;
		return this;
	}
}

