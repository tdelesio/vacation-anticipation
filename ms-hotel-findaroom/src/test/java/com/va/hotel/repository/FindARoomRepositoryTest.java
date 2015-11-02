package com.va.hotel.repository;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.va.hotel.FindARoomApplication;

@RunWith(SpringJUnit4ClassRunner.class)	
@SpringApplicationConfiguration(classes = FindARoomApplication.class)
public class FindARoomRepositoryTest {

	@Test
	public void testFindAvailableRooms() {
		fail("Not yet implemented");
	}

}
