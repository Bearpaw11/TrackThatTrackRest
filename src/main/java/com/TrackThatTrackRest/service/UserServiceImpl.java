package com.TrackThatTrackRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TrackThatTrackRest.dao.UsersRepository;
import com.TrackThatTrackRest.entity.User;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UsersRepository userRepo;

	@Transactional
	@Override
	public List<User> findAll() {
		
		return userRepo.findAll();
	}
	@Transactional
	@Override
	public User findById(Integer userId) {
		
		return userRepo.findById(userId).get();
	}

	@Transactional
	@Override
	public void save(User theUser) {
		userRepo.save(theUser);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer userId) {
		userRepo.deleteById(userId);
		
	}
	

}
