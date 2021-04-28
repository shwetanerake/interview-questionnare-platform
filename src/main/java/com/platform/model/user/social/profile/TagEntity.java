package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.platform.model.user.User;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tag_entity")
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Data
public class TagEntity implements Serializable {

	@EmbeddedId
	private TagEntityPk tagEntityPk = new TagEntityPk();
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("tagName")
	@JoinColumn(name = "tagName", referencedColumnName = "tag_name", insertable = false, updatable = false)
	private Tag tag;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("actionId")
	@JoinColumn(name = "actionId", referencedColumnName = "action_id", insertable = false, updatable = false)
	private ActionEntity action;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(nullable = false,foreignKey = @ForeignKey(name = "tag_entity_user"),name = "user_id")
	private User user;
	
}
