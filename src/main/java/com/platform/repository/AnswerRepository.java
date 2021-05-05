package com.platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.answer.*;
import com.platform.model.user.social.profile.UserActionEntity;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UserActionEntity> {
	
	//List<Answer> findByQuestionId(Long questionId);
	@Override
	default Optional<Answer> findById(UserActionEntity id) {
		// TODO Auto-generated method stub
		return null;
	}
}
