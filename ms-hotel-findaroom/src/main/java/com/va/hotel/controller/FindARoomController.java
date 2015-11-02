package com.va.hotel.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.va.builder.RoomTypeBuilder;
import com.va.hotel.domain.RoomSearchRequest;
import com.va.hotel.domain.RoomSearchResponse;
import com.va.hotel.domain.builder.RoomSearchResponseBuilder;

@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class FindARoomController {

	@RequestMapping(value="/room",method=RequestMethod.POST)
	@ResponseBody
    public RoomSearchResponse searchForRooms(@RequestBody RoomSearchRequest roomSearchRequest) {
       return new RoomSearchResponseBuilder()
       .withCheckInDate(roomSearchRequest.getCheckindate())
       .withCheckOutDate(roomSearchRequest.getCheckoutdate())
       .withHoteId(roomSearchRequest.getHotelid())
       .withRoomTypeAdded(new RoomTypeBuilder().withQuanity(2).build(), 55.00)
       .withRoomTypeAdded(new RoomTypeBuilder().withQuanity(1).build(), 110.00)
       .build();
    }
}
