package com.HMSApp.Hospital.Management.System.Exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends RuntimeException {

	private static final long serialVersionUID = 1106671598754207461L;

	HttpStatus status;

	public InternalServerException(String message) {
		super(message);
	}

	public InternalServerException(String message, HttpStatus status) {
		super(message);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
