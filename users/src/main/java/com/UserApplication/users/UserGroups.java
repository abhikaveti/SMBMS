package com.UserApplication.users;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="user_groups", schema="usersdb")
public class UserGroups {
	
	@EmbeddedId
	private UserGroupId userGroupId;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@MapsId("groupId")
	@JoinColumn(name="group_id")
	private Groups group;

	public UserGroups() {
		
	}
	
	public UserGroups(UserGroupId userGroupId) {
		super();
		this.userGroupId = userGroupId;
	}

	public UserGroupId getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(UserGroupId userGroupId) {
		this.userGroupId = userGroupId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

}
