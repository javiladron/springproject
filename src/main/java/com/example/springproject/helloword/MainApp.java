package com.example.springproject.helloword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase princial de una aplicacion helloworld de spring
 * @author jladron
 *
 */
public class MainApp {

	public static void main(String[] args) {
		  //cargamos contexto de spring
		  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		  //solicitamos la inyeccion de dependecias para el bean MessageModel
	      MessageModel obj = (MessageModel) context.getBean("messageModel");
	      obj.getMessage();
	      //no usamos spring
	      MessageModel obj2=new MessageModel("instancia propia");
	      obj2.setMessage("No es un framework intrusivo");
	      obj2.getMessage();
	      
	}
}
