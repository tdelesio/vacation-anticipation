package com.va.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.va.hotel.domain.Hotel;

@RepositoryRestResource(collectionResourceRel = "hotel", path = "hotel")
public interface HotelRepository extends CrudRepository<Hotel, String> {

}
