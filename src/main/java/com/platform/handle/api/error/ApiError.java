package com.platform.handle.api.error;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.Serializable;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
@JsonTypeIdResolver(com.platform.LowerCaseClassNameResolver.class)
public class ApiError implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// private HttpStatus status;
	// private String message;
	// private String debugMessage;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	//private LocalDateTime timestamp;

	private List<ApiSubError> subErrors;

	private ApiResponseStatus apiResponseStatus;

	public ApiResponseStatus getApiErrorStatus() {
		return apiResponseStatus;
	}

	public void setApiErrorStatus(ApiResponseStatus apiErrorStatus) {
		
		this.apiResponseStatus = apiErrorStatus;
	}

	private ApiError() {
		//timestamp = LocalDateTime.now();
	}

	public List<ApiSubError> getSubErrors() {
		return subErrors;
	}

	public ApiError(ApiResponseStatus apiResponseStatus) {
		super();
		this.apiResponseStatus = apiResponseStatus;
	}

	public void setSubErrors(List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}

	/*
	 * public ApiError(HttpStatus status) { this(); this.status = status; }
	 */

	/*
	 * public ApiError(HttpStatus status, Throwable ex) { this(); this.status = status;
	 * this.message = "Unexpected error"; this.debugMessage = ex.getLocalizedMessage(); }
	 *
	 * public ApiError(HttpStatus status, String message, Throwable ex) { this();
	 * this.status = status; this.message = message; this.debugMessage =
	 * ex.getLocalizedMessage(); }
	 */

	private void addSubError(ApiSubError subError) {
		if (subErrors == null) {
			subErrors = new ArrayList<>();
		}
		subErrors.add(subError);
	}

	private void addValidationError(String object, String field, Object rejectedValue, String message) {
		addSubError(new com.platform.handle.api.error.ApiValidationError(object, field, rejectedValue, message));
	}

	private void addValidationError(String object, String message) {
		addSubError(new ApiValidationError(object, message));
	}

	private void addValidationError(FieldError fieldError) {
		this.addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(),
				fieldError.getDefaultMessage());
	}

	public void addValidationErrors(List<FieldError> fieldErrors) {
		fieldErrors.forEach(this::addValidationError);
	}

	private void addValidationError(ObjectError objectError) {
		this.addValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
	}

	public void addValidationError(List<ObjectError> globalErrors) {
		globalErrors.forEach(this::addValidationError);
	}

	/**
	 * Utility method for adding error of ConstraintViolation. Usually when a @Validated
	 * validation fails.
	 * @param cv the ConstraintViolation
	 */
	private void addValidationError(ConstraintViolation<?> cv) {
		this.addValidationError(cv.getRootBeanClass().getSimpleName(),
				((PathImpl) cv.getPropertyPath()).getLeafNode().asString(), cv.getInvalidValue(), cv.getMessage());
	}

	public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
		constraintViolations.forEach(this::addValidationError);
	}

	/*
	 * public HttpStatus getStatus() { return status; }
	 *
	 * public void setStatus(HttpStatus status) { this.status = status; }
	 */

	/*
	 * public LocalDateTime getTimestamp() { return timestamp; }
	 * 
	 * public void setTimestamp(LocalDateTime timestamp) { this.timestamp =
	 * timestamp; }
	 */
	/*
	 * public String getMessage() { return message; }
	 *
	 * public void setMessage(String message) { this.message = message; }
	 */

	/*
	 * public String getDebugMessage() { return debugMessage; }
	 *
	 * public void setDebugMessage(String debugMessage) { this.debugMessage =
	 * debugMessage; }
	 */

}
