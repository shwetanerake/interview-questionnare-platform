package com.platform.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.model.user.User;
import com.platform.model.user.social.profile.TagEntity;
import com.platform.model.user.social.profile.UserActionEntity;
import com.platform.service.STATIC;
import com.platform.service.TagEntityService;
import com.platform.service.UserActionEntityService;
import com.platform.service.UserService;
import com.platform.service.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/platform/tags/")
public class TagEntityController {

	@Autowired
	UserService userService;

	@Autowired
	TagEntityService tagEntityService;

	@Autowired
	private UserActionEntityService userActionEntityService;

	@PostMapping("{userId}")
	public ResponseEntity<ApiResponseStatus> addTag(@PathVariable Long userId, @RequestBody ObjectNode objectNode) {

		String description = null;
		String tagName = null;

		try {
			if (objectNode.hasNonNull("tagName")) {
				if (!objectNode.get("tagName").asText().isEmpty()) {

					tagName = objectNode.get("tagName").asText();

					if (objectNode.hasNonNull("description")) {
						description = objectNode.get("description").asText();
					}

					if (userService.userIsPresent(userId)) {

						if (tagEntityService.findByTagEntityPkTagName(tagName) == null) {
							final User user = userService.findById(userId).get();

							final UserActionEntity userActionEntity = userActionEntityService.create(STATIC.ACTION.ADD_TAG);

							final TagEntity tagEntity = tagEntityService.saveOrUpdate(tagName, description,
									userActionEntity, user);

							final Map<String, Object> resultMap = Utility.buildResultMap("tag_name",
									tagEntity.toString());

							return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap),
									HttpStatus.OK);
						} else {
							return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
									"tag with name:" + tagName + " already exists", BAD_REQUEST), BAD_REQUEST);
						}

					} else {
						return new ResponseEntity<ApiResponseStatus>(
								new ApiResponseStatus(-1, "user with id:" + userId + " not found", BAD_REQUEST),
								BAD_REQUEST);
					}

				} else {
					return new ResponseEntity<ApiResponseStatus>(
							new ApiResponseStatus(-1, "required parameter tagName", BAD_REQUEST), BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<ApiResponseStatus>(
						new ApiResponseStatus(-1, "required parameter tagName", BAD_REQUEST), BAD_REQUEST);
			}

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
					"Exception Occured, Internal Server Error", INTERNAL_SERVER_ERROR, exception),
					INTERNAL_SERVER_ERROR);

		}

	}

}
