package com.TrackThatTrackRest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrackThatTrackRest.entity.User;
import com.TrackThatTrackRest.service.UserService;


//RestController is used for making restful web services
@RestController
//RequestMapping is used to map HTTP requests to handler methods of REST controller
@RequestMapping("/api")
public class UsersRestController {

	private UserService userService;
	
	@Autowired
	public UsersRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	// expose "/users" and return list of users
	@GetMapping("/users")
	public List<UserDTO> findAll() {
		//Using a DTO to expose only Username and Email and avoid infinite loop I was getting with User
		List<User> userList = userService.findAll();
		List<UserDTO> userDTOList = new ArrayList<>();
		for(User user : userList) {
			UserDTO userDTO= new UserDTO(user);
			userDTOList.add(userDTO);
	
		}
		return userDTOList;
	}

	// add mapping for GET /users/{userId}
	
	@GetMapping("/users/{userId}")
	public UserDTO getUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		UserDTO userDTO= new UserDTO(theUser);
		return userDTO;
	}
	
	// add mapping for POST /users - add new user
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		
		// in case they pass an id in JSON ... set id to 0
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for PUT /users - update existing user
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for DELETE /users/{userId} - delete user
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		User tempUser = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user id - " + userId;
	}
	
}










