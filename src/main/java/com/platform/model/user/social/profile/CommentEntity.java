package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.platform.model.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_comments")
@Getter
@Setter
@EqualsAndHashCode
@Data
public class CommentEntity implements Serializable {
	

	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "comment_no")
	private ActionEntity action;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(nullable = false,foreignKey = @ForeignKey(name = "user_comments_user"),name = "user_id")
	private User user;
	
	

}
