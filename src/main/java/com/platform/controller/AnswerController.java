package com.platform.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.model.answer.Answer;
import com.platform.service.AnswerService;
import com.platform.service.QuestionService;
import com.platform.service.Utility;

@RestController
@RequestMapping("/api/platform")
public class AnswerController {

	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;

	@PostMapping("/question/{questionId}/answer")
	public ResponseEntity<ApiResponseStatus> addAnswer(@PathVariable Long questionId, @Valid @RequestBody Answer answer) {
		
		try {
			answer.setQuestion(questionService.findById(questionId));

			final Long answerId = answerService.createOrUpdate(answer);

			final Map<String, Object> resultMap = Utility.buildResultMap("answer_id", answerId);

			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap), HttpStatus.OK);

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1, "Exception Occured, Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,  exception),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
