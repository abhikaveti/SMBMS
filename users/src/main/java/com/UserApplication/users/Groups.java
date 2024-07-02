package com.UserApplication.users;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="groups", schema="usersdb")
public class Groups {
	
	@Id
	@Column(name="group_id")
	private String groupId;
	@Column(name="group_name")
	private String groupName;
	@Column(name="group_owner")
	private String owner;
	@Column(name="group_size")
	private Integer groupSize;
	
	@OneToMany(mappedBy = "group", cascade=CascadeType.ALL)
	private List<UserGroups> userGroups;
	
	public Groups(String groupId, String groupName, String userId, int groupSize) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.owner = userId;
		this.groupSize = groupSize;
	}
	
	public Integer getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}

	public Groups() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<UserGroups> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroups> userGroups) {
		this.userGroups = userGroups;
	}
	

}
