package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "action_entity")
public class ActionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046633986402516587L;

	@Id
	@Column(name = "action_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long actionId;

	@OneToOne(targetEntity = LikedEntity.class,mappedBy =  "action",cascade  = CascadeType.ALL, orphanRemoval = true)
	private LikedEntity likedEntity;

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	public LikedEntity getLikedEntity() {
		return likedEntity;
	}

	public void setLikedEntity(LikedEntity likedEntity) {
		this.likedEntity = likedEntity;
	}

}
