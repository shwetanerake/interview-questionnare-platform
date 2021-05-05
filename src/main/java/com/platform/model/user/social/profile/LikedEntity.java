package com.platform.model.user.social.profile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.platform.model.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "liked_entity")
@Getter
@Setter
@EqualsAndHashCode
@Data
public class LikedEntity {
	
	@EmbeddedId
	private LikedEntityPk likedEntityPk = new LikedEntityPk();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	@JoinColumn(name = "userId", referencedColumnName = "user_id", insertable = false, updatable = false)
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("actionId")
	@JoinColumn(name = "actionId", referencedColumnName = "action_id", insertable = false, updatable = false)
	private UserActionEntity action;

	
}
