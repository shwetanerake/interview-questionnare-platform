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

@Entity
@Table(name = "answer_likes")
public class AnswerLike {
	@Id
	@Column(name = "answer_like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerLikeId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_likes_answer_id"), name = "answer_id", nullable = false)
	private Answer answer;
}
