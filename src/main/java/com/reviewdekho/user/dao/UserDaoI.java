package com.reviewdekho.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reviewdekho.user.model.User;

public interface UserDaoI extends JpaRepository<User, Integer> {
	@Query( "select user from User user where email_id= :email_id" )
	public User find( @Param( "email_id" ) final String email_id );
	
	@Query( "select user from User user where user_name= :user_name" )
	public User findByuserName( @Param( "user_name" ) final String user_name );
}
