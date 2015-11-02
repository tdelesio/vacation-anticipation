package com.va.reservation.repository.redis;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.va.reservation.domain.Reservation;
import com.va.reservation.domain.builder.ReservationBuilder;
import com.va.reservation.repository.ReservationByMonthRespository;


public class RedisReservationByMonthRepositoryTest extends AbstractRedisTest {

	@Autowired
	private ReservationByMonthRespository reservationByMonthRespository;
	
//	static {
//        System.setProperty("REDIS_HOME", "c:\\software\\redis-2.8.17");
//    }
	
//	@ClassRule
//    public static ManagedRedis managedRedis = newManagedRedisRule().build();
//
//    @Rule
//    public RedisRule redisRule = newRedisRule().defaultManagedRedis();
    
//	 @UsingDataSet(locations="book.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
	@Test
	public void updateBookingCalendar_SunnyDayBasicTest() {
		String hotelId = "1";
		String roomTypeId = "5";
		
		Reservation reservationInput = new ReservationBuilder()
		.withHotelId(hotelId)
		.withPrice(100.00)
		.withCheckInDate("11/11/14")
		.withCheckOutDate("11/13/14")
		.withRoomRypeTypeId(roomTypeId)
		.build();
		
		reservationByMonthRespository.updateBookingCalendar(reservationInput);
	
		
		Map<String, String> reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 11);
		Assert.assertEquals(1, reservations.size());
		Assert.assertEquals(roomTypeId, reservations.get(reservationInput.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 12);
		Assert.assertEquals(1, reservations.size());
		Assert.assertEquals(roomTypeId, reservations.get(reservationInput.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 13);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay("2", 11, 13);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 10);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 12, 13);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput.getId()));
	}
	
	@Test
	public void updateBookingCalendar_MultipleReservationsSameRoomType() {
		String hotelId = "1";
		String roomTypeId = "5";
		
		Reservation reservationInput1 = new ReservationBuilder()
		.withHotelId(hotelId)
		.withPrice(100.00)
		.withCheckInDate("11/11/14")
		.withCheckOutDate("11/13/14")
		.withRoomRypeTypeId(roomTypeId)
		.build();
		
		reservationByMonthRespository.updateBookingCalendar(reservationInput1);
		
		//overlaps by one day
		Reservation reservationInput2 = new ReservationBuilder()
		.withHotelId(hotelId)
		.withPrice(100.00)
		.withCheckInDate("11/12/14")
		.withCheckOutDate("11/13/14")
		.withRoomRypeTypeId(roomTypeId)
		.build();
		
		reservationByMonthRespository.updateBookingCalendar(reservationInput2);
		
		//doesn't overlap at all
		Reservation reservationInput3 = new ReservationBuilder()
		.withHotelId(hotelId)
		.withPrice(100.00)
		.withCheckInDate("11/13/14")
		.withCheckOutDate("11/16/14")
		.withRoomRypeTypeId(roomTypeId)
		.build();
		
		reservationByMonthRespository.updateBookingCalendar(reservationInput3);
	
		
		Map<String, String> reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 11);
		Assert.assertEquals(1, reservations.size());
		Assert.assertEquals(roomTypeId, reservations.get(reservationInput1.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 12);
		Assert.assertEquals(2, reservations.size());
		Assert.assertEquals(roomTypeId, reservations.get(reservationInput1.getId()));
		Assert.assertEquals(roomTypeId, reservations.get(reservationInput2.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 13);
		Assert.assertEquals(1, reservations.size());
		Assert.assertEquals(roomTypeId, reservations.get(reservationInput3.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay("2", 11, 13);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput1.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 11, 10);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput1.getId()));
		
		reservations = reservationByMonthRespository.getReservationOnDay(hotelId, 12, 13);
		Assert.assertEquals(0, reservations.size());
		Assert.assertNull(reservations.get(reservationInput1.getId()));
	}

}
