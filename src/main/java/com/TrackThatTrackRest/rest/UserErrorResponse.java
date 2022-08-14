package com.TrackThatTrackRest.rest;


//This is a Class used to define the blueprint for a UserErrorResponse
public class UserErrorResponse {

	private int status;
	private String message;
	private long timeStamp;
	
	public UserErrorResponse() {
		
	}

	//Constructor
	public UserErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	//Getters and Setters
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}







