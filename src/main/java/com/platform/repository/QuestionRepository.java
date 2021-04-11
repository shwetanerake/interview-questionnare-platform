package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	
	
}
