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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.platform.model.main.Question;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "tags", uniqueConstraints = { @UniqueConstraint(name = "tag_name_constraint", columnNames = { "name" }) })
@Getter
@Setter
public class Tag {

	@Id
	@Column(name = "tag_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;

	@NotNull
	@NotEmpty
	@Column(name = "name", nullable = false, unique = true)
	@Size(max = 100)
	private String name;
	

	@Column(nullable = true, name = "description")
	private String description;

	@ManyToMany(mappedBy = "tags")
	private Set<Question> questions = new HashSet<>();

}
