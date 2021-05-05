package com.platform.model.answer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.platform.model.main.Question;
import com.platform.model.user.social.profile.UserActionEntity;

@Entity
@Table(name = "answers")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 @Id
	 private Long answerId;
	 
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(foreignKey = @ForeignKey(name="fk_answer_id"), name = "answer_id")
	private UserActionEntity action;

	@NotNull
	@Size(min = 50, max = 500)
	@Column(name = "answer_text")
	private String answerText;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_id"), name = "question_id", nullable = false)
	//@JsonIgnore
	private Question question;
	
	/*
	 * @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL, orphanRemoval = true) private Set<AnswerLike> answerLikes;
	 * 
	 * @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL, orphanRemoval = true) private Set<AnswerComment>
	 * answerComments;
	 */
	
	

	/*
	 * public ActionEntity getProfile() { return profile; }
	 * 
	 * public void setProfile(ActionEntity profile) { this.profile = profile; }
	 */

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	/*
	 * public Set<AnswerLike> getAnswerLikes() { return answerLikes; }
	 * 
	 * public Set<AnswerComment> getAnswerComments() { return answerComments; }
	 */

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

}
