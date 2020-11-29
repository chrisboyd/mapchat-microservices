package com.eureka.mapgroup.entities;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@Table (name="messages")
public class Message {
	private static final Logger logger = LogManager.getLogger();
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private int userId;
	
	@NotNull
	@Lob
	private String text;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("mapGroup_id")
    private MapGroup mapGroup;
	
	public int getId() {
		logger.info("Messages.getId(): " + id + " " + this.toString());
		return id;
	}
	public void setId(int id) {
		logger.info("Messages.setId(): " + id + " " + this.toString());
		this.id = id;
	}
	public String getText() {
		logger.info("Messages.getText(): " + this.toString());
		return text;
	}
	public void setText(String text) {
		logger.info("Messages.setText(): " + this.toString());
		this.text = text;
	}
	public MapGroup getMapGroup() {
		logger.info("Messages.getMapGroup(): " + mapGroup.toString() + " " + this.toString());
		return mapGroup;
	}
	public void setMapGroup(MapGroup mapGroup) {
		logger.info("Messages.setMapGroup(): " + mapGroup.toString() + " " + this.toString());
		this.mapGroup = mapGroup;
	}
	public int getUserId() {
		logger.info("Messages.getUserId(): " + userId + " " + this.toString());
		return userId;
	}
	public void setUserId(int userId) {
		logger.info("Messages.setUserId(): " + userId + " " + this.toString());
		this.userId = userId;
	}
}
