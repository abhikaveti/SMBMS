package com.UserApplication.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDAO extends SimpleJpaRepository<User, String>{
	
	
	
	public UserDAO(EntityManager entityManager) {
		super(User.class, entityManager);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	EntityManager em;
	
	public List<Groups> getGroupsByUserId(String userId){
		
		List<Groups> grps = null;
		
		try {
			Query qu = em.createNamedQuery("getGroupsByUserId", User.class);
			qu.setParameter("userID", userId);
			grps = qu.getResultList();
			return grps;
		}
		catch(Exception e) {throw e;}
		
	}
	
}
