package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.repository.TagEntityRepository;

@Service
public class TagEntityService {

	@Autowired
	TagEntityRepository tagEntityRepository;

}
