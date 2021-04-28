package com.platform.model.topic;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.platform.model.main.Question;

import lombok.Data;

@Data
@Entity
@Table(name = "topics")
public class Topic {
	
	@Id
	@Column(name = "topic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long topicId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_topics_subtopics",
				joinColumns = @JoinColumn(nullable = false, name= "topic_id",foreignKey = @ForeignKey(name = "fk_question_topics_subtopics_topic_mapping")), 
				inverseJoinColumns = @JoinColumn(nullable = false, name = "question_id",foreignKey = @ForeignKey(name = "fk_question_topics_subtopics_question_mapping")))
	private Set<Question> questions = new HashSet<>();


}
