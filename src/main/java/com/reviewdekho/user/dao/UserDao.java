package com.reviewdekho.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.user.model.User;

@Repository( "user" )
public class UserDao {
	@Autowired
	UserDaoI userDao;
	
	public int add( User user ) {
		userDao.save( user );
		return 1;
	}
	
	public List< User > get(){
		return userDao.findAll();
	}
	
	public User getById( Integer user_id ) {
		return userDao.findById( user_id ).orElse(null);
	}
	
	public User getByEmailId( final String email_id ) {
		if( userDao.find( email_id ) != null ) {
			return userDao.find( email_id );
		}
		return null;
		
	}
	
	public User getByUserName( final String userName ) {
		if( userDao.findByuserName(userName) != null ) {
			return userDao.findByuserName(userName);
		}
		
		return null;
	}
	
	public int update( User user, final Integer user_id ) {
		User userTo = getById(user_id);
		
		userTo.setUser_name( user.getUser_name() );

		userDao.save( userTo );
		
		return 1;
	}
	
	public User updateRole( User user, Integer userId ) {
		User userT = getById( userId );
		userT.setUser_role( user.getUser_role() );
		
		return userDao.save(userT);
	}
	
	public int forgotPassword( User user, Integer user_id ) {
		User userTo = getById(user_id);		
		
		userTo.setPassword( user.getPassword() );
		
		userDao.save( userTo );
		
		return 1;
	}
	
	public int delete( final Integer user_id ) {
		userDao.deleteById( user_id );
		return 1;
	}
}
