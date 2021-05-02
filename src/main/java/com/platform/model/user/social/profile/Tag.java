package com.platform.model.user.social.profile;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag {

	@Id
	@Column(name = "tag_name", unique = true)
	@Size(max = 100)
	private String tagName;

	@Column(nullable = true, name = "description")
	@Size(max = 100)
	private String description;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
	private TagEntity tagEntity;

	// @ManyToMany(mappedBy = "tags")
	// private Set<Question> questions = new HashSet<>();

}
