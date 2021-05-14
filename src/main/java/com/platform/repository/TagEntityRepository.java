package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.user.social.profile.TagEntity;
import com.platform.model.user.social.profile.TagEntityPk;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, TagEntityPk> {

	public TagEntity findByTagEntityPkTagName(String tagName);
}
