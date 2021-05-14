package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.repository.UserActionRepository;

@Service
public class UserActionService {
	
	@Autowired
	UserActionRepository userActionRepository;

}
