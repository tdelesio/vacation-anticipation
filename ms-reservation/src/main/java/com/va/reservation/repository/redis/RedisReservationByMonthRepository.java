package com.va.reservation.repository.redis;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.delesio.util.TimeUtil;
import com.va.reservation.domain.Reservation;
import com.va.reservation.repository.ReservationByMonthRespository;

public class RedisReservationByMonthRepository implements ReservationByMonthRespository {

	private String key;
	
//	private final StringRedisTemplate template;
//	private final ListOperations<String, String> listOps;
	private final HashOperations<String, String, String> hashOps;
	
	public RedisReservationByMonthRepository(StringRedisTemplate template)
	{
		this.hashOps = template.opsForHash();
		
	}
	
	public void updateBookingCalendar(Reservation reservation)
	{
		DateTime checkIn = TimeUtil.convertToDateTime(reservation.getCheckInDate());
		DateTime checkOut = TimeUtil.convertToDateTime(reservation.getCheckOutDate());

		
		for (DateTime dateTime= new DateTime(checkIn);dateTime.isBefore(checkOut);dateTime=dateTime.plusDays(1))
		{ 
			hashOps.put(KeyUtils.reservationByHotelByMonth(reservation.getHotelId(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth()), reservation.getId(), reservation.getRoomTypeId());			
		}
	}
	
	public Map<String, String> getReservationOnDay(String hotelId, int month, int day)
	{
		return hashOps.entries(KeyUtils.reservationByHotelByMonth(hotelId, month, day));
	}
}
