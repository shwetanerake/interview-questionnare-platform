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

import com.platform.model.main.Question;

@Entity
@Table(name = "answers")
public class Answer {

	@Id
	@Column(name = "answer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_id"), name = "question_id", nullable = false)
	private Question question;

}
