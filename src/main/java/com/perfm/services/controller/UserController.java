package com.perfm.services.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfm.services.model.User;
import com.perfm.services.repository.UserMongoRepository;
import com.perfm.services.userServices.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private final UserService userService;
	
	private final UserMongoRepository userMongoRepository;

	public UserController(UserService userService, UserMongoRepository userMongoRepository) {
		this.userService = userService;
		this.userMongoRepository = userMongoRepository;
	}
	
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userMongoRepository.save(user);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> findAllUsers(){
		LOG.info("Getting all users.");
		return userMongoRepository.findAll();
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET,produces="application/json")
	public User findUserByUserId(@PathVariable("userId") String userId) {
		if(userId!=null) {
		LOG.info("Finding the user details by userId"+userId);
		User user = userService.getUserById(userId);
		//objectmapper example serialize java object
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File("target/user.json"), user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		}
		return null;
	}
	
	@RequestMapping(value="/user/{userId}/usersettings",method=RequestMethod.GET,produces="application/json")
	public String findUserSettingsByUserId(@PathVariable("userId") String userId) {
		ObjectMapper mapper = new ObjectMapper();
		
		if(userId!=null) {
			LOG.info("Finding the user by userId"+userId+" to get all usersettings");
			//Object obj = userService.getAllUserSettings(userId);
			Map<String, String> userSettings = userService.getAllUserSettings(userId);
			try {
				String val = mapper.writeValueAsString(userSettings);
				return val;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "No usersettings found";
	}
	
	@RequestMapping(value="/user/{userId}/key/{key}/value/{value}",method=RequestMethod.POST,produces={ "application/json"})
	public String addUserSettings(@PathVariable("userId") String userId, @PathVariable("key") String userKey,@PathVariable("value") String userValue) {
		String val = null;
		if(userId!=null) {
			val = userService.addUserSetting(userId, userKey, userValue);
			}
		return val;
		
	}
	
	
	
	
	
	
	
	//for testing purpose
	@RequestMapping(
		    value = "/maparrayprocess", 
		    method = RequestMethod.POST)
		public void process(@RequestBody Map<String, Object>[] payload) 
		    throws Exception {

		for (Map<String, Object> map : payload) {
			System.out.println(map);
			
		}
		    

		}
	
	@RequestMapping(
		    value = "/mapprocess", 
		    method = RequestMethod.POST)
		public void process(@RequestBody Map<String, Object> payload) 
		    throws Exception {

		    System.out.println(payload);

		}
	
	
	
		
}
