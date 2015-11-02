package com.va.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.va.hotel.domain.RoomTypeUI;
import com.va.hotel.service.RoomTypeService;

@Controller
@RequestMapping("/roomtype")
public class RoomTypeController {

	@Autowired
	private RoomTypeService roomTypeService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	RoomTypeUI createRoomType(RoomTypeUI roomTypeUI) {
		return new RoomTypeUI();
	}
}
