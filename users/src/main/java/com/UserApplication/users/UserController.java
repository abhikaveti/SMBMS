package com.UserApplication.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserDAO service;
	@Autowired
	private GroupDAO grpService;

	public UserController(UserDAO userDao) {
		this.service = userDao;
	}

	@RequestMapping("/users")
	public List<User> getUsers() {
//		String methodName = "";
		List<User> users = null;
		
		try {
			users = this.service.findAll();
			
			for(User user : users) {
				for(UserGroups usrGrp : user.getGroups()) {
					usrGrp.setUser(null);
					usrGrp.getGroup().setUserGroups(null);
				}
			}
			return users;
		}catch(Exception e) {
			throw e;
		}
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		Optional<User> user;
		try {
			user = service.findById(id);
			for(UserGroups usrGrp : user.get().getGroups()) {
				usrGrp.setUser(null);
				usrGrp.getGroup().setUserGroups(null);
			}
		}catch(Exception e) {
			throw e;
		}

		return user.get();
	}

	@PostMapping("/saveuser")
	public boolean saveUser(@RequestBody User user) {
		try {
			return service.save(user)!= null;
		}catch(Exception e) {
			throw e;
		}
	}

	
	@RequestMapping("/validateUser") 
	public ValidateCredsResponse validateUser(@RequestBody ValidateCredsRequest request) {
		ValidateCredsResponse res = new ValidateCredsResponse();
		try {
			Optional<User> user = service.findById(request.getUsername());
			res.setValid(
					null != user.get() ? "Valid" : "Not Valid");
		}catch(Exception e) {
			throw e;
		}
		return res; 
	}
	
	@RequestMapping("/createGroup")
	public User createGroup(@RequestBody CreateGroupRequest userReq){
		User owner;
		Optional<Groups> newGroupo;
		try {
			owner = service.findById(userReq.getUserId()).get();
			newGroupo = grpService.findByGroupName(userReq.getGroupName());
			Groups newGroup=null;
			UserGroups newUserGroup = null;
			List<UserGroups> userGroups = owner.getGroups();
			if(newGroupo.isEmpty()) {
				newGroup = new Groups(userReq.getGroupId(), userReq.getGroupName(), owner.getUsername(), 1);
				grpService.save(newGroup);
				
				UserGroupId uGId = new UserGroupId(userReq.getUserId(), userReq.getGroupId());
				newUserGroup = new UserGroups(uGId);
				newUserGroup.setGroup(newGroup);
				newUserGroup.setUser(owner);
				userGroups.add(newUserGroup);
				owner.setGroups(userGroups);
				owner = service.save(owner); 
			}
			for(UserGroups usrGrp : owner.getGroups()) {
				
				usrGrp.setUser(null);
				usrGrp.getGroup().setUserGroups(null);
			}
		}catch(Exception e) {
			throw e;
		}
		return owner;
	}
	
	@RequestMapping("/getGroupsbyUserId")
	public List<Groups> getGroupsByUserId(@RequestBody String userId){
		
		List<Groups> grps = null;
		
		try {
			grps = service.getGroupsByUserId(userId);
			for(Groups usrGrp : grps) {
				usrGrp.setUserGroups(null);
			}
			return grps;
		}catch(Exception e) { 
			throw e;
		}
		
	}
	
	@GetMapping("/getGroupDetailsById/{groupId}")
	public Groups getGroupDetailsById(@PathVariable String groupId) {
		Optional<Groups> grp = null;
		try {
			grp = this.grpService.findById(groupId);
			if(grp.isEmpty()) {
				return null;
			}
			grp.get().setUserGroups(null);
			return grp.get();
		}catch(Exception e) {
			throw e;
		}
	}
	
}
