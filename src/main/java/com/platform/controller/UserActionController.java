package com.platform.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.service.STATIC;
import com.platform.service.UserActionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/platform/user/{userId}/")
public class UserActionController {

	@Autowired
	UserActionService userActionService;
	
	@Autowired
	TagEntityController tagEntityController;

	@PostMapping("action/{actionName}")
	public ResponseEntity<ApiResponseStatus> createAction(@PathVariable Long userId, @PathVariable String actionName,
			@RequestBody ObjectNode objectNode) {
		
		switch (actionName.toLowerCase()) {
		case STATIC.ACTION.ADD_TAG:
			return tagEntityController.addTag(userId, objectNode);
		default:

			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1, "unknown action", BAD_REQUEST),
					BAD_REQUEST);
		}
	}
	
	@PutMapping("action/{actionId}")
	public ResponseEntity<ApiResponseStatus> updateAction(@PathVariable Long userId, @PathVariable Long actionId,
			@RequestBody ObjectNode objectNode) {
				return null;
		
		
	}

}
