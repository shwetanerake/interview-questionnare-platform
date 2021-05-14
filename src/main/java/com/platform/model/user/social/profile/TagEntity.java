package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.platform.model.user.User;

import lombok.ToString;

@Entity
@Table(name = "tag_entity")
@ToString
public class TagEntity implements Serializable {

	@EmbeddedId
	private TagEntityPk tagEntityPk = new TagEntityPk();

	/*
	 * @Column(name = "tag_name", unique = true, nullable = false)
	 * 
	 * @Size(max = 100) private String tagName;
	 */
	@Column(nullable = true, name = "description")
	@Size(max = 100)
	private String description;

	// @OneToOne(fetch = FetchType.LAZY)
	// @MapsId("tagId")
	// @JoinColumn(unique = false,name = "tagId", referencedColumnName = "tag_id",
	// insertable = false, updatable = false)
	// private Tag tag;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	@JoinColumn(name = "userId", referencedColumnName = "user_id", insertable = false, updatable = false)
	@ToString.Exclude
	private User user;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("actionId")
	@JoinColumn(name = "actionId", referencedColumnName = "action_id", insertable = false, updatable = false)
	@ToString.Exclude
	private UserActionEntity action;

	public TagEntityPk getTagEntityPk() {
		return tagEntityPk;
	}

	public void setTagEntityPk(TagEntityPk tagEntityPk) {
		this.tagEntityPk = tagEntityPk;
	}

	/*
	 * public Tag getTag() { return tag; }
	 * 
	 * public void setTag(Tag tag) { this.tag = tag; }
	 */

	public UserActionEntity getAction() {
		return action;
	}

	public void setAction(UserActionEntity action) {
		this.action = action;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/*
	 * public String getTagName() { return tagName; }
	 * 
	 * public void setTagName(String tagName) { this.tagName = tagName; }
	 */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
