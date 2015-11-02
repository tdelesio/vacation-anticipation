package com.va.hotel.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.va.builder.HotelBuilder;
import com.va.hotel.Application;
import com.va.hotel.domain.Hotel;
import com.va.hotel.repository.HotelRepository;

@RunWith(SpringJUnit4ClassRunner.class)	
//@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class WebServiceControllerTest {

//	@Autowired 
//	private WebServiceBroker webServiceBrokerMock;
	
	@Autowired 
	private HotelRepository hotelRepository;
	
	private MockMvc mockMvc;
	
	@Test
	public void viewHotel_ShouldReturnFoundHotel() throws Exception {
		Hotel returnedHotel = new HotelBuilder().build();
		
//		when(webServiceBrokerMock.callGetHotel(returnedHotel.getId())).thenReturn(returnedHotel);
		when(hotelRepository.save(returnedHotel)).thenReturn(returnedHotel);
		
		mockMvc.perform(post("/hotel").contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(returnedHotel))).andExpect(status().isOk());
	}
	
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
//	@Test
//	public void createHotel_ShouldReturnCreatedHotel() throws Exception {
//		Hotel returnedHotel = new HotelBuilder().build();
//		
//		when(webServiceBrokerMock.callCreateHotel(any(Hotel.class))).thenReturn(returnedHotel);
//		
//		mockMvc.perform(MockMvcRequestBuilders.post("/"))
//		.andExpect(status().isOk())
//		.andExpect(model().attributeExists("name"));
//		
//		verify(webServiceBrokerMock, times(1)).callCreateHotel(returnedHotel);
//        verifyNoMoreInteractions(webServiceBrokerMock);
//	}
}
