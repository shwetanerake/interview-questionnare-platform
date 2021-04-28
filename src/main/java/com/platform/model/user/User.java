package com.platform.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.platform.model.company.Company;
import com.platform.model.user.social.profile.CommentEntity;
import com.platform.model.user.social.profile.LikedEntity;
import com.platform.model.user.social.profile.TagEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Data
public class User implements Serializable {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_company_mapping", joinColumns = @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_user_company_mapping"), name = "user_id"), inverseJoinColumns = @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_user_company_mapping_company"), name = "company_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = {
					"user_id", "company_id"}, name = "user_company_mapping_constraint"))
	private Set<Company> companies = new HashSet<>();

	@OneToMany(targetEntity = LikedEntity.class, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private Set<LikedEntity> userLikes = new HashSet<LikedEntity>();

	@OneToMany(targetEntity = CommentEntity.class, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private Set<CommentEntity> userComments = new HashSet<CommentEntity>();
	
	@OneToMany(targetEntity = TagEntity.class, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private Set<TagEntity> userTags = new HashSet<TagEntity>();

}
