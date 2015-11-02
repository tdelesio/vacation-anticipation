package com.va.reservation.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.ValidationErrors;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.delesio.exception.ValidationException;
import com.va.reservation.AbstractTest;
import com.va.reservation.domain.Reservation;
import com.va.reservation.domain.builder.ReservationBuilder;
import com.va.reservation.exception.ReservationErrors;
import com.va.reservation.service.BookARoomService;

@WebAppConfiguration
public class BookARoomControllerTest extends AbstractTest {

	private MockMvc mockMvc;

//	@Autowired
	@Mock
	private BookARoomService bookARoomService; //= Mockito.mock(BookARoomService.class);

	@InjectMocks
	private BookARoomController bookARoomController;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		// We have to reset our mock between tests because the mock objects
		// are managed by the Spring container. If we would not reset them,
		// stubbing and verified behavior would "leak" from one test to another.
//		Mockito.reset(bookARoomService);
//		mockMvc = webAppContextSetup(webApplicationContext)
//				.build();
		
		//standalone test
		MockitoAnnotations.initMocks(this);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookARoomController).build();

	}

	@Test
	public void bookReservation_SunnyDay() throws Exception {
		String hotelId = "1";
		String roomTypeId = "5";

		Reservation reservationInput = new ReservationBuilder()
				.withHotelId(hotelId).withPrice(100.00)
				.withCheckInDate("11/11/14").withCheckOutDate("11/13/14")
				.withRoomRypeTypeId(roomTypeId).build();

		when(bookARoomService.bookARoom(any(Reservation.class))).thenReturn(
				reservationInput);

		MvcResult result = 
				mockMvc.perform(
				post("/book")
						.contentType(MediaType.APPLICATION_JSON)
						.content(convertObjectToJSONString(reservationInput)))
						.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(
						MockMvcResultMatchers.jsonPath("$.id",
								Matchers.anything()))

				.andReturn();

				
		
		
		verify(bookARoomService).bookARoom(reservationInput);
		verifyNoMoreInteractions(bookARoomService);
	}

	@Test
	public void bookReservation_DataValidationError() throws Exception {
		String hotelId = "1";
		String roomTypeId = "5";

		Reservation reservationInput = new ReservationBuilder()
				.withHotelId(hotelId).withPrice(100.00)
				.withCheckInDate("11/15/14").withCheckOutDate("11/13/14")
				.withRoomRypeTypeId(roomTypeId).build();

		when(bookARoomService.bookARoom(any(Reservation.class))).thenThrow(new ValidationException(ReservationErrors.CHECKIN_IS_AFTER_CHECKOUT));

		
				mockMvc.perform(
				post("/book")
						.contentType(MediaType.APPLICATION_JSON)
						.content(convertObjectToJSONString(reservationInput)))
						.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is4xxClientError())
				;

				
		verify(bookARoomService, times(1)).bookARoom(any(Reservation.class));
		verifyNoMoreInteractions(bookARoomService);
		
	}
}
