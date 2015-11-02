package com.va.reservation.domain.builder;

import org.joda.time.DateTime;

import com.va.reservation.domain.Reservation;

public class ReservationBuilder {

	private String profileId="1";
	private double price=100.00;
	private String checkInDate=new DateTime().toString("MM/dd/yyyy");
	private String checkOutDate=new DateTime().plusDays(3).toString("MM/dd/yyyy");
	private String hotelId="1";
	private String roomTypeId="1";
	
	public ReservationBuilder withProfileId(String profileId)
	{
		this.profileId = profileId;
		return this;
	}
	
	public ReservationBuilder withPrice(double price)
	{
		this.price = price;
		return this;
	}
	
	public ReservationBuilder withCheckInDate(String date)
	{
		this.checkInDate = date;
		return this;
	}
	
	public ReservationBuilder withCheckOutDate(String date)
	{
		this.checkOutDate = date;
		return this;
	}
	
	public ReservationBuilder withHotelId(String hotelid)
	{
		this.hotelId = hotelid;
		return this;
	}
	
	public ReservationBuilder withRoomRypeTypeId(String roomTypeId)
	{
		this.roomTypeId = roomTypeId;
		return this;
	}
	
	public Reservation build()
	{
		return new Reservation(profileId, price, checkInDate, checkOutDate, hotelId, roomTypeId);
	}
}
