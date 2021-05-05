package com.platform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.user.social.profile.Tag;
import com.platform.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepository;
	

	public Tag createOrUpdate(String tagName, Tag requestBodyTag) {

		if (tagName != null && !tagName.isEmpty()) {
			Optional<Tag> tag = findByTagName(tagName);
			if (tag.isPresent()) {
				Tag newTag = tag.get();
				newTag.setDescription(requestBodyTag.getDescription());
				newTag.setTagName(requestBodyTag.getTagName());
				return save(newTag);

			} else {
				return save(requestBodyTag);
			}
		} else {
			return save(requestBodyTag);
		}
	}


	private Tag save(Tag tag) {
		// TODO Auto-generated method stub
		return tagRepository.save(tag);
	}


	private Optional<Tag> findByTagName(String tagName) {
		// TODO Auto-generated method stub
		return tagRepository.findById(tagName);
	}
}