package com.platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.answer.*;
import com.platform.model.user.social.profile.ActionEntity;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, ActionEntity> {
	
	//List<Answer> findByQuestionId(Long questionId);
	@Override
	default Optional<Answer> findById(ActionEntity id) {
		// TODO Auto-generated method stub
		return null;
	}
}
