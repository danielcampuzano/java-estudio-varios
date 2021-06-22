package com.co.storeback.exception;

public class BusinessStoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2570451764048867272L;
	
	public BusinessStoreException(String message) {
        super(message);
    }
	
	public BusinessStoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
