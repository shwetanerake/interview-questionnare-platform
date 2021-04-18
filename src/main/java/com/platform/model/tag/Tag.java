package com.platform.model.tag;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.platform.model.main.Question;

import lombok.Data;

@Data
@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@Column(name = "tag_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;

	@NotNull
	@Column(name = "name",nullable = false, unique = true)
	@Size(max = 100)
	@NaturalId
	private String name;

	@ManyToMany(mappedBy = "tags")
	private Set<Question> questions = new HashSet<>();

}
