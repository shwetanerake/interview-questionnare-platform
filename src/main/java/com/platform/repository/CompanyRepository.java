package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.model.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
