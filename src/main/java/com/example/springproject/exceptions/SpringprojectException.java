package com.example.springproject.exceptions;

/**
 * Excepcion propia de la aplicacion
 * @author jladron
 *
 */
public class SpringprojectException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SpringprojectException(String message) {
		super(message);
	}

}
