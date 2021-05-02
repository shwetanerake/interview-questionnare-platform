package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.model.user.social.profile.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {

}
