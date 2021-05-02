package com.platform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.model.company.Company;
import com.platform.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public Company createOrUpdate(Long companyId, Company companyEntity) {

		if (companyId != null) {
			Optional<Company> company = findById(companyId);
			if (company.isPresent()) {
				Company newCompanyEntity = company.get();
				newCompanyEntity.setDescription(companyEntity.getDescription());
				newCompanyEntity.setName(companyEntity.getName());
				return save(newCompanyEntity);

			} else {
				return save(companyEntity);
			}
		} else {
			return save(companyEntity);
		}
	}

	public Optional<Company> findById(Long companyId) {
		return companyRepository.findById(companyId);
	}

	public Optional<Company> findByName(String companyName) {
		return companyRepository.findByName(companyName);
	}

}
