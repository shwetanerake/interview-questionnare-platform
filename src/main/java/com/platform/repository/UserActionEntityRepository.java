package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.user.social.profile.UserActionEntity;

@Repository
public interface UserActionEntityRepository extends JpaRepository<UserActionEntity, Long>{
	

}
