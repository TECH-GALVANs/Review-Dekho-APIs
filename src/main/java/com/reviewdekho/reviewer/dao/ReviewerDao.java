package com.reviewdekho.reviewer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.reviewer.model.Reviewer;
import com.reviewdekho.user.dao.UserDaoI;
import com.reviewdekho.user.model.User;

@Repository("reviewer")
public class ReviewerDao  {
	@Autowired
	private ReviewerDaoI dao;
	
	@Autowired
	UserDaoI userRepo;
	
	public Reviewer add( Reviewer reviewer ) {
		return dao.save(reviewer);
	}
	
	public List<Reviewer> get(){
		return dao.findAll();
	}
	
	public Reviewer get( Integer reviewerId ) {
		return dao.findById(reviewerId).orElse(null);
	}
	
	public Reviewer update( Integer reviewerId, Reviewer reviewer ) {
		Reviewer reviewerT = get(reviewerId);
		reviewerT.setReviewer_status( reviewer.getReviewer_status() );
		return dao.save( reviewerT );
	}
	
	public void delete( Integer reviewerId ) {
		dao.deleteById( reviewerId );
	}
	
	public User getUserById( Integer userId ) {
		return userRepo.findById(userId).orElse(null);
	}
}
