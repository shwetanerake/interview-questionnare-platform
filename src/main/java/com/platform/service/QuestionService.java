package com.platform.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.main.Question;
import com.platform.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public Question findById(Long questionId) {
		return questionRepository.findById(questionId).get();
	}
	
	public Question createOrUpdate(Question question){
		return questionRepository.save(question);
	}

	public Object save(@Valid Question question) {
		// TODO Auto-generated method stub
		return null;
	}

}
