package com.mindtree.loginApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.loginApp.entity.User;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.name=?1 and u.password=?2")
	public User findByNamePassword(String name,String password);
	
}
