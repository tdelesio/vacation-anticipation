package com.va.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.ExposesResourceFor;

import com.va.hotel.domain.RoomType;

@RepositoryRestResource(collectionResourceRel = "roomtype", path = "roomtype")
public interface RoomTypeRepository extends CrudRepository<RoomType, String> {

}
