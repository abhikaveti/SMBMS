package com.UserApplication.users;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserGroupId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3324877986684798409L;

	@Column(name="user_id")
	private String userId;
	
	@Column(name="group_id")
	private String groupId;

	public String getUserId() {
		return userId;
	}
	
	public UserGroupId() {
		
	}

	public UserGroupId(String userId, String groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
