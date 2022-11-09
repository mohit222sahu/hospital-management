package com.innoeye.hospitalmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innoeye.hospitalmanagementsystem.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	@Query(value="select * from user where username=?1",nativeQuery=true)
	User getUserDetailsByParameters(String userName);
	
}
