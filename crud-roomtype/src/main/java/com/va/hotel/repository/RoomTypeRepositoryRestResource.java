package com.va.hotel.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "roomtype", path = "roomtype")
public interface RoomTypeRepositoryRestResource extends RoomTypeRepository {

}
