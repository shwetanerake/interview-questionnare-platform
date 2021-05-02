package com.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.company.Company;
import com.platform.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public Long save(Company company) {
		return companyRepository.save(company).getCompanyId();
	}

}
