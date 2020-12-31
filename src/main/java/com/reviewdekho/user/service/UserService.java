package com.reviewdekho.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.user.dao.UserDao;
import com.reviewdekho.user.model.User;

@Service
public class UserService {
	private UserDao userDao;
	
	public UserService( @Qualifier("user") UserDao userDao ) {
		this.userDao = userDao;
	}
	
	public void add( User user ) {
		userDao.add(user);
	}
	
	public List<User> get() {
		return userDao.get();
	}
	
	public User getById( Integer user_id ) {
		return userDao.getById(user_id);
	}
	
	public User getByEmailId( final String email_id ) {
		return userDao.getByEmailId( email_id );
	}
	
	public User getByUserName( final String userName ) {
		return userDao.getByUserName( userName );
	}
	
	public void update( User user, Integer user_id ) { 
		userDao.update(user, user_id);
	}
	
	public void updateRole( User user, Integer user_id ) { 
		userDao.updateRole(user, user_id);
	}
	
	public void forgotPassword( User user, Integer user_id ) { 
		userDao.forgotPassword(user, user_id);
	}
	
	public void delete( Integer user_id ) {
		userDao.delete(user_id);
	}
}
