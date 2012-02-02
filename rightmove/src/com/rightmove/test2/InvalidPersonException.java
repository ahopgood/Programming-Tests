package com.rightmove.test2;

/**
 * This is thrown when validation on the constructor parameters for a {@link Person}
 * object fails.
 * @author Alexander
 *
 */
public class InvalidPersonException extends Exception {

	private static final long serialVersionUID = -1629059131776530345L;

	public InvalidPersonException(String message){
		super(message);
	}
	
	public InvalidPersonException(String message, Throwable cause){
		super(message, cause);
	}
}
