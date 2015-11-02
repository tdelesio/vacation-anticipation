package com.va.reservation.domain;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import com.delesio.domain.AbstractGUIDModel;
import com.delesio.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation extends AbstractGUIDModel {

	private String profileId;
	private double price;
	private String checkInDate;
	private String checkOutDate;
	private String hotelId;
	private String roomTypeId;

	@JsonIgnore
	private DateTime checkinDT;
	
	@JsonIgnore
	private DateTime checkoutDT;

	public Reservation() {
		super();
	}

	public Reservation(String profileId, double price, String checkInDate,
			String checkOutDate, String hotelId, String roomTypeId) {
		super();
		this.profileId = profileId;
		this.price = price;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.hotelId = hotelId;
		this.roomTypeId = roomTypeId;
	}

	public String getProfileId() {
		return profileId;
	}

	public double getPrice() {
		return price;
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

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public DateTime getCheckinDT() {
		if (checkinDT == null)
			checkinDT = TimeUtil.convertToDateTime(checkInDate);

		return checkinDT;
	}

	public DateTime getCheckoutDT() {
		if (checkoutDT == null)
			checkinDT = TimeUtil.convertToDateTime(checkOutDate);
		return checkoutDT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result
				+ ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((profileId == null) ? 0 : profileId.hashCode());
		result = prime * result
				+ ((roomTypeId == null) ? 0 : roomTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (checkOutDate == null) {
			if (other.checkOutDate != null)
				return false;
		} else if (!checkOutDate.equals(other.checkOutDate))
			return false;
		if (hotelId == null) {
			if (other.hotelId != null)
				return false;
		} else if (!hotelId.equals(other.hotelId))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (roomTypeId == null) {
			if (other.roomTypeId != null)
				return false;
		} else if (!roomTypeId.equals(other.roomTypeId))
			return false;
		return true;
	}

	
}
