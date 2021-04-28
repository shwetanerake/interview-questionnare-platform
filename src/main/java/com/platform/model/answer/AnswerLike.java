package com.platform.model.answer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.platform.model.user.User;

@Entity
@Table(name = "answer_likes")
public class AnswerLike {
	@Id
	@Column(name = "answer_like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerLikeId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_likes_answers"), name = "answer_id", nullable = true)
	private Answer answer;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_likes_users"), name = "user_id", nullable = true)
	private User user;
	
}
