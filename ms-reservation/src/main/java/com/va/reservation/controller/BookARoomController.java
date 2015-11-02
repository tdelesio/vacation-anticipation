package com.va.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.delesio.exception.ValidationException;
import com.delesio.ws.AbstractWebService;
import com.delesio.ws.exception.Response;
import com.delesio.ws.exception.SuccessResponse;
import com.va.reservation.domain.Reservation;
import com.va.reservation.service.IBookARoomService;

@RestController
@RequestMapping(value = "/book")
public class BookARoomController extends AbstractWebService {

	static Logger logger = LoggerFactory.getLogger(BookARoomController.class);
	
	@Autowired
	private IBookARoomService bookARoomService;
	

//	@ResponseBody
//	@RequestMapping(method = RequestMethod.GET)
//	public String getImplementation()
//	{
//		return reservationRepository.toString();
//	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Response bookReservation(@RequestBody Reservation reservation) throws ValidationException
	{ 
	
		reservation = bookARoomService.bookARoom(reservation);
		return new SuccessResponse(reservation);
		
	}
	
	
}
