package com.platform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.model.main.Question;
import com.platform.repository.QuestionRepository;

@RestController
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Question>> getAllTutorials() {
		try {
			List<Question> tutorials = new ArrayList<Question>();

			
				questionRepository.findAll().forEach(tutorials::add);
			

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
