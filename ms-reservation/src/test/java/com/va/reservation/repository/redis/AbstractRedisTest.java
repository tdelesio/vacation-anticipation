package com.va.reservation.repository.redis;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.va.reservation.AbstractTest;
import com.va.reservation.ReservationApplication;


public class AbstractRedisTest extends AbstractTest {

	static Logger logger = LoggerFactory.getLogger(AbstractRedisTest.class);
	
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	@Before
	public void clearRedis()
	{
		logger.debug("Clearing DB");
		redisConnectionFactory.getConnection().flushAll();
	}
}
