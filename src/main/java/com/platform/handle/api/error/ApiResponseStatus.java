package com.platform.handle.api.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;


public class ApiResponseStatus {

	private String message = "success";
	private int exitCode = 0;
	private String debugMessage = "";
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	private HttpStatus status = HttpStatus.OK;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Map<String, Object> getStatusMap() {
		return resultMap;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getExitCode() {
		return exitCode;
	}

	public void setExitCode(int exitCode) {
		this.exitCode = exitCode;
	}

	public void setStatusMap(Map<String, Object> resultMap2) {
		this.resultMap = resultMap2;
	}

	public ApiResponseStatus() {

	}

	public ApiResponseStatus(Map<String, Object> resultMap) {
		super();
		this.resultMap = resultMap;

	}

	public ApiResponseStatus(int exitCode, HttpStatus status) {
		this();
		this.exitCode = exitCode;
		this.status = status;
	}

	public ApiResponseStatus(int exitCode, Throwable ex) {
		this();
		this.exitCode = exitCode;
		this.message = "Exception Occured, Internal Server Error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ApiResponseStatus(int exitCode, HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.exitCode = exitCode;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ApiResponseStatus(int exitCode,String  message, HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.exitCode = exitCode;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ApiResponseStatus(int exitCode, HttpStatus status, String message, Throwable ex) {
		this();
		this.exitCode = exitCode;
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

}
