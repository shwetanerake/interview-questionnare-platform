package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
