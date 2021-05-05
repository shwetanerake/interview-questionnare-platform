package com.platform.model.user.social.profile;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.platform.model.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_comments")
@EqualsAndHashCode
@Data
public class CommentEntity implements Serializable {
	

	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "comment_no")
	private UserActionEntity action;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(nullable = false,foreignKey = @ForeignKey(name = "user_comments_user"),name = "user_id")
	private User user;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

}
