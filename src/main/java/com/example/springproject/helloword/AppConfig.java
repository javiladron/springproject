package com.example.springproject.helloword;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="messageModel")
    public MessageModel messageModel() {
        MessageModel message=new MessageModel("param from javaConfig");
        message.setMessage("setting message property from javaConfig");
        return message;
    }

}
