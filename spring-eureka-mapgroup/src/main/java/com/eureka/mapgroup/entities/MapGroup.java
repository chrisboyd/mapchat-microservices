package com.eureka.mapgroup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mapgroup")
public class MapGroup extends AuditModel{
	@Id 
	@GeneratedValue 
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int mapId;
	
	@NotNull
	private String members;
	
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
	
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public int getMap() {
		return mapId;
	}
	
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	
}
