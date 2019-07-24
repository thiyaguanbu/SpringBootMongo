package com.perfm.services.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	@Id
	private ObjectId _id;
	private String userId;
	private String name;
	private Date creationDate = new Date();
	private Map<String, String> userSettings = new HashMap<>();


	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Map<String, String> getUserSettings() {
		return userSettings;
	}
	public void setUserSettings(Map<String, String> userSettings) {
		this.userSettings = userSettings;
	}
	public User(ObjectId _id, String name, Date creationDate, Map<String, String> userSettings) {
		super();
		this._id = _id;
		this.name = name;
		this.creationDate = creationDate;
		this.userSettings = userSettings;
	}
	
	
	public User() {
		super();
	}
	
	
	
	
	
	
	
}
