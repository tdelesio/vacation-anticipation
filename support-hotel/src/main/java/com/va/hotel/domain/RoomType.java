package com.va.hotel.domain;

import javax.persistence.Entity;

import com.delesio.domain.AbstractGUIDModel;

@Entity
public class RoomType extends AbstractGUIDModel {

	private String shortDescription;
	private String longDescription;
	private int quanity;
	
	public RoomType()
	{
		
	}
	
	public RoomType(int quanity) {
		super();
		this.quanity = quanity;
	}


	public RoomType(String shortDescription, String longDescription, int quanity) {
		super();
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.quanity = quanity;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public String getLongDescription() {
		return longDescription;
	}


	public int getQuanity() {
		return quanity;
	}
	
	
}
