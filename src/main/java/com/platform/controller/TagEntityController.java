package com.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.service.TagEntityService;
import com.platform.service.TagService;

@RestController
@RequestMapping("/api/platform/tags")
public class TagEntityController {

	@Autowired
	TagService tagService;

	@Autowired
	TagEntityService tagEntityService;

	@PostMapping
	public ResponseEntity<ApiResponseStatus> addTag() {
		return null;
	}

}
