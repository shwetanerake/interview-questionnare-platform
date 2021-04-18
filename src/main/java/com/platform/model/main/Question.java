package com.platform.model.main;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.platform.model.answer.Answer;
import com.platform.model.tag.Tag;

import lombok.Data;

@Data
@Entity
@Table(name = "questions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;

	@NotNull
	@Size(min = 50, max = 500)
	@Column(name = "question_text")
	private String questionText;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Answer> answers;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "question_tags", 
				joinColumns = @JoinColumn(nullable=false, foreignKey = @ForeignKey(name = "fk_question_tag_questions_mapping"),name = "question_id"), 
				inverseJoinColumns = @JoinColumn(nullable=false, foreignKey = @ForeignKey(name = "fk_question_tag_tags_mapping"), name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

}
