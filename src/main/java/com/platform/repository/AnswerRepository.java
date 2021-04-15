package com.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.answer.*;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	//List<Answer> findByQuestionId(Long questionId);	
}