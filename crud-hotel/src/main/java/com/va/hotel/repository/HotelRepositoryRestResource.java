package com.va.hotel.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotel", path = "hotel")
public interface HotelRepositoryRestResource extends HotelRepository {

}
