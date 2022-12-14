package com.TrackThatTrackRest.rest;

import com.TrackThatTrackRest.entity.User;


///This is a DTO class used to define the user data we want to expose
public class UserDTO {
	private String userName;
	private String email;
	
	
	public UserDTO(User user) {
		this.userName = user.getUserName();
		this.email = user.getEmail();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
