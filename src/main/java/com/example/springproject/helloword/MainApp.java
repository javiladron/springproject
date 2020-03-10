package com.example.springproject.helloword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      MessageModel obj = (MessageModel) context.getBean("messageModel");
	      obj.getMessage();
	}
}
