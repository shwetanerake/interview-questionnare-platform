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
	public ResponseEntity<Map<String,Object>> createOrUpdateStudent(@PathVariable Long questionId,
			@Valid @RequestBody Answer answer) {

		try {
		    answer.setQuestion(questionService.findById(questionId));
			Map<String, Object> responseMap = Utility.buildResponseMap("success", 0, "answer_id",
					answerService.createOrUpdate(answer));
			return new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, Object> responseMap = Utility.buildErrorResponseMap(e.getMessage().toString(), -1);
			return new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
