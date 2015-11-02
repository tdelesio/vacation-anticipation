package com.va.reservation.repository.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class KeyUtils {

	static Logger logger = LoggerFactory.getLogger(KeyUtils.class);
	
	static final String HOTELID = "hotelid:";
	static final String MONTH = "month:";
	static final String DAY = "day:";
	static final String ROOMTYPEID = "roomTypeId:";
	
	static final String FIELD_SPACE = ",";
	static String reservationByHotelByMonth(String hotelId, int month, int day)
	{
		String key = HOTELID+hotelId+FIELD_SPACE+MONTH+String.valueOf(month)+FIELD_SPACE+DAY+String.valueOf(day);
		logger.info(key);
		return key;
	}
	

}
