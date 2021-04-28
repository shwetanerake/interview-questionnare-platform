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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.platform.model.answer.Answer;
import com.platform.model.company.Company;
import com.platform.model.tag.Tag;
import com.platform.model.topic.Topic;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "questions")
@Getter
@Setter
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
	@JoinTable(name = "question_tags", joinColumns = @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_question_tag_questions_mapping"), name = "question_id"), inverseJoinColumns = @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_question_tag_tags_mapping"), name = "tag_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = {
					"question_id", "tag_id"}, name = "question_tags_constraint"))
	private Set<Tag> tags = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_topics_subtopics", joinColumns = @JoinColumn(nullable = false, name = "question_id", foreignKey = @ForeignKey(name = "fk_question_topics_subtopics_question_mapping")), inverseJoinColumns = @JoinColumn(nullable = false, name = "topic_id", foreignKey = @ForeignKey(name = "fk_question_topics_subtopics_topic_mapping")), uniqueConstraints = @UniqueConstraint(columnNames = {
			"question_id", "topic_id", "sub_topic_id" }, name = "question_topics_subtopics_constraint"))
	private Set<Topic> topics = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_company_mapping", joinColumns = @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_question_company_mapping_question"), name = "question_id"), inverseJoinColumns = @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_question_company_mapping_company"), name = "company_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = {
					"question_id", "company_id"}, name = "question_company_mapping_constraint"))
	private Set<Company> companies = new HashSet<>();
	
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<QuestionLike> questionLikes;

	
}
