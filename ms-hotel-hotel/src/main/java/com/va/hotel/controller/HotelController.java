package com.va.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.va.hotel.domain.HotelUI;
import com.va.hotel.service.HotelService;

@Controller
@RequestMapping("/ms/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody HotelUI createHotel(HotelUI hotelUI) {
			return new HotelUI();
		}
		
	@RequestMapping(method=RequestMethod.PUT)
    public @ResponseBody HotelUI editHotel(HotelUI hotelUI) {
			return new HotelUI();
		}
		
	@RequestMapping(value="/{hotelid}",method=RequestMethod.GET)
    public @ResponseBody HotelUI viewHotel(@PathVariable String hotelid) {
			return new HotelUI();
		}
}
