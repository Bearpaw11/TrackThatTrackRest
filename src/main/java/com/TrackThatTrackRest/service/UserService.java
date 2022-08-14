package com.TrackThatTrackRest.service;

import java.util.List;

import com.TrackThatTrackRest.entity.User;


public interface UserService {

	List<User> findAll();

	User findById(Integer userId);

	void save(User theUser);

	void deleteById(Integer userId);
	
	
}
