package com.platform.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.platform.model.user.social.profile.LikedEntity;

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

	@OneToMany(targetEntity = LikedEntity.class,cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
	private Set<LikedEntity> likedEntities = new HashSet<LikedEntity>();

}
