package com.va.builder;

import com.va.hotel.domain.Hotel;

public class HotelBuilder {

	private String name;
	
	public Hotel build()
	{
		return new Hotel(name);
	}
	
//	public HotelUI buildUI()
//	{
//		return new HotelUI();
//	}
//	
	public HotelBuilder withName(String name)
	{
		this.name = name;
		return this;	
	}
}
