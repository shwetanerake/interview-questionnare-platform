package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.user.social.profile.UserActionEntity;
import com.platform.repository.UserActionEntityRepository;

@Service
public class UserActionEntityService {

	@Autowired
	UserActionEntityRepository userActionRepository;

	public Long save(UserActionEntity actionEntity) {
		return userActionRepository.save(actionEntity).getActionId();
	}

	public UserActionEntity create(String actionType) {
		UserActionEntity actionEntity = new UserActionEntity();
		actionEntity.setActionType(actionType);
		save(actionEntity);
		return actionEntity;

	}
}
