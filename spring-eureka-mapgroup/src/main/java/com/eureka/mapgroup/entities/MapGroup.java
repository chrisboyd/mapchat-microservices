package com.eureka.mapgroup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@Table(name = "mapgroup")
public class MapGroup extends AuditModel{
	
	private static final Logger logger = LogManager.getLogger();
	
	@Id 
	@GeneratedValue 
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int mapId;
	
	private String members;
	
	public MapGroup() {}
	
	public MapGroup(String name, int mapId, String members) {
		logger.info("New MapGroup: " + name + ",mapId: " + mapId + "members: " + members);
		this.name = name;
		this.mapId = mapId;
		this.members = members;
	}
	
	public int getId() {
		logger.info("MapGroup.getId(): " + id + " " + this.toString());
		return id;
	}
	public void setId(int id) {
		logger.info("MapGroup.setId(): " + id + " " + this.toString());
		this.id = id;
	}
	public String getName() {
		logger.info("MapGroup.getName(): " + name + " " + this.toString());
		return name;
	}
	public void setName(String name) {
		logger.info("MapGroup.setName(): " + name + " " + this.toString());
		this.name = name;
	}
	
	public void setMapId(int mapId) {
		logger.info("MapGroup.setMapId(): " + mapId + " " + this.toString());
		this.mapId = mapId;
	}
	public int getMap() {
		logger.info("MapGroup.getMap(): " + mapId + " " + this.toString());
		return mapId;
	}
	
	public String getMembers() {
		logger.info("MapGroup.getMembers(): " + members + " " + this.toString());
		return members;
	}
	public void setMembers(String members) {
		logger.info("MapGroup.setMembers(): " + members + " " + this.toString());
		this.members = members;
	}
	
}
