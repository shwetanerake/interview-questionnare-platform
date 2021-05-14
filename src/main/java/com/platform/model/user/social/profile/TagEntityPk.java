package com.platform.model.user.social.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class TagEntityPk implements Serializable{
	
	
	//@Column(name = "tag_id") 
	//private Long tagId;
	 
	//@Column(name = "tag_name",unique = false) 
	//private String tagName;
	
	@Column(name = "action_id")
	private long actionId;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "tag_name", unique = true, nullable = false)
	@Size(max = 100)
	private String tagName;


}
