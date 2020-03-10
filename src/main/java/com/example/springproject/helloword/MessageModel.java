package com.example.springproject.helloword;

public class MessageModel {
	private String message;

	public void setMessage(String message){
		this.message  = message;
	}
	public void getMessage(){
		System.out.println("Your Message : " + message);
	}
}
