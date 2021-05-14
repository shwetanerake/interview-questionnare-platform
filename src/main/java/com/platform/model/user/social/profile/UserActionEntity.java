package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.platform.model.answer.Answer;
import com.platform.model.main.Question;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_actions")
@EqualsAndHashCode
public class UserActionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046633986402516587L;

	@Id
	@Column(unique = true, name = "action_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long actionId;

	@Column(name = "action_type")
	private String actionType;

	@OneToOne(targetEntity = Question.class, mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
	private Question question;

	@OneToOne(targetEntity = LikedEntity.class, mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
	private LikedEntity likedEntity;

	@OneToOne(targetEntity = Answer.class, mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
	private Answer answer;

	@OneToOne(targetEntity = CommentEntity.class, mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
	private CommentEntity commentEntity;
	
	@OneToOne(targetEntity = TagEntity.class, mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
	private TagEntity tagEntity;

	public TagEntity getTagEntity() {
		return tagEntity;
	}

	public void setTagEntity(TagEntity tagEntity) {
		this.tagEntity = tagEntity;
	}

	public Long getActionId() {
		return actionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public CommentEntity getCommentEntity() {
		return commentEntity;
	}

	public void setCommentEntity(CommentEntity commentEntity) {
		this.commentEntity = commentEntity;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	public LikedEntity getLikedEntity() {
		return likedEntity;
	}

	public void setLikedEntity(LikedEntity likedEntity) {
		this.likedEntity = likedEntity;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


}
