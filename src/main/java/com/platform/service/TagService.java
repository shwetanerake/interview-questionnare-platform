package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepository;

}
