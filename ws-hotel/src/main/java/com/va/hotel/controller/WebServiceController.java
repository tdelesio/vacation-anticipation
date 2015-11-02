package com.va.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping(value="/hotel")
//, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class WebServiceController {


//	@RequestMapping(method = RequestMethod.POST)
//	public @ResponseBody
//	HotelUI createHotel(HotelUI hotelUI) {
//		return new HotelUI();
//	}
//
//	@RequestMapping(method = RequestMethod.PUT)
//	public @ResponseBody
//	HotelUI editHotel(HotelUI hotelUI) {
//		return new HotelUI();
//	}

//	@RequestMapping(value = "/hotelid/{hotelid}", method = RequestMethod.GET)	
	
//	public @ResponseBody HotelUI viewHotel(@PathVariable String hotelid) {
//	System.out.println("hello");
////		Hotel hotel = webServiceBroker.callGetHotel(hotelid);
//		
////		return "done";
//		return new HotelUI();
//	}

//	@RequestMapping(value = "/roomtype", method = RequestMethod.POST)
//	public @ResponseBody
//	RoomTypeUI createRoomType(RoomTypeUI roomTypeUI) {
//		return new RoomTypeUI();
//	}
//
//	@RequestMapping(value = "/roomtype", method = RequestMethod.PUT)
//	public @ResponseBody
//	RoomTypeUI editRoomType(RoomTypeUI roomTypeUI) {
//		return new RoomTypeUI();
//	}
//
//	@RequestMapping(value = "/roomtype/hotelid/{hotelid}", method = RequestMethod.GET)
//	public @ResponseBody
//	List<RoomTypeUI> getRoomTypesByHotel(@PathVariable String hotelid) {
//		return Collections.EMPTY_LIST;
//	}
//
//	@RequestMapping(value = "/roomtype/roomtypeid/{roomtypeid}", method = RequestMethod.GET)
//	public @ResponseBody
//	RoomTypeUI getRoomType(@PathVariable String roomtypeid) {
//		return new RoomTypeUI();
//	}
}
