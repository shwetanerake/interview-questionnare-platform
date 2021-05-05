package com.platform.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.model.main.Question;
import com.platform.model.user.social.profile.UserActionEntity;
import com.platform.service.QuestionService;
import com.platform.service.UserActionEntityService;
import com.platform.service.Utility;

@RestController
@RequestMapping("/api/platform/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserActionEntityService userActionEntityService;

	@PostMapping
	public ResponseEntity<ApiResponseStatus> addQuestion(@Valid @RequestBody Question question) {

		try {

			final UserActionEntity userActionEntity = userActionEntityService.create("question");
			question.setAction(userActionEntity);
			Long questionId = questionService.createOrUpdate(question).getQuestionId();

			Map<String, Object> resutlMap = Utility.buildResultMap("question_id", questionId);
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resutlMap), HttpStatus.OK);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
					"Exception Occured, Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, exception),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	/*
	 * @GetMapping("/tutorials") public ResponseEntity<List<Question>>
	 * getAllTutorials() { try { List<Question> tutorials = new
	 * ArrayList<Question>();
	 * 
	 * questionRepository.findAll().forEach(tutorials::add);
	 * 
	 * if (tutorials.isEmpty()) { return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 * 
	 * return new ResponseEntity<>(tutorials, HttpStatus.OK); } catch (Exception e)
	 * { return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

}
