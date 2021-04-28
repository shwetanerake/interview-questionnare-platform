package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class LikedEntityPk implements Serializable {

	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "action_id")
	private long actionId;

}
