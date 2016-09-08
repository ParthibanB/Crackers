package com.universalcrackers.service.model;

import com.universalcrackers.service.common.CrackersCommon;

public class CrackerServiceResponse {

	private int code;
	private String message;
	private Object responseObject;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
	public CrackerServiceResponse(){
		this.code = CrackersCommon.FAILURE_CODE;
		this.message = CrackersCommon.INTERNAL_ERROR_MESSAGE;
	}
}
