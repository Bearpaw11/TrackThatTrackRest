package com.TrackThatTrackAdminTest;



import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.TrackThatTrackRest.TrackThatTrackRestApplication;
import com.TrackThatTrackRest.dao.UsersRepository;
import com.TrackThatTrackRest.entity.User;

@SpringBootTest(classes = TrackThatTrackRestApplication.class)
//each test will be a transaction in the DB
@Transactional
//Use rollback to not rollback the data so that the DB is not actually changed
@Rollback
public class TrackThatTrackUserDaoTest {

	
	@Autowired
	UsersRepository userRepository;
	
	@Test
	//test to make sure the userRepository is connected to the class. Make sure userRepositry is notNull
	void testUserRepositryIsNull() {
		Assertions.assertNotNull(userRepository);

	}
	
	@Test
	//test to make sure UserId 15 exists and that all user information is correct
	void fidUserById() {
		User user = userRepository.findById(15).get();
		Assertions.assertNotNull(user);
		Assertions.assertEquals("chrisbehrens@yahoo.com", user.getEmail());
		Assertions.assertEquals("ChrisLovesRecords", user.getUserName());
		Assertions.assertEquals("chris", user.getPassword());
	}
	
	//test update method
	@Test
		void updateUser() {
			User user = userRepository.findById(21).get();
			user.setUserName("ChrissyD");
			userRepository.save(user);
			Assertions.assertEquals("ChrissyD", user.getUserName());
		}
	
	//Test to delete user and then try to findById. AssertFlase is expecting a boolean of false because the the isPresent should return false. 
	@Test
	void DelteUser() {
		User user = userRepository.findById(21).get();
		userRepository.deleteById(user.getId());
		Assertions.assertFalse(userRepository.findById(user.getId()).isPresent());
	}


	
	
}
