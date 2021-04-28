package com.platform.model.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "question_likes")
public class QuestionLike {
	
	@Id
	@Column(name = "question_like_id")
	Long questionLikeId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_likes_questions"), name = "question_id", nullable = true)
	private Question question;

}
