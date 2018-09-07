/**
 * 
 */
package com.mymark.mymarkproduct.service;

/**
 * @author joseph_sicree
 *
 */
public class ProductServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProductServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ProductServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ProductServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
