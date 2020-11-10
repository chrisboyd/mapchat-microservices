package com.eureka.mapgroup.entities;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name="messages")
public class Message {
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
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MapGroup getMapGroup() {
		return mapGroup;
	}
	public void setMapGroup(MapGroup mapGroup) {
		this.mapGroup = mapGroup;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
