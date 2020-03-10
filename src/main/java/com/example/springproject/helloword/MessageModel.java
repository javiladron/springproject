package com.example.springproject.helloword;

public class MessageModel {
	
	private String param;
	private String message;
	
	public MessageModel(String param) {
		this.param=param;
	}

	public void setMessage(String message){
		this.message  = message;
	}
	public void getMessage(){
		System.out.println("Your Message : " + message);
		System.out.println("Your Param: "+getParam());
	}

	public String getParam() {
		return param;
	}

	
	
	
}
