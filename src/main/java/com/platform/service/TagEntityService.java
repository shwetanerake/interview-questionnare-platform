package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.user.User;
import com.platform.model.user.social.profile.TagEntity;
import com.platform.model.user.social.profile.TagEntityPk;
import com.platform.model.user.social.profile.UserActionEntity;
import com.platform.repository.TagEntityRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TagEntityService {

	@Autowired
	TagEntityRepository tagEntityRepository;

	@Autowired
	UserService userService;

	@Autowired
	private UserActionEntityService userActionEntityService;

	public TagEntity save(TagEntity tagEntity) {
		// TODO Auto-generated method stub
		return tagEntityRepository.save(tagEntity);
	}

	public TagEntity findByTagEntityPkTagName(String tagName) {
		return tagEntityRepository.findByTagEntityPkTagName(tagName);
	}

	public TagEntity saveOrUpdate(String tagName, String description, UserActionEntity userActionEntity, User user) {
		// TODO Auto-generated method stub

		TagEntityPk tagEntityPk = new TagEntityPk(userActionEntity.getActionId(), user.getUserId(), tagName);

		TagEntity tagEntityExists = tagEntityRepository.findByTagEntityPkTagName(tagName);
		if (tagEntityExists == null) {

			TagEntity newTagEntity = new TagEntity();
			newTagEntity.setTagEntityPk(tagEntityPk);
			newTagEntity.setDescription(description);
			newTagEntity.setAction(userActionEntity);
			newTagEntity.setUser(user);
			return save(newTagEntity);

		} else {

			return tagEntityExists;
			/*
			 * if (findByTagEntityPkTagName(tagName) == null) {
			 * existingTagEntity.setDescription(description);
			 * existingTagEntity.getTagEntityPk().setTagName(tagName); return
			 * save(existingTagEntity); } else {
			 * existingTagEntity.setDescription(description); return
			 * save(existingTagEntity); }
			 */

		}

	}

}
