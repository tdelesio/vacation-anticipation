package com.va.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.delesio.domain.AbstractGUIDModel;

@Entity
public class Hotel extends AbstractGUIDModel {

	
	private String hotelName;
	private String ownerProfileId;
	
	@ManyToOne
	private Address location;
	
	@ManyToOne
	private Address billingAddress;
	
	public Hotel()
	{
		
	}
	
	public Hotel(String id, String hotelName)
	{
		super(id);
		this.hotelName = hotelName;
	}
	
	public Hotel(String hotelName)
	{
		super();
		this.hotelName = hotelName;
	}


	
	
	
}
