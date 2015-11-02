package com.va.builder;

import com.va.hotel.domain.RoomType;

public class RoomTypeBuilder {

	private int quant;
	
	public RoomType build()
	{
		return new RoomType(quant);
	}
	
	public RoomTypeBuilder withQuanity(int quanity)
	{
		this.quant = quanity;
		return this;	
	}
}
