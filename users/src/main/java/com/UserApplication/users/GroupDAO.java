package com.UserApplication.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface GroupDAO extends JpaRepository<Groups, String>{


	public Optional<Groups> findByGroupName(String groupName);
	
}
