package com.perfm.services.userServices;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.perfm.services.model.User;

@Service
public interface UserService {
	
	
	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Map<String, String> getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);

}
