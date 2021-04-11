package com.platform.model.answer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer_likes")
public class AnswerLike {
	@Id
	@Column(name = "answer_like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerLikeId;
}
