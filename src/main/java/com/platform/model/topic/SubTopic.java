package com.platform.model.topic;

import java.util.HashMap;
import java.util.Map;
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
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import com.platform.model.main.Question;

import lombok.Data;

@Data
@Entity
@Table(name = "sub_topics")
public class SubTopic {
	
	@Id
	@Column(name = "sub_topic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subTopicId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_topics_subtopics",
				joinColumns = @JoinColumn(nullable = false, name= "sub_topic_id",foreignKey = @ForeignKey(name = "fk_question_topics_subtopics_subtopic_mapping")), 
				inverseJoinColumns = @JoinColumn(nullable = false, name = "question_id",foreignKey = @ForeignKey(name = "fk_question_topics_subtopics_question_mapping")))
	@MapKeyJoinColumn(name = "topic_id")
	private Map <Question, Topic> questionTopicsMap = new HashMap<Question, Topic>();
	
	public Map<Question, Topic> getProjectUserMap() {
	    return questionTopicsMap;
	}
}
