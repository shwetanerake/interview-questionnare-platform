package com.platform.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.model.user.social.profile.Tag;
import com.platform.model.user.social.profile.TagEntity;
import com.platform.model.user.social.profile.UserActionEntity;
import com.platform.service.TagEntityService;
import com.platform.service.TagService;
import com.platform.service.UserActionEntityService;
import com.platform.service.UserService;
import com.platform.service.Utility;

@RestController
@RequestMapping("/api/platform/tags")
public class TagEntityController {

	@Autowired
	TagService tagService;

	@Autowired
	UserService userService;

	@Autowired
	TagEntityService tagEntityService;

	@Autowired
	private UserActionEntityService userActionEntityService;

	@PostMapping
	public ResponseEntity<ApiResponseStatus> addTag(@RequestBody ObjectNode objectNode) {
		String description = null;
		String tagName = null;
		Long userId = null;
		try {
			if (objectNode.hasNonNull("tagName") && objectNode.hasNonNull("userId")) {
				if (!objectNode.get("tagName").asText().isEmpty() && objectNode.get("userId").asLong() != 0) {

					tagName = objectNode.get("tagName").asText();
					userId = objectNode.get("userId").asLong();

					if (objectNode.hasNonNull("description")) {
						description = objectNode.get("description").asText();
					}

					final Tag tag = new Tag();
					tag.setDescription(description);
					tag.setTagName(tagName);
					tagName = tagService.createOrUpdate(null, tag).getTagName();

					if (userService.userIsPresent(userId)) {
						final UserActionEntity userActionEntity = userActionEntityService.create("tag");

						final TagEntity tagEntity = tagEntityService.save(tag, userActionEntity,
								userService.findById(userId).get());

						tag.setTagEntity(tagEntity);
						tagService.createOrUpdate(tagName, tag);

						final Map<String, Object> resultMap = Utility.buildResultMap("tag_name", tagName);

						return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap), HttpStatus.OK);
					} else {
						return new ResponseEntity<ApiResponseStatus>(
								new ApiResponseStatus(-1, "user with id:" + userId + " not found", BAD_REQUEST),
								BAD_REQUEST);
					}

				} else {
					return new ResponseEntity<ApiResponseStatus>(
							new ApiResponseStatus(-1, "required parameter tagName and userId", BAD_REQUEST),
							BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<ApiResponseStatus>(
						new ApiResponseStatus(-1, "required parameter tagName and userId", BAD_REQUEST), BAD_REQUEST);
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
