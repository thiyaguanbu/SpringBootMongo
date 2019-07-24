package com.perfm.services.userServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.perfm.services.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
		
	}

	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	@Override
	public Map<String,String> getAllUserSettings(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		Map<String, String> userSetting = new HashMap<>();
		userSetting = user.getUserSettings();
		return userSetting;
	}

	@Override
	public String getUserSetting(String userId, String key) {
		Query query = new Query();
		query.fields().include("userSettings");
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings().get(key) : "User setting is not found";
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if(null!=user) {
			user.getUserSettings().put(key, value);
			mongoTemplate.save(user);
			return "Key added successfully";
		}
		return "User not found";
	}

}
