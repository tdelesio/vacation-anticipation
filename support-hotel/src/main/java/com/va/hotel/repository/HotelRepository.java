package com.va.hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.va.hotel.domain.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, String>{

}
