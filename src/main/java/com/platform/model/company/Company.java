package com.platform.model.company;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.platform.model.main.Question;
import com.platform.model.user.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Database Table Name: companies, Entity Name: Company, Represents a company for which
 * question was asked, Eg: Amazon/Microsoft
 *
 * @author shweta
 *
 */
@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {

	//
	@Id
	@Column(name = "company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	@Column(name = "name", unique = true, nullable = false)
	@Size(max = 100)
	private String name;

	@Column(nullable = true, name = "description")
	@Size(max = 100)
	private String description;

	@ManyToMany(mappedBy = "companies")
	private Set<Question> questions = new HashSet<>();

	@ManyToMany(mappedBy = "companies")
	private Set<User> users = new HashSet<>();

}
