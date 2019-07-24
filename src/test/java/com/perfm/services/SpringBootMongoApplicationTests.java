package com.perfm.services;

import static org.junit.Assert.assertEquals;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perfm.services.model.User;
import com.perfm.services.userServices.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongoApplicationTests {
	
	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testaddNewUsers() {
		User user = new User();
		
		user.setUserId("3");
		user.setName("H");
		Date date = new Date();
		user.setCreationDate(date);
		Map<String, String> userSetting = new HashMap<>();
		userSetting.put("s1", "s1");
		userSetting.put("s2", "s2");
		userSetting.put("s3", "s3");
		userSetting.put("s4", "s4");
		user.setUserSettings(userSetting);
		User savedUser  = userService.addNewUser(user);
		assertEquals("H", savedUser.getName());
		
		
	}

}

