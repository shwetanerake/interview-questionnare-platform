package com.platform.model.answer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.platform.model.user.User;
import com.platform.model.user.social.profile.ActionEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answer_comments")
@Getter
@Setter
public class AnswerComment {
	
	@Id
	@Column(name = "answer_comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerCommentId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_comments_answers"), name = "answer_id", nullable = true)
	private Answer answer;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_comments_users"), name = "user_id", nullable = true)
	private User user;
		
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_comment_profile"), name = "profile_id", nullable = true)
	private ActionEntity profile;
	

}
