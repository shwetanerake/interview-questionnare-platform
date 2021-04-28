package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.answer.Answer;
import com.platform.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;
	

	public Long createOrUpdate(Answer answer) {
		//return answerRepository.save(answer).getAnswerId();
		return null;

	}

	/*
	 * List<Answer> findByQuestionId(Long questionId) {
	 * 
	 * return answerRepository.findByQuestionId(questionId);
	 * 
	 * }
	 */

}
