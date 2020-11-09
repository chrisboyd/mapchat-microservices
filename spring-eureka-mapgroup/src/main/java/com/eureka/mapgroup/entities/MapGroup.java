package com.eureka.mapgroup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MapGroup {
	private @Id @GeneratedValue int id;
	private String name;
	
	public MapGroup() {}
	
	public MapGroup(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMap() {
		return 1;
	}
	
	public int getMembers(){
		return 1234;
	}
	
}
