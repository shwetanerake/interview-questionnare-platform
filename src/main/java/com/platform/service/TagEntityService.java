package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.user.User;
import com.platform.model.user.social.profile.Tag;
import com.platform.model.user.social.profile.TagEntity;
import com.platform.model.user.social.profile.TagEntityPk;
import com.platform.model.user.social.profile.UserActionEntity;
import com.platform.repository.TagEntityRepository;

@Service
public class TagEntityService {

	@Autowired
	TagEntityRepository tagEntityRepository;
	
	public TagEntity save(TagEntity tagEntity) {
		// TODO Auto-generated method stub
		return tagEntityRepository.save(tagEntity);
	}

	public TagEntity save(Tag tag, UserActionEntity userActionEntity, User user) {
		// TODO Auto-generated method stub
	
		TagEntityPk tagEntityPk = new TagEntityPk(tag.getTagName(), userActionEntity.getActionId());

		TagEntity tagEntity = new TagEntity();
		tagEntity.setTag(tag);
		tagEntity.setTagEntityPk(tagEntityPk);
		tagEntity.setAction(userActionEntity);
		tagEntity.setUser(user);
		return save(tagEntity);
		
	}

}
