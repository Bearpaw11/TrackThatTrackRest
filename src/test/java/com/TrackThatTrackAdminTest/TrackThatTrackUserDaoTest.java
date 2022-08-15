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
//Use rollback so that the DB is not actually changed whe testing
@Rollback
public class TrackThatTrackUserDaoTest {

	
	@Autowired
	UsersRepository userRepository;
	
	@Test
	//test to make sure the userRepository is connected to the class. Make sure userRepositry is notNull
	void testUserRepositryIsNotNull() {
		Assertions.assertNotNull(userRepository);

	}
	
	@Test
	//test to make sure UserId 15 exists and that all user information matches the data in the DB
	void fidUserById() {
		//set user to a a user with id of 42.
		User user = userRepository.findById(42).get();
		//Check to make sure this user exists
		Assertions.assertNotNull(user);
		//Check that email matches
		Assertions.assertEquals("chrisbehrens1984@gmail.com", user.getEmail());
		//Check to see that UserName matches
		Assertions.assertEquals("DJChrissyD", user.getUserName());
	}
	
	//Test update/Save method
	@Test
		void updateUser() {
			//set user = to user with id of 42
			User user = userRepository.findById(42).get();
			//set userName
			user.setUserName("ChrissyD");
			//save the User
			userRepository.save(user);
			//check to see if updates match what is expected
			Assertions.assertEquals("ChrissyD", user.getUserName());
		}
	
	//Test to delete user. Once deleted then try to findById. AssertFalse is expecting a boolean of false because the the isPresent should return false. 
	@Test
	void DelteUser() {
		User user = userRepository.findById(42).get();
		userRepository.deleteById(user.getId());
		Assertions.assertFalse(userRepository.findById(user.getId()).isPresent());
	}


	
	
}
