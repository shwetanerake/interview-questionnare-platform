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

import com.platform.model.main.Question;
import com.platform.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
	
	@Id
	@Column(name = "company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;
	
	@ManyToMany(mappedBy = "companies")
	private Set<Question> questions = new HashSet<>();
	
	@ManyToMany(mappedBy = "companies")
	private Set<User> users = new HashSet<>();

}
