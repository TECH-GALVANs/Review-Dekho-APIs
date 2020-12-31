package com.reviewdekho.reviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.reviewer.dao.ReviewerDao;
import com.reviewdekho.reviewer.dao.ReviewerDaoI;
import com.reviewdekho.reviewer.model.Reviewer;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Service
public class ReviewerService {
	private ReviewerDao dao;
	
	@Autowired
	public ReviewerService( @Qualifier("reviewer") ReviewerDao dao ) {
		this.dao = dao;
	}
	
	public Reviewer add( Reviewer reviewer ) {
		return dao.add(reviewer);
	}
	
	public List<Reviewer> get() {
		return dao.get();
	}
	
	public Reviewer get( Integer reviewer_id ) {
		return dao.get(reviewer_id);
	}
	
	public Reviewer update( Reviewer reviewer, Integer reviewer_id ) { 
		return dao.update(reviewer_id, reviewer);
	}
	
	public void delete( Integer reviewer_id ) {
		dao.delete(reviewer_id);
	}
	
	public User getUserById( Integer userId ) {
		return dao.getUserById(userId);
	}
}
