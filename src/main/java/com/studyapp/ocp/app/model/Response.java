package com.studyapp.ocp.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

	private Status status;
	private T data;
	private String errorMessage;
	
	public Status getStatus() {
		return status;
	}
	
	public Response<T> setStatus(Status status) {
		this.status = status;
		return this;
	}
	
	public T getData() {
		return data;
	}
	
	public Response setData(T data) {
		this.data = data;
		return this;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Response setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	
	
}
